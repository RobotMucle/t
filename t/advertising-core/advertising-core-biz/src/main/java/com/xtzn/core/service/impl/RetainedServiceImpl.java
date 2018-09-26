package com.xtzn.core.service.impl;

import com.xtzn.core.mapper.IRetainedListMapper;
import com.xtzn.core.service.IRetainedListService;
import com.xtzn.core.vo.RetainedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * 留存serviceImpl
 *
 * @author zyw
 * @version [版本号, 2018年3月20日]
 */
@Service
public class RetainedServiceImpl implements IRetainedListService {

    @Autowired
    private IRetainedListMapper retainedListDao;

    /**
     * 功能描述: <br>
     * 清空留存
     *
     * @author zyw
     * @version [版本号, 2018年3月20日]
     */
    @Override
    public int updateEmptyRetained() {

        return retainedListDao.updateEmptyRetained();
    }

    /**
     * 功能描述: <br>
     * 插入新数据
     *
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    @Override
    public int insertRetained(String subId) {

        return retainedListDao.insertRetained(subId);
    }

    /**
     * 功能描述: <br>
     * 留存信息上传数据库
     *
     * @author zyw
     * @version [版本号, 2018年4月3日]
     */
    @Override
    public int updateRetained(Map<String, Object> map) {

        return retainedListDao.updateRetained(map);
    }

    /**
     * 功能描述: <br>
     * 派发留存任务获取可做留存,从昨日往前依次获取
     *
     * @author zyw
     * @version [版本号, 2018年4月3日]
     */
    @Override
    public RetainedResponse selectRetainedData(Integer userId, String upload) {

        return retainedListDao.selectRetainedData(userId, upload);
    }

    /**
     * 功能描述: <br>
     * 留存二次登陆数据
     *
     * @author zyw
     * @version [版本号, 2018年4月3日]
     */
    @Override
    public List<RetainedResponse> selectRetainedSecondLoginData(Integer userId, String upload) {

        return retainedListDao.selectRetainedSecondLoginData(userId, upload);
    }

    /**
     * 功能描述: <br>
     * 将留存过期数据没有返回值的数据还原
     *
     * @author zyw
     * @version [版本号, 2018年4月4日]
     */
    @Override
    public int updateBatchOverdueRetained(List<Map<String, Object>> list) {

        return retainedListDao.updateBatchOverdueRetained(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月26日]
     */
    @Override
    public int updateDistributeRetained(Integer id) {

        return retainedListDao.updateDistributeRetained(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月11日]
     */
    @Override
    public List<Map<String, Object>> selectYestodayUndo() {

        return retainedListDao.selectYestodayUndo();
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月24日]
     */
    @Override
    public List<Map<String, Object>> selectGroupByTaskId1(Integer taskId) {

        return retainedListDao.selectGroupByTaskId1(taskId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月24日]
     */
    @Override
    public List<Map<String, Object>> selectGroupByTaskId2(Integer taskId) {

        return retainedListDao.selectGroupByTaskId2(taskId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月24日]
     */
    @Override
    public int updateRetainedStatusForUsual1(Integer taskId, Integer daysCnt, Integer taskCnt) {

        return retainedListDao.updateRetainedStatusForUsual1(taskId, daysCnt, taskCnt);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月24日]
     */
    @Override
    public int updateRetainedStatusForUsual2(Integer taskId, Integer daysCnt, Integer taskCnt) {

        return retainedListDao.updateRetainedStatusForUsual2(taskId, daysCnt, taskCnt);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月24日]
     */
    @Override
    public int updateRetainedStatusForSpecial1(Integer taskId, Integer daysCnt, Integer taskCnt) {

        return retainedListDao.updateRetainedStatusForSpecial1(taskId, daysCnt, taskCnt);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月24日]
     */
    @Override
    public int updateRetainedStatusForSpecial2(Integer taskId, Integer daysCnt, Integer taskCnt) {

        return retainedListDao.updateRetainedStatusForSpecial2(taskId, daysCnt, taskCnt);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月24日]
     */
    @Override
    public int updateLevelType1(Integer taskId, Byte levelType, Integer limit) {

        return updateLevelType1(taskId, levelType, limit);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月24日]
     */
    @Override
    public int updateLevelType2(Integer taskId, Byte levelType, Integer limit) {

        return retainedListDao.updateLevelType2(taskId, levelType, limit);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月24日]
     */
    @Override
    public int updateLevelRetained1(Integer taskId, Integer daysCnt, Byte levelType, Integer taskCnt) {

        return retainedListDao.updateLevelRetained1(taskId, daysCnt, levelType, taskCnt);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月24日]
     */
    @Override
    public int updateLevelRetained2(Integer taskId, Integer daysCnt, Byte levelType, Integer taskCnt) {

        return updateLevelRetained2(taskId, daysCnt, levelType, taskCnt);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月24日]
     */
    @Override
    public int updateMorrowLevelType1(Integer taskId, Integer daysCnt) {

        return retainedListDao.updateMorrowLevelType1(taskId, daysCnt);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月24日]
     */
    @Override
    public int updateMorrowLevelType2(Integer taskId, Integer daysCnt) {

        return retainedListDao.updateMorrowLevelType2(taskId, daysCnt);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月24日]
     */
    @Override
    public int updateEverydayLevelRetained1(Integer taskId, Integer daysCnt) {

        return retainedListDao.updateEverydayLevelRetained1(taskId, daysCnt);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月24日]
     */
    @Override
    public int updateEverydayLevelRetained2(Integer taskId, Integer daysCnt) {

        return retainedListDao.updateEverydayLevelRetained2(taskId, daysCnt);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月15日]
     */
    @Override
    public Integer selectYestodayUndoByUserId(Integer userId) {

        return retainedListDao.selectYestodayUndoByUserId(userId);
    }


}
