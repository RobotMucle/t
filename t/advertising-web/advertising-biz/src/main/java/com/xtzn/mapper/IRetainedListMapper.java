package com.xtzn.mapper;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月19日]
 */

import com.xtzn.mapper.entity.RetainedList;
import com.xtzn.vo.TaskRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IRetainedListMapper {

    public List<Map<String, Object>> selectRetainedListForManage(TaskRequest taskRequest);

    public Integer selectCountForManage(TaskRequest taskRequest);

    public int insertRetainedList(RetainedList retainedList);

    public int updateRetainedList(RetainedList retainedList);

    public int deleteByCondition(TaskRequest taskRequest);

    public int deleteBatchById(@Param("list") List<Integer> list);

    public List<Map<String, Object>> selectRetaiedListForReport(TaskRequest taskRequest);

    public Integer selectCountForReport(TaskRequest taskRequest);

    public int updateRetainedListForlua(RetainedList retainedList);

    public List<RetainedList> selectRetainedListForReplaceUploadPath(RetainedList retainedList);

    public List<Map<String, Object>> selectRetainedListdtlForReport(@Param("taskId") Integer taskId, @Param("uploadTime") String uploadTime, @Param("userId") Integer userId, @Param("pageSize") Integer pageSize, @Param("skips") Integer skips);

    public Integer selectCountByRetainedListdtlForReport(@Param("taskId") Integer taskId, @Param("uploadTime") String uploadTime, @Param("userId") Integer userId);

    public Integer selectYestodayDoTaskCount(@Param("userId") Integer userId);

    public Integer selectTodayDoTaskCount(@Param("userId") Integer userId);

    public int updateIsSuccessBySubId(@Param("subId") String subId);

    public String selectSubId(@Param("subId") String subId);

    public String selectUploadPath(@Param("subId") String subId);


}
