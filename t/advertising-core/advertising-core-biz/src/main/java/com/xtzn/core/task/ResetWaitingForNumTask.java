package com.xtzn.core.task;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.simple.AbstractSimpleElasticJob;
import com.xtzn.core.service.ITaskListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * 功能描述: <br>
 * <p>
 * 整点重置等待执行数
 *
 * @author zyw
 * @version [版本号, 2018年6月9日]
 */
@Component
public class ResetWaitingForNumTask extends AbstractSimpleElasticJob {

    private static final Logger log = LoggerFactory.getLogger(ResetWaitingForNumTask.class);


    @Autowired
    private ITaskListService taskListService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月9日]
     */
    @Override
    public void process(JobExecutionMultipleShardingContext shardingContext) {

        log.info("整点重置等待执行数任务开始");

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour == 0 || hour == 1 || hour == 2) {
            //0,1,2
            taskListService.updateWaitingForNumEmpty100();
            log.info("指定时间等待执行数任务 hour:{}", hour);

        } else {
            taskListService.updateWaitingForNumEmpty();
            log.info("整点重置等待执行数任务 hour:{}", hour);

        }

        taskListService.updateWaitingForNumByCPA();

        log.info("整点重置等待执行数任务结束");

    }

}
