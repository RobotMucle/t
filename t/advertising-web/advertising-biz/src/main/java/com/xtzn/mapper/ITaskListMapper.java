package com.xtzn.mapper;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月18日]
 */

import com.xtzn.mapper.entity.TaskList;
import com.xtzn.vo.TaskRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ITaskListMapper {

    public List<TaskList> selectTaskListByPage(TaskRequest taskRequest);

    public TaskList selectTaskListById(@Param("id") Integer id);

    public int deleteById(@Param("id") Integer id);

    public int deleteBatchById(@Param("list") List<Integer> list);

    public int updateBatchById(@Param("list") List<Integer> list);

    public int insertTaskList(TaskList taskList);

    public int updateTaskList(TaskList taskList);

    public Integer selectCount(TaskRequest taskRequest);

    public int updateLinkStateById(TaskList taskList);

    public int updateFinishNum(@Param("id") Integer id);

    public int updateLinkState(@Param("linkState") Byte linkState, @Param("type") Byte type, @Param("userId") Integer userId);

    public int updateTaskListCPI(@Param("list") List<Integer> list, @Param("waitingForNum") Integer waitingForNum, @Param("crMin") Double crMin, @Param("crMax") Double crMax,
                                 @Param("crValue") Double crValue, @Param("playTimeMin") Integer playTimeMin, @Param("playTimeMax") Integer playTimeMax, @Param("targetNum") Integer targetNum, @Param("status") Byte status);

    public Integer selectFinishNumForHomepage(@Param("userId") Integer userId);

    public Integer selectTargrtNumForHomepage(@Param("userId") Integer userId);
}
