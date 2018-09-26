package com.xtzn.mapper;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月26日]
 */

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface IRetainedListenningMapper {

    public int updateRetainedListenningOverdue(@Param("retainedId") Integer retainedId);

    public Date selectDistributeTime(@Param("retainedId") Integer retainedId);
}
