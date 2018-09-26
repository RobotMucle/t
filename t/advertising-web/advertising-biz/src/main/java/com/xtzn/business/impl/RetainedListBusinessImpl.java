package com.xtzn.business.impl;

import com.xtzn.business.IRetainedListBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.common.Constant;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.RetainedList;
import com.xtzn.service.IRetainedListService;
import com.xtzn.service.IRetainedRecordService;
import com.xtzn.vo.TaskRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月19日]
 */
@Component
public class RetainedListBusinessImpl implements IRetainedListBusiness {

    private static final Logger log = LoggerFactory.getLogger(RetainedListBusinessImpl.class);
    @Autowired
    private IRetainedListService retainedListService;
    @Autowired
    private IRetainedRecordService retainedRecordService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public CSResponse selectRetainedListForManage(TaskRequest taskRequest) {
        if (taskRequest.getDateRange() != null && !taskRequest.getDateRange().equals("")) {
            String dateRange = taskRequest.getDateRange();
            String[] dateRanges = dateRange.split("~");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date startTime = sdf.parse(dateRanges[0]);
                Date endTime = sdf.parse(dateRanges[1]);
                taskRequest.setStartTime(startTime);
                taskRequest.setEndTime(endTime);

            } catch (ParseException e) {
                log.info("时间错误");
            }
        }
        taskRequest.setPageSize(Constant.pageSize);
        taskRequest.setSkips((taskRequest.getPageIndex() - 1) * taskRequest.getPageSize());
        List<Map<String, Object>> list = retainedListService.selectRetainedListForManage(taskRequest);
        log.info(list.toString());
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = retainedListService.selectCountForManage(taskRequest);
            map.put("count", count);
            map.put("data", list);
            if (map != null) {
                return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) map);
            }
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月20日]
     */
    @Override
    public CSResponse deleteBatchById(List<Integer> list) {
        int i = retainedListService.deleteBatchById(list);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月20日]
     */
    @Override
    public CSResponse deleteByCondition(TaskRequest taskRequest) {
        if (taskRequest.getDateRange() != null && !taskRequest.getDateRange().equals("")) {
            String dateRange = taskRequest.getDateRange();
            String[] dateRanges = dateRange.split("~");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date startTime = sdf.parse(dateRanges[0]);
                Date endTime = sdf.parse(dateRanges[1]);
                taskRequest.setStartTime(startTime);
                taskRequest.setEndTime(endTime);

            } catch (ParseException e) {
                log.info("时间错误");
            }
        }
        int i = retainedListService.deleteByCondition(taskRequest);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月21日]
     */
    @Override
    public CSResponse selectRetaiedListForReport(TaskRequest taskRequest) {
        if (taskRequest.getDateRange() != null && !taskRequest.getDateRange().equals("")) {
            String dateRange = taskRequest.getDateRange();
            String[] dateRanges = dateRange.split("~");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date startTime = sdf.parse(dateRanges[0]);
                Date endTime = sdf.parse(dateRanges[1]);
                taskRequest.setStartTime(startTime);
                taskRequest.setEndTime(endTime);

            } catch (ParseException e) {
                log.info("时间错误");
            }
        }
        taskRequest.setPageSize(Constant.pageSize);
        taskRequest.setSkips((taskRequest.getPageIndex() - 1) * taskRequest.getPageSize());
        List<Map<String, Object>> list = retainedListService.selectRetaiedListForReport(taskRequest);
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = retainedListService.selectCountForReport(taskRequest);
            map.put("count", count);
            map.put("data", list);
            if (map != null) {
                return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) map);
            }
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());

    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public CSResponse selectRetaiedListForReportdtl(Integer taskId, String uploadTime, Integer userId,
                                                    Integer pageIndex) {
        Integer pageSize = Constant.pageSize;
        Integer skips = (pageIndex - 1) * pageSize;
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = sdf.parse(uploadTime);
		} catch (ParseException e) {
			return new CSResponse(ResponseEnum.ERROR.getCode(),ResponseEnum.ERROR.getDesc());
		}*/
        List<Map<String, Object>> list = retainedListService.selectRetainedListdtlForReport(taskId, uploadTime, userId, pageSize, skips);
        if (!list.isEmpty()) {
            Integer count = retainedListService.selectCountByRetainedListdtlForReport(taskId, uploadTime, userId);
            Map<String, Object> map = new HashMap<>();
            map.put("data", list);
            map.put("count", count);
            map.put("pageSize", pageSize);
            return new CSResponse((Serializable) map);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月3日]
     */
    @Override
    public CSResponse selectRetainedRecordByCondition(TaskRequest taskRequest) {
        if (taskRequest.getDateRange() != null && !taskRequest.getDateRange().equals("")) {
            String dateRange = taskRequest.getDateRange();
            String[] dateRanges = dateRange.split("~");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date startTime = sdf.parse(dateRanges[0]);
                Date endTime = sdf.parse(dateRanges[1]);
                taskRequest.setStartTime(startTime);
                taskRequest.setEndTime(endTime);

            } catch (ParseException e) {
                log.info("时间错误");
            }
        }
        taskRequest.setPageSize(Constant.pageSize);
        taskRequest.setSkips((taskRequest.getPageIndex() - 1) * taskRequest.getPageSize());
        List<Map<String, Object>> list = retainedRecordService.selectRetainedRecordByCondition(taskRequest);
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = retainedRecordService.selectRetainedRecordCountByCondition(taskRequest);
            map.put("count", count);
            map.put("data", list);
            if (map != null) {
                return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) map);
            }
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月18日]
     */
    @Override
    public CSResponse updateIsSuccessBySubId(String subId) {
        String curSubId = retainedListService.selectSubId(subId);
        if (null == curSubId) {
            RetainedList retainedList = new RetainedList();
            retainedList.setSubId(subId);
            retainedList.setIsSuccess(Constant.status_1);
            retainedListService.insertRetainedList(retainedList);
            return new CSResponse();
        }
        int i = retainedListService.updateIsSuccessBySubId(subId);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月27日]
     */
    @Override
    public CSResponse selectUploadPath(String subId) {
        String upload = retainedListService.selectUploadPath(subId);
        if (null == upload) {
            return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
        }
        return new CSResponse(upload);
    }

}
