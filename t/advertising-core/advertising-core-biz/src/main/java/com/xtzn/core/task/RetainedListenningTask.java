package com.xtzn.core.task;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.simple.AbstractSimpleElasticJob;
import com.xtzn.core.enums.ResponseEnum;
import com.xtzn.core.service.IRetainedListService;
import com.xtzn.core.service.IRetainedListenningService;
import com.xtzn.core.vo.CSResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月2日]
 */
@Component
public class RetainedListenningTask extends AbstractSimpleElasticJob {

    @Autowired
    private IRetainedListenningService retainedListenningService;

    @Autowired
    private IRetainedListService retainedListService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    @Override
    public void process(JobExecutionMultipleShardingContext shardingContext) {

        //查询 根据当前时间-任务派发出去时间 > 29分钟的 RETAINED_ID

        Integer integer = retainedListenningService.selectCount();

        List<Map<String, Object>> addressList = new ArrayList<>();
        while (integer > 0) {

            List<Map<String, Object>> list = retainedListenningService.selectOverdueRetained();
            if (list.isEmpty()) {
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> ruleAddress = new HashMap<String, Object>();
                ruleAddress.put("retainedId", list.get(i).get("retainedId"));
                addressList.add(ruleAddress);
            }
            retainedListenningService.updateOverdueRetained(addressList);
            retainedListService.updateBatchOverdueRetained(list);

            integer = retainedListenningService.selectCount();
            addressList = null;
        }


    }
}


