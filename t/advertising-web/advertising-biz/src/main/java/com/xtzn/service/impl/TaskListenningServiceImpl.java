package com.xtzn.service.impl;

import com.xtzn.mapper.ITaskListenningMapper;
import com.xtzn.service.ITaskListenningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月21日]
 */
@Service
public class TaskListenningServiceImpl implements ITaskListenningService {

    @Autowired
    private ITaskListenningMapper taskListenningDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月21日]
     */
    @Override
    public int updateByResultTask(Integer taskId, String phoneCode) {

        return taskListenningDao.updateByResultTask(taskId, phoneCode);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月21日]
     */
    @Override
    public Date selectDistributeTime(Integer taskId, String phoneCode) {

        return taskListenningDao.selectDistributeTime(taskId, phoneCode);
    }

}
