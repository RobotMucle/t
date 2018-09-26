package com.xtzn.service;

import java.util.Date;

/**
 * 功能描述: <br>
 * 监控派发任务数据处理
 *
 * @author zyw
 * @version [版本号, 2018年4月2日]
 */
public interface ITaskListenningService {

    /**
     * 功能描述: <br>
     * 对有结果的派发出去的任务解除监控
     *
     * @param taskId    任务id
     * @param phoneCode 手机编号
     * @author zyw
     * @version [版本号, 2018年4月6日]
     */
    public int updateByResultTask(Integer taskId, String phoneCode);

    /**
     * 功能描述: <br>
     * 查询监控时间
     *
     * @param
     * @author zyw
     * @version [版本号, 2018年4月6日]
     */
    public Date selectDistributeTime(Integer taskId, String phoneCode);

}
