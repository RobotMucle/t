package com.xtzn.business.impl;

import com.xtzn.business.IPortListBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.common.Constant;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.service.IPortListService;
import com.xtzn.vo.DataRequest;
import com.xtzn.vo.PortRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月23日]
 */
@Component
public class PortListBusinessImpl implements IPortListBusiness {

    @Autowired
    private IPortListService portListService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月23日]
     */
    @Override
    public CSResponse insertBatchPortList(PortRequest portRequest) {
        Integer portStart = portRequest.getPortStart();
        Integer portEnd = portRequest.getPortEnd();
        String port;
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = portStart; i <= portEnd; i++) {
            Map<String, Object> map = new HashMap<>();
            port = String.valueOf(i);
            map.put("port", port);
            String httpPort = "24" + port.substring(port.length() - 3, port.length());
            map.put("httpPort", httpPort);
            map.put("groupName", portRequest.getGroupName());
            map.put("groupPassword", portRequest.getGroupPassword());
            map.put("serverAddress", portRequest.getServerAddress());
            map.put("serverPort", portRequest.getServerPort());
            map.put("userId", portRequest.getUserId());
            list.add(map);
            System.out.println(list.toString());
        }
        portListService.insertBatchPortList(list);
        return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月24日]
     */
    @Override
    public CSResponse selectPortListByGroup(DataRequest dataRequest) {
        dataRequest.setPageSize(Constant.pageSize);
        dataRequest.setSkips((dataRequest.getPageIndex() - 1) * dataRequest.getPageSize());
        List<Map<String, Object>> list = portListService.selectPortListByPage(dataRequest);
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = portListService.selectCount(dataRequest);
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
     * @version [版本号, 2018年4月24日]
     */
    @Override
    public CSResponse selectPortListInfo(PortRequest portRequest) {
        portRequest.setPageSize(Constant.pageSize);
        portRequest.setSkips((portRequest.getPageIndex() - 1) * Constant.pageSize);
        List<Map<String, Object>> list = portListService.selectPortListInfo(portRequest);
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = portListService.selectCountForPortListInfo(portRequest);
            map.put("pageSize", Constant.pageSize);
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
     * @version [版本号, 2018年4月24日]
     */
    @Override
    public CSResponse updatePortList(PortRequest portRequest) {
        int i = portListService.updatePortList(portRequest);
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
     * @version [版本号, 2018年4月24日]
     */
    @Override
    public CSResponse deleteBatchByCondition(PortRequest portRequest) {
        int i = portListService.deleteBatchByCondition(portRequest);
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
     * @version [版本号, 2018年4月24日]
     */
    @Override
    public CSResponse updatePhoneCode(PortRequest portRequest) {
        int i = portListService.updatePhoneCode(portRequest);
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
     * @version [版本号, 2018年4月25日]
     */
    @Override
    public CSResponse selectPortListByServerAddress(PortRequest portRequest) {
        Map<String, Object> map = portListService.selectPortListByServerAddress(portRequest);
        if (null != map) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) map);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

}
