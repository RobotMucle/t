package com.xtzn.core.task;


import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.simple.AbstractSimpleElasticJob;
import com.xtzn.core.enums.ResponseEnum;
import com.xtzn.core.service.ITaskListService;
import com.xtzn.core.utils.MinuteUtil;
import com.xtzn.core.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * 每日0点重置任务状态为1的时间线具体方案
 *
 * @author zyw
 * @version [版本号, 2018年3月20日]
 */
@Component
public class ResetTask extends AbstractSimpleElasticJob {

    private static final Logger log = LoggerFactory.getLogger(ResetTask.class);
    @Autowired
    private ITaskListService taskListService;

    @Override
    public void process(JobExecutionMultipleShardingContext arg0) {
        //昨日任务总数
        List<Map<String, Object>> totalList = taskListService.selectTargetNumSum();
        if (!totalList.isEmpty() && null != totalList) {
            for (int i = 0; i < totalList.size(); i++) {
                RedisUtil.hsetString("taskTargetNum", String.valueOf(totalList.get(i).get("userId")), String.valueOf(totalList.get(i).get("targetNum")));
            }
        }
        //清空已完成数
        //根据STATUS = 1 or STATUS = 2（任务状态：1:正常,2:禁用,3:已删除）
        // 更新task_list表里的数据FINISH_NUM（已完成数量）= 0,CLICK_NUM（点击总数） = 0
        taskListService.updateFinishNumEmpty();
        //根据STATUS = 1 or STATUS = 2（任务状态：1:正常,2:禁用,3:已删除）
        // 查询task_list表里的数据
        List<Map<String, Object>> list = taskListService.selectForResetTask();
        if (list.isEmpty()) {
            log.info(ResponseEnum.TASK_RESET_ERROR.getCode(), ResponseEnum.TASK_RESET_ERROR.getDesc());
        }
        int perct = 0;
        String timeline = "";
        int targetNum = 0;
        double d = 0;
        for (int i = 0; i < list.size(); i++) {
            //获得设置的时间线方案
            timeline = (String) list.get(i).get("timeline");
            //任务目标数
            targetNum = (Integer) list.get(i).get("targetNum");
            //获得该小时任务百分比
            //按逗号分割timeline，放入str数组里
            String[] str = timeline.split(",");
            String timelinedtl = "";
            for (int j = 0; j < str.length; j++) {
                d = Double.parseDouble(str[j]);
                //该小时任务目标数
                perct = (int) Math.ceil(d * targetNum / 100);
                //该小时时间线具体方案
                //log.info(MinuteUtil.getMinuteRandomValue(perct));
                if (j == 23 && perct == 0) {
                    perct = 1;
                }
                timelinedtl = timelinedtl + MinuteUtil.getMinuteRandomValue(perct) + ";";
            }
            //各小时方案拼接
            timelinedtl = timelinedtl.substring(0, timelinedtl.length() - 1);
            list.get(i).put("timelinedtl", timelinedtl);

        }
        //根据id更新task_list表里的timelinedtl数据
        taskListService.updateTimelinedtl(list);
    }


}
