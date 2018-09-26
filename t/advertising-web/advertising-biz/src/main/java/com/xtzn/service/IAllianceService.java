package com.xtzn.service;

import com.xtzn.mapper.entity.Alliance;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月10日]
 */
public interface IAllianceService {

    /**
     * 功能描述: <br>
     * 根据页码获取联盟信息
     *
     * @param pageSize 页面大小
     * @param skips    从条数据开始
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public List<Alliance> selectAllianceByPageIndex(Integer userId, Integer skips, Integer pageSize);

    /**
     * 功能描述: <br>
     * 管理员根据页码获取联盟信息
     *
     * @param pageSize 页面大小
     * @param skips    从条数据开始
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public List<Map<String, Object>> selectAllAllianceByPageIndex(Integer skips, Integer pageSize);

    /**
     * 功能描述: <br>
     * 查看单个联盟信息
     *
     * @param id 联盟id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public Alliance selectAllianceById(Integer id);

    /**
     * 功能描述: <br>
     * 更新联盟信息
     *
     * @param alliance 联盟信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateAllianceContent(Alliance alliance);

    /**
     * 功能描述: <br>
     * 更新联盟状态
     *
     * @param status 联盟状态
     * @param id     时区id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateAllianceStatus(Byte status, Integer id);

    /**
     * 功能描述: <br>
     * 删除单个联盟信息
     *
     * @param id 要删除的联盟id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteById(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除联盟信息
     *
     * @param list 要删除的联盟id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteBatchById(List<Integer> list);

    /**
     * 功能描述: <br>
     * 插入新的联盟信息
     *
     * @param alliance 联盟信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int insertAlliance(Alliance alliance);

    /**
     * 功能描述: <br>
     * 在使用的联盟名称
     *
     * @author zyw
     * @version [版本号, 2018年4月13日]
     */
    public List<String> selectUsingAllianceName(Integer userId);

    /**
     * 功能描述: <br>
     * 根据联盟名称获取联盟标识
     *
     * @param
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    public List<Alliance> selectAllianceByName(Integer userId, String affiliateAccountName);

    /**
     * 功能描述: <br>
     * 在使用的联盟信息
     *
     * @author zyw
     * @version [版本号, 2018年4月13日]
     */
    public List<Alliance> selectUsingAlliance(Integer userId);

    public Integer selectCount(Integer userId);

    public Integer selectAllCount();

}
