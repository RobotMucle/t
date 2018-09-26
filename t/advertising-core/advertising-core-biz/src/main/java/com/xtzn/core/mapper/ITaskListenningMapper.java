package com.xtzn.core.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * 监控派发任务数据处理
 *
 * @author zyw
 * @version [版本号, 2018年4月2日]
 */
public interface ITaskListenningMapper {

    /**
     * 功能描述: <br>
     * 插入新数据
     *
     * @param taskId    任务id
     * @param phoneCode 手机编号
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    public int insertTaskListenning(@Param("taskId") Integer taskId, @Param("phoneCode") String phoneCode);

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

    public List<Map<String, Object>> selectTaskByPhoneCode(@Param("phoneCode") String phoneCode);

    public int updateTaskByPhoneCode(@Param("phoneCode") String phoneCode);


}
