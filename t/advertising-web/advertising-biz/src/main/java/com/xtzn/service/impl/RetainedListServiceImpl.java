package com.xtzn.service.impl;

import com.xtzn.mapper.IRetainedListMapper;
import com.xtzn.mapper.entity.RetainedList;
import com.xtzn.service.IRetainedListService;
import com.xtzn.vo.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月19日]
 */
@Service
public class RetainedListServiceImpl implements IRetainedListService {

    @Autowired
    private IRetainedListMapper retainedListDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public List<Map<String, Object>> selectRetainedListForManage(TaskRequest taskRequest) {

        return retainedListDao.selectRetainedListForManage(taskRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public Integer selectCountForManage(TaskRequest taskRequest) {

        return retainedListDao.selectCountForManage(taskRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月20日]
     */
    @Override
    public int insertRetainedList(RetainedList retainedList) {

        return retainedListDao.insertRetainedList(retainedList);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月20日]
     */
    @Override
    public int updateRetainedList(RetainedList retainedList) {

        return retainedListDao.updateRetainedList(retainedList);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月20日]
     */
    @Override
    public int deleteByCondition(TaskRequest taskRequest) {

        return retainedListDao.deleteByCondition(taskRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月20日]
     */
    @Override
    public int deleteBatchById(List<Integer> list) {

        return retainedListDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月21日]
     */
    @Override
    public List<Map<String, Object>> selectRetaiedListForReport(TaskRequest taskRequest) {

        return retainedListDao.selectRetaiedListForReport(taskRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月21日]
     */
    @Override
    public Integer selectCountForReport(TaskRequest taskRequest) {

        return retainedListDao.selectCountForReport(taskRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public int updateRetainedListForlua(RetainedList retainedList) {

        return retainedListDao.updateRetainedListForlua(retainedList);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public List<RetainedList> selectRetainedListForReplaceUploadPath(RetainedList retainedList) {

        return retainedListDao.selectRetainedListForReplaceUploadPath(retainedList);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public List<Map<String, Object>> selectRetainedListdtlForReport(Integer taskId, String uploadTime, Integer userId,
                                                                    Integer pageSize, Integer skips) {

        return retainedListDao.selectRetainedListdtlForReport(taskId, uploadTime, userId, pageSize, skips);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public Integer selectCountByRetainedListdtlForReport(Integer taskId, String uploadTime, Integer userId) {

        return retainedListDao.selectCountByRetainedListdtlForReport(taskId, uploadTime, userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月16日]
     */
    @Override
    public Integer selectYestodayDoTaskCount(Integer userId) {

        return retainedListDao.selectYestodayDoTaskCount(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月16日]
     */
    @Override
    public Integer selectTodayDoTaskCount(Integer userId) {

        return retainedListDao.selectTodayDoTaskCount(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月18日]
     */
    @Override
    public int updateIsSuccessBySubId(String subId) {

        return retainedListDao.updateIsSuccessBySubId(subId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月27日]
     */
    @Override
    public String selectSubId(String subId) {

        return retainedListDao.selectSubId(subId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月27日]
     */
    @Override
    public String selectUploadPath(String subId) {

        return retainedListDao.selectUploadPath(subId);
    }

}
