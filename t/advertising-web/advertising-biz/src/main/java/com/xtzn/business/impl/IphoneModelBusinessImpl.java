package com.xtzn.business.impl;

import com.xtzn.business.IIphoneModelBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.common.Constant;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.IphoneModel;
import com.xtzn.service.IIphoneModelService;
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
 * @version [版本号, 2018年4月14日]
 */
@Component
public class IphoneModelBusinessImpl implements IIphoneModelBusiness {

    @Autowired
    private IIphoneModelService iphoneModelService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public CSResponse retrieveIphoneModelById(Integer id) {
        IphoneModel iphoneModel = iphoneModelService.selectIphoneModelById(id);
        if (null != iphoneModel) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) iphoneModel);
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
    public CSResponse retrieveIphoneModelByPage(CSRequest csRequest) {
        //不启用分页
        Integer pageSize = Constant.pageSize;
        Integer skips = (csRequest.getPageIndex() - 1) * pageSize;
        List<IphoneModel> list = iphoneModelService.selectIphoneModelByPage(skips, pageSize);
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = iphoneModelService.selectCount();
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
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public CSResponse createIphoneModel(IphoneModel iphoneModel) {
        int i = iphoneModelService.insertIphoneModel(iphoneModel);
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
    public CSResponse updateIphoneModel(IphoneModel iphoneModel) {
        int i = iphoneModelService.updateIphoneModel(iphoneModel);
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
    public CSResponse deleteById(Integer id) {
        int i = iphoneModelService.deleteById(id);
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
    public CSResponse deleteBatchById(List<Integer> list) {
        int i = iphoneModelService.deleteBatchById(list);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

}
