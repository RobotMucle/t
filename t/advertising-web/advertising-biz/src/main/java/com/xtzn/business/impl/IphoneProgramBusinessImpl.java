package com.xtzn.business.impl;

import com.xtzn.business.IIphoneProgramBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.common.Constant;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.IphoneProgram;
import com.xtzn.service.IIphoneProgramService;
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
 * @version [版本号, 2018年4月11日]
 */
@Component("iphoneProgramBusiness")
public class IphoneProgramBusinessImpl implements IIphoneProgramBusiness {

    @Autowired
    private IIphoneProgramService iphoneProgramService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月11日]
     */
    @Override
    public CSResponse retrieveIphoneProgramByPage(CSRequest csRequest) {
        Integer pageSize = Constant.pageSize;
        Integer skips = (csRequest.getPageIndex() - 1) * pageSize;
        List<Map<String, Object>> list = iphoneProgramService.selectIphoneProgramByPageIndex(csRequest.getUserId(), skips, pageSize);
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = iphoneProgramService.selectCount(csRequest.getUserId());
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
     * @version [版本号, 2018年4月11日]
     */
    @Override
    public CSResponse retrieveSingleIphoneProgram(Integer id) {
        IphoneProgram iphoneProgram = iphoneProgramService.selectIphoneProgramById(id);
        if (null != iphoneProgram) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) iphoneProgram);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月11日]
     */
    @Override
    public CSResponse updateIphoneProgram(IphoneProgram iphoneProgram) {
        int i = iphoneProgramService.updateIphoneProgramContent(iphoneProgram);
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
     * @version [版本号, 2018年4月11日]
     */
    @Override
    public CSResponse updateIphoneProgramByStatus(IphoneProgram iphoneProgram) {
        int i = iphoneProgramService.updateIphoneProgramStatus(iphoneProgram);
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
     * @version [版本号, 2018年4月11日]
     */
    @Override
    public CSResponse deleteSingleIphoneProgram(Integer id) {
        int i = iphoneProgramService.deleteById(id);
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
     * @version [版本号, 2018年4月11日]
     */
    @Override
    public CSResponse deleteBatchIphoneProgram(List<Integer> list) {
        int i = iphoneProgramService.deleteBatchById(list);
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
     * @version [版本号, 2018年4月11日]
     */
    @Override
    public CSResponse createIphoneProgram(IphoneProgram iphoneProgram) {
        int i = iphoneProgramService.insertIphoneProgram(iphoneProgram);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

}
