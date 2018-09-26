package com.xtzn.business;


import com.xtzn.click.vo.CSResponse;
import com.xtzn.vo.TaskRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月19日]
 */
public interface IRetainedListBusiness {

    public CSResponse selectRetainedListForManage(TaskRequest taskRequest);

    public CSResponse deleteBatchById(List<Integer> list);

    public CSResponse deleteByCondition(TaskRequest taskRequest);

    public CSResponse selectRetaiedListForReport(TaskRequest taskRequest);

    public CSResponse selectRetaiedListForReportdtl(Integer taskId, String uploadTime, Integer userId,
                                                    Integer pageIndex);

    public CSResponse selectRetainedRecordByCondition(TaskRequest taskRequest);

    public CSResponse updateIsSuccessBySubId(String subId);

    public CSResponse selectUploadPath(String subId);
}
