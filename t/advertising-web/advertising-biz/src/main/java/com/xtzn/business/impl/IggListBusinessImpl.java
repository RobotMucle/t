package com.xtzn.business.impl;

import com.xtzn.business.IIggListBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.common.Constant;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.IggList;
import com.xtzn.service.IIggListService;
import com.xtzn.vo.CSRequest;
import com.xtzn.vo.DataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月18日]
 */
@Component
public class IggListBusinessImpl implements IIggListBusiness {

    @Autowired
    private IIggListService iggListService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public CSResponse selectIggListByPage(DataRequest dataRequest) {
        dataRequest.setPageSize(Constant.pageSize);
        dataRequest.setSkips((dataRequest.getPageIndex() - 1) * dataRequest.getPageSize());
        List<IggList> list = iggListService.selectIggListByPage(dataRequest);
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = iggListService.selectCount(dataRequest);
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
    public CSResponse selectIggListById(Integer id) {
        IggList iggList = iggListService.selectIggListById(id);
        if (null != iggList) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) iggList);
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
        int i = iggListService.deleteById(id);
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
        int i = iggListService.deleteBatchById(list);
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
    public CSResponse insertBatchIggList(CSRequest csRequest) {
        String iggCodes = csRequest.getIggCodes();
        String[] iggCode = iggCodes.split("\n");
        List<String> list = Arrays.asList(iggCode);
        int i = iggListService.insertBatchIggList(list, csRequest.getUserId());
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
    public CSResponse updateIggList(IggList iggList) {
        int i = iggListService.updateIggList(iggList);
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
    public CSResponse updateIggListForOtherUse(List<Integer> list, String reason) {
        int i = iggListService.updateIggListForOtherUse(list, reason);
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
    public CSResponse selectUsingCount(Integer userId) {
        Integer i = iggListService.selectUsingCount(userId);
        return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), i);
    }

}
