package com.xtzn.mapper;

import com.xtzn.mapper.entity.RetainedRecord;
import com.xtzn.vo.TaskRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IRetainedRecordMapper {

    /**
     * 功能描述: <br>
     * 插入留存历史记录
     *
     * @param taskReport 留存历史记录数据
     * @author zyw
     * @version [版本号, 2018年4月6日]
     */
    public int insertRetainedReport(RetainedRecord retainedReport);

    public int updateRetainedCnt(RetainedRecord retainedReport);

    public List<Map<String, Object>> selectRetainedRecordByCondition(TaskRequest taskRequest);

    public Integer selectTodayDoRecordCount(@Param("userId") Integer userId);

    public Integer selectYestodayDoRecordCount(@Param("userId") Integer userId);

    public Integer selectFailureCount(@Param("userId") Integer userId);

    public Integer selectRetainedRecordCountByCondition(TaskRequest taskRequest);


}
