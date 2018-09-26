package com.xtzn.business.impl;

import com.xtzn.business.IAllianceBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.common.Constant;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.Alliance;
import com.xtzn.service.IAllianceService;
import com.xtzn.vo.CSRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月10日]
 */
@Component("allianceBusiness")
public class AllianceBusinessImpl implements IAllianceBusiness {

    @Autowired
    private IAllianceService allianceService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    @Override
    public CSResponse retrieveAllianceByPage(CSRequest csRequest) {
        Integer pageSize = Constant.pageSize;
        Integer skips = (csRequest.getPageIndex() - 1) * pageSize;
        List<Alliance> list = allianceService.selectAllianceByPageIndex(csRequest.getUserId(), skips, pageSize);
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = allianceService.selectCount(csRequest.getUserId());
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
     * @version [版本号, 2018年4月10日]
     */
    @Override
    public CSResponse retrieveSingleAlliance(Integer id) {
        Alliance map = allianceService.selectAllianceById(id);
        if (null != map) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) map);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    @Override
    public CSResponse updateAlliance(Alliance alliance) {
        int i = allianceService.updateAllianceContent(alliance);
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
     * @version [版本号, 2018年4月10日]
     */
    @Override
    public CSResponse updateAllianceByStatus(Byte status, Integer id) {
        int i = allianceService.updateAllianceStatus(status, id);
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
     * @version [版本号, 2018年4月10日]
     */
    @Override
    public CSResponse deleteSingleAlliance(Integer id) {
        int i = allianceService.deleteById(id);
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
     * @version [版本号, 2018年4月10日]
     */
    @Override
    public CSResponse deleteBatchAlliance(List<Integer> list) {
        int i = allianceService.deleteBatchById(list);
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
     * @version [版本号, 2018年4月10日]
     */
    @Override
    public CSResponse createAlliance(Alliance alliance) {
        int i = allianceService.insertAlliance(alliance);
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
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public CSResponse retrieveUsingAllianceName(Alliance alliance) {
        List<String> list = allianceService.selectUsingAllianceName(alliance.getUserId());
        if (!list.isEmpty()) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) list);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public CSResponse retrieveAllianceByName(Alliance alliance) {
        List<Alliance> list = allianceService.selectAllianceByName(alliance.getUserId(), alliance.getAffiliateAccountName());
        if (!list.isEmpty()) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) list);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public CSResponse retrieveUsingAlliance(Alliance alliance) {
        List<Alliance> list = allianceService.selectUsingAlliance(alliance.getUserId());
        if (!list.isEmpty()) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) list);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月25日]
     */
    @Override
    public CSResponse retrieveAllAllianceByPage(CSRequest csRequest) {
        Integer pageSize = Constant.pageSize;
        Integer skips = (csRequest.getPageIndex() - 1) * pageSize;
        List<Map<String, Object>> list = allianceService.selectAllAllianceByPageIndex(skips, pageSize);
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = allianceService.selectAllCount();
            map.put("data", list);
            map.put("count", count);
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) map);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

}
