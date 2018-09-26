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

import java.util.*;

/**
 * 功能描述: <br>
 * 派发任务
 *
 * @author zyw
 * @version [版本号, 2018年3月20日]
 */
@Component
public class DistributeTask extends AbstractSimpleElasticJob {

    private static final Logger log = LoggerFactory.getLogger(DistributeTask.class);

    @Autowired
    private ITaskListService taskListService;

    /**
     * 功能描述: <br>
     * 每个30秒执行一次
     *
     * @author zyw
     * @version [版本号, 2018年3月20日]
     */
    @Override
    public void process(JobExecutionMultipleShardingContext shardingContext) {

        log.info(">>>>>>>>>开始派发任务");

        // 获得任务list
        List<Map<String, Object>> list = taskListService.selectForDistributeTask();
        if (list.isEmpty()) {
            return;
        }
        List<Integer> taskList = new ArrayList<Integer>();
        String timelinedtl = null;
        Integer taskId = null;
        String zone = null;
        //ZoneId america = null;
        Calendar calendar = new GregorianCalendar();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).get("TASK_MODEL").equals(1)) {
                    return;
                }
                //获得该任务的时间线具体详情
                timelinedtl = (String) list.get(i).get("TIMELINEDTL");
                //获得任务Id
                taskId = (Integer) list.get(i).get("ID");
                zone = (String) list.get(i).get("TIMEZONE");
                if (null == zone) {
                    continue;
                }
                TimeZone timeZone = TimeZone.getTimeZone(zone);
                //ZoneId america = ZoneId.of(zone);
                calendar.setTimeZone(timeZone);
                //localTime = LocalDateTime.now(america);
                //int hour = localTime.getHour();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                //int minute = localTime.getMinute();
                int minute = calendar.get(Calendar.MINUTE);
                String[] hours = timelinedtl.split(";");

                //fix bug by gzq on 2018-9-4 数组越界
                //如果该小时内没有任务，则hours[hour]=""
                if (hours.length > hour && !"".equals(hours[hour])) {
                    String[] minutes = hours[hour].split(",");
                    for (int j = 0; j < minutes.length; j++) {
                        //当前分钟时间域设置的分钟时间一致，派发任务
                        if (minute == Integer.parseInt(minutes[j])) {
                            taskList.add(taskId);
                        }
                    }
                }
            }
        }
        if (!taskList.isEmpty()) {
            taskListService.updateBatchWaitingForNumAdd(taskList);
        }

        log.info(">>>>>>>>>结束派发任务");

    }


}
