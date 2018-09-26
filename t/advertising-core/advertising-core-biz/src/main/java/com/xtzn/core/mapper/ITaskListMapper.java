package com.xtzn.core.mapper;

import com.xtzn.core.vo.TaskResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ITaskListMapper {

    //重置任务
    List<Map<String, Object>> selectForResetTask();

    /**
     * 功能描述: <br>
     * 根据id更新数据库的时间线方案详情
     *
     * @param id          任务id
     * @param timelinedtl 时间线方案详情
     * @author zyw
     * @version [版本号, 2018年3月19日]
     */
    int updateTimelinedtl(@Param("list") List<Map<String, Object>> list);

    /**
     * 功能描述: <br>
     * 查询今日需要分派的任务id,timelinedtl
     *
     * @author zyw
     * @version [版本号, 2018年3月20日]
     */
    List<Map<String, Object>> selectForDistributeTask();

    /**
     * 功能描述: <br>
     * 根据生成的留存类型查询所有的任务id
     *
     * @param generateRetainedType 生成留存的类型
     * @author zyw
     * @version [版本号, 2018年3月20日]
     */
    List<Map<String, Object>> selectByGenerateRetainedType1(@Param("generateRetainedType") Byte type);

    /**
     * 功能描述: <br>
     * 根据生成的留存类型查询所有的任务id
     *
     * @param generateRetainedType 生成留存的类型
     * @author zyw
     * @version [版本号, 2018年3月20日]
     */
    List<Map<String, Object>> selectByGenerateRetainedType2(@Param("generateRetainedType") Byte type);

    /**
     * 功能描述: <br>
     * 查询抢量模式可以执行的任务
     *
     * @author zyw
     * @version [版本号, 2018年3月29日]
     */
    List<TaskResponse> selectRobTaskData(@Param("userId") Integer userId, @Param("modelRank") Byte modelRank);

    /**
     * 功能描述: <br>
     * 查询普通模式可以执行的任务
     *
     * @author zyw
     * @version [版本号, 2018年3月30日]
     */
    List<TaskResponse> selectNormalTaskData(@Param("linkState") Byte linkState, @Param("type") Byte type, @Param("userId") Integer userId);

    /**
     * 功能描述: <br>
     * 派发任务后更新任务待执行数
     *
     * @param id 任务id
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    int updateDistributeTaskWatingForNum(@Param("id") Integer id);

    int updateBatchDistributeTaskWatingForNum(@Param("list") List<Integer> list);

    /**
     * 功能描述: <br>
     * list批量更新待执行任务数
     *
     * @param list
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    int updateBatchWaitingForNumAdd(@Param("list") List<Integer> list);

    int updateLinkStateNormal();

    List<Map<String, Object>> selectTargetNumSum();

    List<Map<String, Object>> selectFinishNumSum();

    int updateFinishNumEmpty();

    int updateWaitingForNumEmpty();

    Integer selectRobTaskCount(@Param("userId") Integer userId);

    int updateWaitingForNumByCPA();

    int updateWaitingForNumEmpty100();

    List<Map<String, Object>> selectForTimeQuantum();

    int updateForTimeQuantum(@Param("id") Integer id,@Param("waitingForNum") Integer waitingForNum);

}
