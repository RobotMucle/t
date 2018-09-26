package com.xtzn.core.business;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年6月11日]
 */

import com.xtzn.core.vo.CSResponse;

public interface ITaskTransformCheckBusiness {

    public CSResponse requestTaskData(String phoneCode, Integer userId);
}
