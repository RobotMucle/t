package com.xtzn.service;

import com.xtzn.mapper.entity.RetainedList;
import com.xtzn.vo.TaskRequest;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月19日]
 */
public interface IRetainedListService {

    public List<Map<String, Object>> selectRetainedListForManage(TaskRequest taskRequest);

    public Integer selectCountForManage(TaskRequest taskRequest);

    public int insertRetainedList(RetainedList retainedList);

    public int updateRetainedList(RetainedList retainedList);

    public int deleteByCondition(TaskRequest taskRequest);

    public int deleteBatchById(List<Integer> list);

    public List<Map<String, Object>> selectRetaiedListForReport(TaskRequest taskRequest);

    public Integer selectCountForReport(TaskRequest taskRequest);

    public int updateRetainedListForlua(RetainedList retainedList);

    public List<RetainedList> selectRetainedListForReplaceUploadPath(RetainedList retainedList);

    public List<Map<String, Object>> selectRetainedListdtlForReport(Integer taskId, String uploadTime, Integer userId, Integer pageSize, Integer skips);

    public Integer selectCountByRetainedListdtlForReport(Integer taskId, String uploadTime, Integer userId);

    public Integer selectYestodayDoTaskCount(Integer userId);

    public String selectSubId(String subId);

    public String selectUploadPath(String subId);

    public Integer selectTodayDoTaskCount(Integer userId);

    public int updateIsSuccessBySubId(String subId);
}
