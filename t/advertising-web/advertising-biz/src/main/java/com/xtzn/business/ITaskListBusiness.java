package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
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
public interface ITaskListBusiness {

    public CSResponse retrieveTaskListByPage(TaskRequest taskRequest);

    public CSResponse retrieveTaskListById(Integer id);

    public CSResponse deleteById(Integer id, Byte type);

    public CSResponse deleteBatchById(List<Integer> list);

    public CSResponse updateBatchById(List<Integer> list);

    public CSResponse insertTaskList(TaskList taskList);

    public CSResponse updateTaskList(TaskList taskList);

    public CSResponse updateLinkState(Byte linkState, Byte type, Integer userId);

    public CSResponse updateTaskListCPI(TaskList taskList, String ids);

    public CSResponse homePage(Integer userId);


}
