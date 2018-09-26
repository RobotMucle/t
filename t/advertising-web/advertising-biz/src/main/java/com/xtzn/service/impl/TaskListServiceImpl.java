package com.xtzn.service.impl;

import com.xtzn.mapper.ITaskListMapper;
import com.xtzn.mapper.entity.TaskList;
import com.xtzn.service.ITaskListService;
import com.xtzn.vo.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月18日]
 */
@Service
public class TaskListServiceImpl implements ITaskListService {

    @Autowired
    private ITaskListMapper taskListDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public List<TaskList> selectTaskListByPage(TaskRequest taskRequest) {

        return taskListDao.selectTaskListByPage(taskRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public TaskList selectTaskListById(Integer id) {

        return taskListDao.selectTaskListById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public int deleteById(Integer id) {

        return taskListDao.deleteById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public int deleteBatchById(List<Integer> list) {

        return taskListDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public int insertTaskList(TaskList taskList) {

        return taskListDao.insertTaskList(taskList);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public int updateTaskList(TaskList taskList) {

        return taskListDao.updateTaskList(taskList);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public Integer selectCount(TaskRequest taskRequest) {

        return taskListDao.selectCount(taskRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月26日]
     */
    @Override
    public int updateBatchById(List<Integer> list) {

        return taskListDao.updateBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月26日]
     */
    @Override
    public int updateLinkStateById(TaskList taskList) {

        return taskListDao.updateLinkStateById(taskList);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月26日]
     */
    @Override
    public int updateFinishNum(Integer id) {

        return taskListDao.updateFinishNum(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月10日]
     */
    @Override
    public int updateLinkState(Byte linkState, Byte type, Integer userId) {

        return taskListDao.updateLinkState(linkState, type, userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月10日]
     */
    @Override
    public int updateTaskListCPI(List<Integer> list, Integer waitingForNum, Double crMin, Double crMax, Double crValue,
                                 Integer playTimeMin, Integer playTimeMax, Integer targetNum, Byte status) {

        return taskListDao.updateTaskListCPI(list, waitingForNum, crMin, crMax, crValue, playTimeMin, playTimeMax, targetNum, status);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月11日]
     */
    @Override
    public Integer selectFinishNumForHomepage(Integer userId) {

        return taskListDao.selectFinishNumForHomepage(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月11日]
     */
    @Override
    public Integer selectTargrtNumForHomepage(Integer userId) {

        return taskListDao.selectTargrtNumForHomepage(userId);
    }

}
