package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.Country;
import com.xtzn.vo.CSRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * 国家信息业务
 *
 * @author zyw
 * @version [版本号, 2018年4月10日]
 */
public interface ICountryBusiness {

    /**
     * 功能描述: <br>
     * 根据页码获取国家信息
     *
     * @param pageIndex 页码
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveCountryByPage(CSRequest csRequest);

    /**
     * 功能描述: <br>
     * 查看单个国家信息
     *
     * @param id 联盟id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveSingleCountry(Integer id);

    /**
     * 功能描述: <br>
     * 更新国家信息
     *
     * @param name 国家名
     * @param id   国家id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateCountry(String name, Integer id);

    /**
     * 功能描述: <br>
     * 更新国家状态
     *
     * @param status 国家状态
     * @param id     国家id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateCountryByStatus(Byte status, Integer id);

    /**
     * 功能描述: <br>
     * 删除单个国家信息
     *
     * @param id 要删除的国家id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteSingleCountry(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除国家信息
     *
     * @param list 要删除的国家id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteBatchCountry(List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的国家信息
     *
     * @param name 联盟名
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public CSResponse createCountry(Country country);

    /**
     * 功能描述: <br>
     * 获取所有国家数据
     *
     * @author zyw
     * @version [版本号, 2018年4月13日]
     */
    public CSResponse retrieveUsingCountry(Country country);
}
