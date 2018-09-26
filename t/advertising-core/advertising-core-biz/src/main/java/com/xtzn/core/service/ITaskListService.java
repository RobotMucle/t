package com.xtzn.core.service;

import com.xtzn.core.vo.TaskResponse;

import java.util.List;
import java.util.Map;

public interface ITaskListService {


    /**
     * 功能描述: <br>
     * 查询重置任务需要的id,目标数，时间线方案，时间线方案详情
     *
     * @author zyw
     * @version [版本号, 2018年3月19日]
     */
    public List<Map<String, Object>> selectForResetTask();

    /**
     * 功能描述: <br>
     * 根据id更新数据库的时间线方案详情
     *
     * @param id          任务id
     * @param timelinedtl 时间线方案详情
     * @author zyw
     * @version [版本号, 2018年3月19日]
     */
    public int updateTimelinedtl(List<Map<String, Object>> list);

    /**
     * 功能描述: <br>
     * 查询今日需要分派的任务id,timelinedtl
     *
     * @author zyw
     * @version [版本号, 2018年3月20日]
     */
    public List<Map<String, Object>> selectForDistributeTask();

    /**
     * 功能描述: <br>
     * 根据生成的留存类型查询所有的任务id
     *
     * @param generateRetainedType 生成留存的类型
     * @author zyw
     * @version [版本号, 2018年3月20日]
     */
    public List<Map<String, Object>> selectByGenerateRetainedType1(Byte type);

    /**
     * 功能描述: <br>
     * 根据生成的留存类型查询所有的任务id
     *
     * @param generateRetainedType 生成留存的类型
     * @author zyw
     * @version [版本号, 2018年3月20日]
     */
    public List<Map<String, Object>> selectByGenerateRetainedType2(Byte type);

    /**
     * 功能描述: <br>
     * 查询抢量模式可以执行的任务
     *
     * @author zyw
     * @version [版本号, 2018年3月29日]
     */
    public List<TaskResponse> selectRobTaskData(Integer userId, Byte modelRank);

    /**
     * 功能描述: <br>
     * 查询普通模式可以执行的任务
     *
     * @author zyw
     * @version [版本号, 2018年3月30日]
     */
    public List<TaskResponse> selectNormalTaskData(Byte linkState, Byte type, Integer userId);

    /**
     * 功能描述: <br>
     * 派发任务后更新任务待执行数
     *
     * @param id 任务id
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    public int updateDistributeTaskWatingForNum(Integer id);

    public int updateBatchDistributeTaskWatingForNum(List<Integer> list);

    /**
     * 功能描述: <br>
     * list批量更新待执行任务数
     *
     * @param list
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    public int updateBatchWaitingForNumAdd(List<Integer> list);

    public int updateLinkStateNormal();

    public List<Map<String, Object>> selectTargetNumSum();

    public List<Map<String, Object>> selectFinishNumSum();

    public int updateFinishNumEmpty();

    public int updateWaitingForNumEmpty();

    public Integer selectRobTaskCount(Integer userId);

    public int updateWaitingForNumByCPA();

    /**
     * 指定时间段更改等待执行数为100  0，1，2
     *
     * @return
     */
    public int updateWaitingForNumEmpty100();

    public  List<Map<String, Object>> selectForTimeQuantum();

    public int updateForTimeQuantum(Integer id,Integer waitingForNum);

}
