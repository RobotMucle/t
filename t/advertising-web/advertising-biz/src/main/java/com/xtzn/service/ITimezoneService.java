package com.xtzn.service;

import com.xtzn.mapper.entity.Timezone;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月9日]
 */
public interface ITimezoneService {

    /**
     * 功能描述: <br>
     * 根据页码获取时区信息
     *
     * @param pageSize 页面大小
     * @param skips    从条数据开始
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public List<Timezone> selectTimezoneByPageIndex(Integer skips, Integer pageSize);

    /**
     * 功能描述: <br>
     * 查看单个时区信息
     *
     * @param id 时区id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public Timezone selectTimezoneById(Integer id);

    /**
     * 功能描述: <br>
     * 删除单个时区信息
     *
     * @param id 要删除的id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteById(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除时区信息
     *
     * @param list 要删除的id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteBatchById(List<Integer> list);

    /**
     * 功能描述: <br>
     * 插入新的时区信息
     *
     * @param timezone 数据信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int insertTimezone(Timezone timezone);

    /**
     * 功能描述: <br>
     * 更新时区状态
     *
     * @param status 时区状态
     * @param id     时区id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateTimezoneStatus(Byte status, Integer id);

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
    public int updateTimezoneContent(Timezone timezone);

    public Integer selectCount();
}
