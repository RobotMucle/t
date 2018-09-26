package com.xtzn.business;
/**
 * 功能描述: <br>
 * 时区业务
 *
 * @author zyw
 * @version [版本号, 2018年4月9日]
 */

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.Timezone;
import com.xtzn.vo.CSRequest;

import java.util.List;

public interface ITimezoneBusiness {

    /**
     * 功能描述: <br>
     * 根据页码获取时区信息
     *
     * @param pageIndex 页码
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveTimezoneByPage(CSRequest csRequest);

    /**
     * 功能描述: <br>
     * 查看单个时区信息
     *
     * @param id 时区id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveSingleTimezone(Integer id);

    /**
     * 功能描述: <br>
     * 更新时区信息
     *
     * @param country  国家
     * @param timezone 时区
     * @param id       时区id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateTimezone(Timezone timezone);

    /**
     * 功能描述: <br>
     * 更新时区状态
     *
     * @param status 时区状态
     * @param id     时区id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateTimezoneByStatus(Byte status, Integer id);

    /**
     * 功能描述: <br>
     * 删除单个时区信息
     *
     * @param id 要删除的id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteSingleTimezone(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除时区信息
     *
     * @param list 要删除的id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteBatchTimezone(List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的时区信息
     *
     * @param country  国家
     * @param timezone 时区
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public CSResponse createTimezone(Timezone timezone);
}
