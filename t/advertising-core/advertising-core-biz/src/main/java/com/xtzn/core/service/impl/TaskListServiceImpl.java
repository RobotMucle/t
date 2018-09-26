package com.xtzn.core.service.impl;

import com.xtzn.core.mapper.ITaskListMapper;
import com.xtzn.core.service.ITaskListService;
import com.xtzn.core.vo.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TaskListServiceImpl implements ITaskListService {

    @Autowired
    private ITaskListMapper taskListDao;

    @Override
    public List<Map<String, Object>> selectForResetTask() {

        return taskListDao.selectForResetTask();
    }

    @Override
    public int updateTimelinedtl(List<Map<String, Object>> list) {

        return taskListDao.updateTimelinedtl(list);
    }


    /**
     * 功能描述: <br>
     * 查询今日需要分派的任务id,timelinedtl
     *
     * @author zyw
     * @version [版本号, 2018年3月20日]
     */
    @Override
    public List<Map<String, Object>> selectForDistributeTask() {

        return taskListDao.selectForDistributeTask();
    }

    /**
     * 功能描述: <br>
     * 根据生成的留存类型查询所有的任务id
     *
     * @param generateRetainedType 生成留存的类型
     * @author zyw
     * @version [版本号, 2018年3月20日]
     */
    @Override
    public List<Map<String, Object>> selectByGenerateRetainedType1(Byte type) {

        return taskListDao.selectByGenerateRetainedType1(type);
    }

    @Override
    public List<Map<String, Object>> selectByGenerateRetainedType2(Byte type) {

        return taskListDao.selectByGenerateRetainedType2(type);
    }

    /**
     * 功能描述: <br>
     * 查询抢量模式可以执行的任务
     *
     * @author zyw
     * @version [版本号, 2018年3月30日]
     */
    @Override
    public List<TaskResponse> selectRobTaskData(Integer userId, Byte modelRank) {

        return taskListDao.selectRobTaskData(userId, modelRank);
    }

    /**
     * 功能描述: <br>
     * 查询普通模式可以执行的任务
     *
     * @author zyw
     * @version [版本号, 2018年3月30日]
     */
    @Override
    public List<TaskResponse> selectNormalTaskData(Byte linkState, Byte type, Integer userId) {

        return taskListDao.selectNormalTaskData(linkState, type, userId);
    }

    /**
     * 功能描述: <br>
     * 派发任务后更新任务待执行数
     *
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    @Override
    public int updateDistributeTaskWatingForNum(Integer id) {

        return taskListDao.updateDistributeTaskWatingForNum(id);
    }

    /**
     * 功能描述: <br>
     * 批量更新待执行任务数
     *
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    @Override
    public int updateBatchWaitingForNumAdd(List<Integer> list) {

        return taskListDao.updateBatchWaitingForNumAdd(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月21日]
     */
    @Override
    public int updateBatchDistributeTaskWatingForNum(List<Integer> list) {

        return taskListDao.updateBatchDistributeTaskWatingForNum(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月26日]
     */
    @Override
    public int updateLinkStateNormal() {

        return taskListDao.updateLinkStateNormal();
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月11日]
     */
    @Override
    public List<Map<String, Object>> selectTargetNumSum() {

        return taskListDao.selectTargetNumSum();
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月11日]
     */
    @Override
    public List<Map<String, Object>> selectFinishNumSum() {

        return taskListDao.selectFinishNumSum();
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月17日]
     */
    @Override
    public int updateFinishNumEmpty() {

        return taskListDao.updateFinishNumEmpty();
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月9日]
     */
    @Override
    public int updateWaitingForNumEmpty() {

        return taskListDao.updateWaitingForNumEmpty();
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月22日]
     */
    @Override
    public Integer selectRobTaskCount(Integer userId) {

        return taskListDao.selectRobTaskCount(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年7月3日]
     */
    @Override
    public int updateWaitingForNumByCPA() {

        return taskListDao.updateWaitingForNumByCPA();
    }

    /**
     * 指定时间段更改等待执行数为100  0，1，2
     *
     * @return
     */
    public int updateWaitingForNumEmpty100() {
        return taskListDao.updateWaitingForNumEmpty100();
    }


    public List<Map<String, Object>> selectForTimeQuantum() {
        return taskListDao.selectForTimeQuantum();
    }

    public int updateForTimeQuantum(Integer id,Integer waitingForNum) {
        return taskListDao.updateForTimeQuantum(id,waitingForNum);
    }






}
