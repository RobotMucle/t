package com.xtzn.core.task;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.simple.AbstractSimpleElasticJob;
import com.xtzn.core.service.ITaskListService;
import com.xtzn.core.service.ITaskListenningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月2日]
 */
@Component
public class DistributeListenningTask extends AbstractSimpleElasticJob {

    @Autowired
    private ITaskListenningService taskListenningService;
    @Autowired
    private ITaskListService taskListService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    @Override
    public void process(JobExecutionMultipleShardingContext shardingContext) {

        List<Map<String, Object>> list = taskListenningService.selectOverdueTask();
        if (!list.isEmpty()) {
            taskListenningService.updateOverdueTask();
            List<Integer> taskList = new ArrayList<Integer>();
            for (int i = 0; i < list.size(); i++) {
                taskList.add((Integer) list.get(i).get("taskId"));
            }
            taskListService.updateBatchWaitingForNumAdd(taskList);
        }
    }

}
