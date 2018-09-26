package com.xtzn.mapper;

import com.xtzn.mapper.entity.Country;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能描述: <br>
 * 国家相关curd
 *
 * @author zyw
 * @version [版本号, 2018年4月10日]
 */
public interface ICountryMapper {

    /**
     * 功能描述: <br>
     * 根据页码获取国家信息
     *
     * @param pageIndex 页码
     * @param skips     从哪条开始查询
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public List<Country> selectCountryByPageIndex(@Param("skips") Integer skips, @Param("pageSize") Integer pageSize);

    /**
     * 功能描述: <br>
     * 查看单个国家信息
     *
     * @param id 联盟id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public Country selectCountryById(@Param("id") Integer id);

    /**
     * 功能描述: <br>
     * 更新国家信息
     *
     * @param name 国家名
     * @param id   国家id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateCountryContent(@Param("name") String name, @Param("id") Integer id);

    /**
     * 功能描述: <br>
     * 更新国家状态
     *
     * @param status 国家状态
     * @param id     国家id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateCountryStatus(@Param("status") Byte status, @Param("id") Integer id);

    /**
     * 功能描述: <br>
     * 删除单个国家信息
     *
     * @param id 要删除的国家id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteById(@Param("id") Integer id);

    /**
     * 功能描述: <br>
     * 批量删除国家信息
     *
     * @param list 要删除的国家id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteBatchById(@Param("list") List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的国家信息
     *
     * @param name 联盟名
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public int insertCountry(Country country);

    /**
     * 功能描述: <br>
     * 获取所有国家数据
     *
     * @author zyw
     * @version [版本号, 2018年4月13日]
     */
    public List<Country> selectUsingCountry();

    public Integer selectCount();
}
