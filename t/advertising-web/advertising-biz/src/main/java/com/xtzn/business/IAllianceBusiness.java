package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.Alliance;
import com.xtzn.vo.CSRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * 联盟信息业务
 *
 * @author zyw
 * @version [版本号, 2018年4月10日]
 */
public interface IAllianceBusiness {

    /**
     * 功能描述: <br>
     * 普通用户根据页码获取联盟信息
     *
     * @param pageIndex 页码
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveAllianceByPage(CSRequest csRequest);

    /*
     * 管理员获取联盟信息
     */
    public CSResponse retrieveAllAllianceByPage(CSRequest csRequest);

    /**
     * 功能描述: <br>
     * 查看单个联盟信息
     *
     * @param id 联盟id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveSingleAlliance(Integer id);

    /**
     * 功能描述: <br>
     * 更新联盟信息
     *
     * @param affiliateAccountName 联盟名
     * @param affiliateAccountLogo 联盟标识
     * @param id                   时区id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateAlliance(Alliance alliance);

    /**
     * 功能描述: <br>
     * 更新联盟状态
     *
     * @param status 联盟状态
     * @param id     时区id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateAllianceByStatus(Byte status, Integer id);

    /**
     * 功能描述: <br>
     * 删除单个联盟信息
     *
     * @param id 要删除的联盟id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteSingleAlliance(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除联盟信息
     *
     * @param list 要删除的联盟id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteBatchAlliance(List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的联盟信息
     *
     * @param affiliateAccountName 联盟名
     * @param affiliateAccountLogo 联盟标识
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public CSResponse createAlliance(Alliance alliance);

    /**
     * 功能描述: <br>
     * 在使用的联盟名称
     *
     * @author zyw
     * @version [版本号, 2018年4月13日]
     */
    public CSResponse retrieveUsingAllianceName(Alliance alliance);

    /**
     * 功能描述: <br>
     * 根据联盟名称获取联盟信息
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    public CSResponse retrieveAllianceByName(Alliance alliance);

    /**
     * 功能描述: <br>
     * 在使用的联盟信息
     *
     * @author zyw
     * @version [版本号, 2018年4月13日]
     */
    public CSResponse retrieveUsingAlliance(Alliance alliance);
}
