package com.xtzn.service;

import java.util.Date;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月26日]
 */
public interface IRetainedListenningService {

    public int updateRetainedListenningOverdue(Integer retainedId);

    public Date selectDistributeTime(Integer retainedId);
}
