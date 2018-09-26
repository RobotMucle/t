package com.xtzn.core.business;
/**
 * 功能描述: <br>
 * 留存业务
 *
 * @author zyw
 * @version [版本号, 2018年4月2日]
 */

import com.xtzn.core.vo.CSResponse;

public interface IRetainedBusiness {

    public CSResponse requestRetainedData(Integer userId, Byte uploadType);

}
