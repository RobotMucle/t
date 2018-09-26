package com.xtzn.proxy;

import com.xtzn.click.business.IRunClickBusiness;
import com.xtzn.click.vo.CSResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年3月24日]
 */
@Component
public class RunClickBusinessProxy implements IRunClickBusiness {

    private static final Logger log = LoggerFactory.getLogger(RunClickBusinessProxy.class);

    @Autowired
    private IRunClickBusiness runClickBusiness;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年3月24日]
     */
    @Override
    public CSResponse runClick(Integer taskId, Integer userId) {
        log.info("dubbo...runclick param is  taskId is {}", taskId);
        CSResponse csResponse = runClickBusiness.runClick(taskId, userId);
        log.info("dubbo...csResponse is {}", csResponse);
        return csResponse;
    }

}
