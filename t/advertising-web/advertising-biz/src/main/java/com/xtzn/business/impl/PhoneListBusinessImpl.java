package com.xtzn.business.impl;

import com.xtzn.business.IPhoneListBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.common.Constant;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.PhoneList;
import com.xtzn.service.IPhoneListService;
import com.xtzn.vo.CSRequest;
import com.xtzn.vo.DataRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月18日]
 */
@Component
public class PhoneListBusinessImpl implements IPhoneListBusiness {

    private static final Logger log = LoggerFactory.getLogger(PhoneListBusinessImpl.class);

    @Autowired
    private IPhoneListService phoneListService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public CSResponse retrievePhoneListByPage(DataRequest dataRequest) {
        if (dataRequest.getDateRange() != null && !dataRequest.getDateRange().equals("")) {
            String dateRange = dataRequest.getDateRange();
            String[] dateRanges = dateRange.split("~");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date startTime = sdf.parse(dateRanges[0]);
                Date endTime = sdf.parse(dateRanges[1]);
                dataRequest.setStartTime(startTime);
                dataRequest.setEndTime(endTime);

            } catch (ParseException e) {
                log.info("时间错误");
            }
        }
        dataRequest.setPageSize(Constant.pageSize);
        dataRequest.setSkips((dataRequest.getPageIndex() - 1) * dataRequest.getPageSize());
        List<PhoneList> list = phoneListService.selectPhoneListByPage(dataRequest);
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = phoneListService.selectCount(dataRequest);
            map.put("data", list);
            map.put("count", count);
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) map);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public CSResponse retrievePhoneListById(Integer id) {
        PhoneList phoneList = phoneListService.selectPhoneListById(id);
        if (null != phoneList) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) phoneList);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public CSResponse deleteById(Integer id) {
        int i = phoneListService.deleteById(id);
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
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public CSResponse deleteBatchById(List<Integer> list) {
        int i = phoneListService.deleteBatchById(list);
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
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public CSResponse insertBatchPhoneList(CSRequest csRequest) {
        String phoneCodes = csRequest.getPhoneCodes();
        String[] phoneCode = phoneCodes.split("\n");
        List<String> list = Arrays.asList(phoneCode);
        int i = phoneListService.insertBatchPhoneList(list, csRequest.getUserId());
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
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public CSResponse updatePhoneList(PhoneList phoneList) {
        int i = phoneListService.updatePhoneList(phoneList);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

}
