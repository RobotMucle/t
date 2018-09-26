package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.AccountType;
import com.xtzn.vo.CSRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * 账号类型业务
 *
 * @author zyw
 * @version [版本号, 2018年4月11日]
 */
public interface IAccountTypeBusiness {

    /**
     * 功能描述: <br>
     * 根据页码获取账号类型
     *
     * @param pageIndex 页码
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveAccountTypeByPage(CSRequest csRequest);

    /**
     * 功能描述: <br>
     * 查看单个账号类型
     *
     * @param id 账号类型id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveSingleAccountType(Integer id);

    /**
     * 功能描述: <br>
     * 更新账号类型
     *
     * @param map 账号类型
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateAccountType(AccountType accountType);

    /**
     * 功能描述: <br>
     * 删除单个账号类型
     *
     * @param id 要删除的账号类型id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteSingleAccountType(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除账号类型
     *
     * @param list 要删除的账号类型id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteBatchAccountType(List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的账号类型
     *
     * @param map 账号类型
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public CSResponse createAccountType(AccountType accountType);

    /**
     * 功能描述: <br>
     * 查询所有账号类型
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    public CSResponse retrieveAllAccountType(AccountType accountType);
}
