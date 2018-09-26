package com.xtzn.core.service;

import java.util.List;
import java.util.Map;

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
     * 插入新数据
     *
     * @param taskId    任务id
     * @param phoneCode 手机编号
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    public int insertTaskListenning(Integer taskId, String phoneCode);

    /**
     * 功能描述: <br>
     * 定时处理过期派发出去的任务
     *
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    public int updateOverdueTask();

    /**
     * 功能描述: <br>
     * 查询过期派发出去的任务
     *
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    public List<Map<String, Object>> selectOverdueTask();

    public List<Map<String, Object>> selectTaskByPhoneCode(String phoneCode);

    public int updateTaskByPhoneCode(String phoneCode);


}
