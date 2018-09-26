package com.xtzn.proxy;


import com.xtzn.core.business.ITaskBusiness;
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
 * @version [版本号, 2018年3月29日]
 */
@Component
public class TaskBusinessProxy implements ITaskBusiness {

    private static final Logger log = LoggerFactory.getLogger(TaskBusinessProxy.class);

    @Autowired
    private ITaskBusiness taskBusiness;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年3月29日]
     */
    @Override
    public CSResponse requestTaskData(String phoneCode, Byte type, Integer userId) {
        log.info("dubbo...getTaskData param is  taskId is {}", "userId=" + userId + "...phoneCode=" + phoneCode + "...type=" + type);
        CSResponse csResponse = taskBusiness.requestTaskData(phoneCode, type, userId);
        log.info("dubbo...csResponse is {}", csResponse);
        return csResponse;
    }


}
