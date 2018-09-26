package com.xtzn.proxy;

import com.xtzn.core.business.IRetainedBusiness;
import com.xtzn.core.vo.CSResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月12日]
 */
@Component
public class RetainedBusinessProxy implements IRetainedBusiness {

    private static final Logger log = LoggerFactory.getLogger(RetainedBusinessProxy.class);

    @Autowired
    private IRetainedBusiness retainedBusiness;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月21日]
     */
    @Override
    public CSResponse requestRetainedData(Integer userId, Byte uploadType) {
        log.info("dubbo...getRetainedData param is  userId is {}", userId);
        CSResponse csResponse = retainedBusiness.requestRetainedData(userId, uploadType);
        log.info("dubbo...csResponse is {}", csResponse);
        return csResponse;
    }


}
