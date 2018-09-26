package com.xtzn.service;

import com.xtzn.mapper.entity.RetainedRecord;
import com.xtzn.vo.TaskRequest;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月6日]
 */
public interface IRetainedRecordService {

    /**
     * 功能描述: <br>
     * 插入留存历史记录
     *
     * @param taskReport 留存历史记录数据
     * @author zyw
     * @version [版本号, 2018年4月6日]
     */
    public int insertRetainedReport(RetainedRecord retainedRecord);

    public int updateRetainedCnt(RetainedRecord retainedRecord);

    public List<Map<String, Object>> selectRetainedRecordByCondition(TaskRequest taskRequest);

    public Integer selectTodayDoRecordCount(Integer userId);

    public Integer selectYestodayDoRecordCount(Integer userId);

    public Integer selectFailureCount(Integer userId);

    public Integer selectRetainedRecordCountByCondition(TaskRequest taskRequest);
}
