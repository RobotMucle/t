package com.xtzn.core.task;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.simple.AbstractSimpleElasticJob;
import com.xtzn.core.service.ITaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年5月10日]
 */
@Component
public class ResetLinkStateTask extends AbstractSimpleElasticJob {

    @Autowired
    private ITaskListService taskListService;

    /**
     * 功能描述: <br>
     * **
     *根据LINK_STATE = 0
     * 更新task_list表里的LINK_STATE=1
     * @author zyw
     * @version [版本号, 2018年5月10日]
     */
    @Override
    public void process(JobExecutionMultipleShardingContext shardingContext) {
        //根据LINK_STATE = 0（1:正常0:变身2app需要更新,3:(针对注册任务)账号用完）
        //更新task_list表里的LINK_STATE = 1（1:正常0:变身2app需要更新,3:(针对注册任务)账号用完）
        taskListService.updateLinkStateNormal();
    }

}
