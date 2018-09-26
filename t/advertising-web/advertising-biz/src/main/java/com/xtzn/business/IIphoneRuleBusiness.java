package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.IphoneRule;
import com.xtzn.vo.CSRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * ftp地址及规则业务
 *
 * @author zyw
 * @version [版本号, 2018年4月11日]
 */
public interface IIphoneRuleBusiness {

    /**
     * 功能描述: <br>
     * 根据页码获取ftp地址及规则信息
     *
     * @param pageIndex 页码
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveIphoneRuleByPage(CSRequest csRequest);

    /**
     * 功能描述: <br>
     * 查看单个ftp地址及规则信息
     *
     * @param id ftp地址及规则id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveSingleIphoneRule(Integer id);

    /**
     * 功能描述: <br>
     * 更新ftp地址及规则信息
     *
     * @param map ftp地址及规则相关信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateIphoneRule(IphoneRule iphoneRule);

    /**
     * 功能描述: <br>
     * 更新ftp地址及规则
     *
     * @param id ftp地址及规则id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateIphoneRuleByStatus(Integer id, Byte status);

    /**
     * 功能描述: <br>
     * 删除单个ftp地址及规则信息
     *
     * @param id 要删除的ftp地址及规则id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteSingleIphoneRule(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除ftp地址及规则信息
     *
     * @param list 要删除的ftp地址及规则id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteBatchIphoneRule(List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的ftp地址及规则信息
     *
     * @param map ftp地址及规则相关信息
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public CSResponse createIphoneRule(IphoneRule iphoneRule);
}
