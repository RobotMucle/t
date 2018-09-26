package com.xtzn.business.impl;

import com.xtzn.business.ITimezoneBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.common.Constant;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.Timezone;
import com.xtzn.service.ITimezoneService;
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
 * @version [版本号, 2018年4月9日]
 */
@Component("timezoneBusiness")
public class TimezoneBusinessImpl implements ITimezoneBusiness {

    @Autowired
    private ITimezoneService timezoneService;

    /**
     * 功能描述: <br>
     * 根据页码获取时区信息
     *
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    @Override
    public CSResponse retrieveTimezoneByPage(CSRequest csRequest) {
        Integer pageSize = Constant.pageSize;
        Integer skips = (csRequest.getPageIndex() - 1) * pageSize;
        List<Timezone> list = timezoneService.selectTimezoneByPageIndex(skips, pageSize);
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = timezoneService.selectCount();
            map.put("data", list);
            map.put("count", count);
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) map);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * 查看单个时区信息
     *
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    @Override
    public CSResponse retrieveSingleTimezone(Integer id) {
        Timezone map = timezoneService.selectTimezoneById(id);
        if (null != map) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) map);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());

    }

    /**
     * 功能描述: <br>
     * 更新时区信息
     *
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    @Override
    public CSResponse updateTimezone(Timezone timezone) {
        int i = timezoneService.updateTimezoneContent(timezone);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * 更新时区状态
     *
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    @Override
    public CSResponse updateTimezoneByStatus(Byte status, Integer id) {
        int i = timezoneService.updateTimezoneStatus(status, id);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * 删除单个时区信息
     *
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    @Override
    public CSResponse deleteSingleTimezone(Integer id) {
        int i = timezoneService.deleteById(id);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * 批量删除时区信息
     *
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    @Override
    public CSResponse deleteBatchTimezone(List<Integer> list) {
        int i = timezoneService.deleteBatchById(list);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * 创建新的时区信息
     *
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    @Override
    public CSResponse createTimezone(Timezone timezone) {
        int i = timezoneService.insertTimezone(timezone);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

}
