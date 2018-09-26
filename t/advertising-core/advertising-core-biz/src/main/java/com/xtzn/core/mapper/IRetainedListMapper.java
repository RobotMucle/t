package com.xtzn.core.mapper;

import com.xtzn.core.vo.RetainedResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * 留存表增删查改
 *
 * @author zyw
 * @version [版本号, 2018年3月20日]
 */
public interface IRetainedListMapper {
    /**
     * 功能描述: <br>
     * 清空留存
     *
     * @author zyw
     * @version [版本号, 2018年3月20日]
     */
    public int updateEmptyRetained();

    /**
     * 功能描述: <br>
     * 根据taskId查询该任务的留存 上传天数以及对应的任务数量
     *
     * @param taskId 任务id
     * @author zyw
     * @version [版本号, 2018年3月22日]
     */
    public List<Map<String, Object>> selectGroupByTaskId1(@Param("taskId") Integer taskId);

    public List<Map<String, Object>> selectGroupByTaskId2(@Param("taskId") Integer taskId);

    /**
     * 功能描述: <br>
     * 更新普通任务留存状态
     *
     * @param taskId  任务Id
     * @param usedCnt 留存已使用次数
     * @param daysCnt 限定条件:哪日做的任务
     * @param taskCnt 今日该任务需要做多少条留存
     * @author zyw
     * @version [版本号, 2018年3月22日]
     */
    public int updateRetainedStatusForUsual1(@Param("taskId") Integer taskId, @Param("daysCnt") Integer daysCnt, @Param("taskCnt") Integer taskCnt);

    public int updateRetainedStatusForUsual2(@Param("taskId") Integer taskId, @Param("daysCnt") Integer daysCnt, @Param("taskCnt") Integer taskCnt);

    /**
     * 功能描述: <br>
     * 更新长时间任务留存状态
     *
     * @param taskId  任务Id
     * @param usedCnt 留存已使用次数
     * @param daysCnt 限定条件:哪日做的任务
     * @param taskCnt 今日该任务需要做多少条留存
     * @author zyw
     * @version [版本号, 2018年3月22日]
     */
    public int updateRetainedStatusForSpecial1(@Param("taskId") Integer taskId, @Param("daysCnt") Integer daysCnt, @Param("taskCnt") Integer taskCnt);

    public int updateRetainedStatusForSpecial2(@Param("taskId") Integer taskId, @Param("daysCnt") Integer daysCnt, @Param("taskCnt") Integer taskCnt);

    /**
     * 功能描述: <br>
     * 修改关卡留存type
     *
     * @param taskId    任务Id
     * @param levelType 类型
     * @param limit     数量
     * @author zyw
     * @version [版本号, 2018年3月23日]
     */
    public int updateLevelType1(@Param("taskId") Integer taskId, @Param("levelType") Byte levelType, @Param("limit") Integer limit);

    public int updateLevelType2(@Param("taskId") Integer taskId, @Param("levelType") Byte levelType, @Param("limit") Integer limit);

    /**
     * 功能描述: <br>
     * 更新关卡留存状态
     *
     * @param taskId    任务Id
     * @param daysCnt   限定条件:哪日做的任务
     * @param levelType 类型
     * @param taskCnt   今日该任务需要做多少条留存
     * @author zyw
     * @version [版本号, 2018年3月23日]
     */
    public int updateLevelRetained1(@Param("taskId") Integer taskId, @Param("daysCnt") Integer daysCnt, @Param("levelType") Byte levelType, @Param("taskCnt") Integer taskCnt);

    public int updateLevelRetained2(@Param("taskId") Integer taskId, @Param("daysCnt") Integer daysCnt, @Param("levelType") Byte levelType, @Param("taskCnt") Integer taskCnt);

    /**
     * 功能描述: <br>
     * 修改次日关卡留存type
     *
     * @param taskId  任务Id
     * @param daysCnt 限定条件:哪日做的任务
     * @author zyw
     * @version [版本号, 2018年3月23日]
     */
    public int updateMorrowLevelType1(@Param("taskId") Integer taskId, @Param("daysCnt") Integer daysCnt);

    public int updateMorrowLevelType2(@Param("taskId") Integer taskId, @Param("daysCnt") Integer daysCnt);

    /**
     * 功能描述: <br>
     * 更新每日关卡留存特定次数的状态
     *
     * @param taskId  任务Id
     * @param daysCnt 限定条件:哪日做的任务
     * @author zyw
     * @version [版本号, 2018年3月23日]
     */
    public int updateEverydayLevelRetained1(@Param("taskId") Integer taskId, @Param("daysCnt") Integer daysCnt);

    public int updateEverydayLevelRetained2(@Param("taskId") Integer taskId, @Param("daysCnt") Integer daysCnt);

    /**
     * 功能描述: <br>
     * 插入新数据
     *
     * @param subId 链接subId
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    public int insertRetained(@Param("subId") String subId);

    /**
     * 功能描述: <br>
     * 留存信息上传数据库
     *
     * @param map 留存信息
     * @author zyw
     * @version [版本号, 2018年4月3日]
     */
    public int updateRetained(Map<String, Object> map);

    /**
     * 功能描述: <br>
     * 派发留存任务获取可做留存,从昨日往前依次获取
     *
     * @author zyw
     * @version [版本号, 2018年4月3日]
     */
    public RetainedResponse selectRetainedData(@Param("userId") Integer userId, @Param("upload") String upload);

    /**
     * 功能描述: <br>
     * 留存二次登陆数据
     *
     * @author zyw
     * @version [版本号, 2018年4月3日]
     */
    public List<RetainedResponse> selectRetainedSecondLoginData(@Param("userId") Integer userId, @Param("upload") String upload);

    /**
     * 功能描述: <br>
     * 将留存过期数据没有返回值的数据还原
     *
     * @param list 需要更新的list
     * @author zyw
     * @version [版本号, 2018年4月4日]
     */
    public int updateBatchOverdueRetained(@Param("list") List<Map<String, Object>> list);

    public int updateDistributeRetained(@Param("id") Integer id);

    public List<Map<String, Object>> selectYestodayUndo();

    public Integer selectYestodayUndoByUserId(@Param("userId") Integer userId);

}
