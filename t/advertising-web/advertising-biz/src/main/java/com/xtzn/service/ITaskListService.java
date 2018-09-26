package com.xtzn.service;

import com.xtzn.mapper.entity.TaskList;
import com.xtzn.vo.TaskRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月18日]
 */
public interface ITaskListService {

    public List<TaskList> selectTaskListByPage(TaskRequest taskRequest);

    public TaskList selectTaskListById(Integer id);

    public int deleteById(Integer id);

    public int deleteBatchById(List<Integer> list);

    public int updateBatchById(List<Integer> list);

    public int insertTaskList(TaskList taskList);

    public int updateTaskList(TaskList taskList);

    public Integer selectCount(TaskRequest taskRequest);

    public int updateLinkStateById(TaskList taskList);

    public int updateFinishNum(Integer id);

    public int updateLinkState(Byte linkState, Byte type, Integer userId);

    public int updateTaskListCPI(List<Integer> list, Integer waitingForNum, Double crMin, Double crMax,
                                 Double crValue, Integer playTimeMin, Integer playTimeMax, Integer targetNum, Byte status);

    public Integer selectFinishNumForHomepage(Integer userId);

    public Integer selectTargrtNumForHomepage(Integer userId);

}
