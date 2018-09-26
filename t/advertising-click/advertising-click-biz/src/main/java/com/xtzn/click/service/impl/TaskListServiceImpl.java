package com.xtzn.click.service.impl;


import com.xtzn.click.mapper.ITaskListMapper;
import com.xtzn.click.mapper.entity.TaskList;
import com.xtzn.click.service.ITaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskListServiceImpl implements ITaskListService {

    @Autowired
    private ITaskListMapper taskListDao;

    /**
     * 功能描述: <br>
     * 查询任务的状态、国家、link等数据
     *
     * @param id 任务id
     * @author zyw
     * @version [版本号, 2018年3月16日]
     */
    @Override
    public TaskList selectForRunClick(Integer taskId) {

        return taskListDao.selectForRunClick(taskId);
    }

    /**
     * 功能描述: <br>
     * 更新点击数
     *
     * @param id 任务id
     * @author zyw
     * @version [版本号, 2018年3月16日]
     */
    @Override
    public void updateClickNum(Integer id) {

        taskListDao.updateClickNum(id);
    }

    /**
     * 功能描述: <br>
     * 更新点击状态
     *
     * @param id 任务id
     * @author zyw
     * @version [版本号, 2018年3月16日]
     */
    @Override
    public void updateIsUnlockClick(Integer id, Byte isUnlockClick) {

        taskListDao.updateIsUnlockClick(id, isUnlockClick);
    }


}
