/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年3月20日]
 */
package com.xtzn.core.task;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.simple.AbstractSimpleElasticJob;
import com.xtzn.core.service.ITaskListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * 更新每小时待执行任务数
 *
 * @author wsy
 * @version [版本号, 2018年3月20日]
 */
@Component
public class timeQuantumTask extends AbstractSimpleElasticJob {

    private static final Logger log = LoggerFactory.getLogger(timeQuantumTask.class);

    @Autowired
    private ITaskListService taskListService;

    /**
     * 功能描述: <br>
     * 每小时2分时执行任务
     * 更新待执行任务书数
     * @author wsy
     * @version [版本号, 2018年3月20日]
     */
    public void process(JobExecutionMultipleShardingContext shardingContext) {
        log.info(">>>>>>>>>开始更新每小时待执行任务数");
        //根据STATUS = 1 and LINK_STATE = 1 or LINK_STATE = 2 and TASK_MODEL = 1
        // 查询task_list表里的ID，TIMELINE字段
        List<Map<String, Object>> list = taskListService.selectForTimeQuantum();
        if (list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            //获取遍历后的每个list集合里的map集合里的k=ID的值
            int id = (Integer) list.get(i).get("ID");
            //获取遍历后的每个list集合里的map集合里的k=TIMELINE的值
            String timeLine = (String) list.get(i).get("TIMELINE");
            //按逗号分割字符串timeLine，放入timeLines数组里
            String[] timeLines = timeLine.split(",");
            for (int j = 0; j < timeLines.length; j++) {
                int waitingForNum = (int) Math.ceil(Double.parseDouble(timeLines[j]));
                //获取当前小时数
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
//                分割当前时间字符串字符串
//                Date date =new Date(System.currentTimeMillis());
//                SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:00:00 ");
//                String time = formatter.format(date);
//                String[] times = time.split(" ");
//                String h = times[1];
//                String[] s = h.split(":");
//                String z = s[0];
//                String s1 = String.valueOf(j);
                if (hour == j) {
                    //根据id更新taskList表里符合条件的待执行任务数
                    int row = taskListService.updateForTimeQuantum(id, waitingForNum);
                    if (row > 0) {
                        log.info(">>>>>>>>>结束更新待执行任务数"+i);
                    }
                }
            }
        }
    }


}
