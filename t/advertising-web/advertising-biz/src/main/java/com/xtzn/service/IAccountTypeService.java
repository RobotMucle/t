package com.xtzn.service;

import com.xtzn.mapper.entity.AccountType;

import java.util.List;

/**
 * 功能描述: <br>
 * 账号类型curd
 *
 * @author zyw
 * @version [版本号, 2018年4月11日]
 */
public interface IAccountTypeService {

    /**
     * 功能描述: <br>
     * 根据页码获取账号类型
     *
     * @param pageSize 页面大小
     * @param skips    从哪条数据开始
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public List<AccountType> selectAccountTypeByPageIndex(Integer userId, Integer skips, Integer pageSize);

    /**
     * 功能描述: <br>
     * 管理员根据页码获取账号类型
     *
     * @param pageSize 页面大小
     * @param skips    从哪条数据开始
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public List<AccountType> selectAllAccountTypeByPageIndex(Integer skips, Integer pageSize);

    /**
     * 功能描述: <br>
     * 查看单个账号类型
     *
     * @param id 账号类型id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public AccountType selectAccountTypeById(Integer id);

    /**
     * 功能描述: <br>
     * 更新账号类型
     *
     * @param map 账号类型相关信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateAccountTypeName(AccountType accountType);

    /**
     * 功能描述: <br>
     * 删除单个账号类型
     *
     * @param id 要删除的账号类型id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteById(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除账号类型
     *
     * @param list 要删除的账号类型id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteBatchById(List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的账号类型
     *
     * @param map 账号类型相关信息
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public int insertAccountType(AccountType accountType);

    /**
     * 功能描述: <br>
     * 查询所有账号类型
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    public List<AccountType> selectAllAccountType(Integer userId);

    public Integer selectCount(Integer userId);
}
