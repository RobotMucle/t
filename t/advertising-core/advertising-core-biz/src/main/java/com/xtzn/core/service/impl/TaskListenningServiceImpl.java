package com.xtzn.core.service.impl;

import com.xtzn.core.mapper.ITaskListenningMapper;
import com.xtzn.core.service.ITaskListenningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * 监控派发任务数据处理
 *
 * @author zyw
 * @version [版本号, 2018年4月2日]
 */
@Service
public class TaskListenningServiceImpl implements ITaskListenningService {

    @Autowired
    private ITaskListenningMapper taskListenningDao;

    /**
     * 功能描述: <br>
     * 插入新数据
     *
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    @Override
    public int insertTaskListenning(Integer taskId, String phoneCode) {

        return taskListenningDao.insertTaskListenning(taskId, phoneCode);
    }

    /**
     * 功能描述: <br>
     * 定时处理过期派发出去的任务
     *
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    @Override
    public int updateOverdueTask() {

        return taskListenningDao.updateOverdueTask();
    }

    /**
     * 功能描述: <br>
     * 查询过期派发出去的任务
     *
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    @Override
    public List<Map<String, Object>> selectOverdueTask() {

        return taskListenningDao.selectOverdueTask();
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月9日]
     */
    @Override
    public List<Map<String, Object>> selectTaskByPhoneCode(String phoneCode) {

        return taskListenningDao.selectTaskByPhoneCode(phoneCode);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月9日]
     */
    @Override
    public int updateTaskByPhoneCode(String phoneCode) {

        return taskListenningDao.updateTaskByPhoneCode(phoneCode);
    }


}
