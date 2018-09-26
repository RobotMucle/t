package com.xtzn.mapper;

import com.xtzn.mapper.entity.IphoneRule;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * ftp地址及规则curd
 *
 * @author zyw
 * @version [版本号, 2018年4月11日]
 */
public interface IIphoneRuleMapper {

    /**
     * 功能描述: <br>
     * 根据页码获取ftp地址及规则信息
     *
     * @param pageSize 页面大小
     * @param skips    从哪条数据开始
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public List<IphoneRule> selectIphoneRuleByPageIndex(@Param("userId") Integer userId, @Param("skips") Integer skips, @Param("pageSize") Integer pageSize);

    /**
     * 功能描述: <br>
     * 查看单个ftp地址及规则信息
     *
     * @param id ftp地址及规则 id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public IphoneRule selectIphoneRuleById(@Param("id") Integer id);

    /**
     * 功能描述: <br>
     * 更新ftp地址及规则信息
     *
     * @param map ftp地址及规则相关信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateIphoneRuleContent(IphoneRule iphoneRule);

    /**
     * 功能描述: <br>
     * 更换使用的ftp地址及规则
     *
     * @param id ftp地址及规则 id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateIphoneRuleStatus(@Param("id") Integer id, @Param("status") Byte status);

    /**
     * 功能描述: <br>
     * 删除单个ftp地址及规则信息
     *
     * @param id 要删除的ftp地址及规则 id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteById(@Param("id") Integer id);

    /**
     * 功能描述: <br>
     * 批量删除ftp地址及规则信息
     *
     * @param list 要删除的ftp地址及规则 id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteBatchById(@Param("list") List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的ftp地址及规则信息
     *
     * @param map ftp地址及规则相关信息
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public int insertIphoneRule(IphoneRule iphoneRule);

    public Integer selectCount(@Param("userId") Integer userId);

    public Map<String, Object> selectIphoneRuleForLua(@Param("userId") Integer userId);
}