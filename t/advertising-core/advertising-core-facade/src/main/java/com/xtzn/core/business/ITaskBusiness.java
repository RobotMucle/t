package com.xtzn.core.business;
/**
 * 功能描述: <br>
 * 任务业务
 *
 * @author zyw
 * @version [版本号, 2018年3月27日]
 */


import com.xtzn.core.vo.CSResponse;

public interface ITaskBusiness {

    /**
     *
     * 功能描述: <br>
     * 获取任务信息
     *
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    public CSResponse requestTaskData(String phoneCode, Byte type, Integer userId);


}
