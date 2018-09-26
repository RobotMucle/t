package com.xtzn.service.impl;

import com.xtzn.mapper.IRetainedListenningMapper;
import com.xtzn.service.IRetainedListenningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月26日]
 */
@Service
public class RetainedListenningServiceImpl implements IRetainedListenningService {

    @Autowired
    private IRetainedListenningMapper retainedListenningDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月26日]
     */
    @Override
    public int updateRetainedListenningOverdue(Integer retainedId) {

        return retainedListenningDao.updateRetainedListenningOverdue(retainedId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月26日]
     */
    @Override
    public Date selectDistributeTime(Integer retainedId) {

        return retainedListenningDao.selectDistributeTime(retainedId);
    }

}
