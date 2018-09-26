package com.xtzn.service.impl;

import com.xtzn.mapper.IRetainedRecordMapper;
import com.xtzn.mapper.entity.RetainedRecord;
import com.xtzn.service.IRetainedRecordService;
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
 * @version [版本号, 2018年4月26日]
 */
@Service
public class RetainedRecordServiceImpl implements IRetainedRecordService {

    @Autowired
    private IRetainedRecordMapper retainedReportDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月26日]
     */
    @Override
    public int insertRetainedReport(RetainedRecord retainedReport) {

        return retainedReportDao.insertRetainedReport(retainedReport);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月26日]
     */
    @Override
    public int updateRetainedCnt(RetainedRecord retainedReport) {

        return retainedReportDao.updateRetainedCnt(retainedReport);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月3日]
     */
    @Override
    public List<Map<String, Object>> selectRetainedRecordByCondition(TaskRequest taskRequest) {

        return retainedReportDao.selectRetainedRecordByCondition(taskRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月14日]
     */
    @Override
    public Integer selectTodayDoRecordCount(Integer userId) {

        return retainedReportDao.selectTodayDoRecordCount(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月14日]
     */
    @Override
    public Integer selectYestodayDoRecordCount(Integer userId) {

        return retainedReportDao.selectYestodayDoRecordCount(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月16日]
     */
    @Override
    public Integer selectFailureCount(Integer userId) {

        return retainedReportDao.selectFailureCount(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月19日]
     */
    @Override
    public Integer selectRetainedRecordCountByCondition(TaskRequest taskRequest) {

        return retainedReportDao.selectRetainedRecordCountByCondition(taskRequest);
    }

}
