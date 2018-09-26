package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.AppleAccount;
import com.xtzn.vo.DataRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * 苹果账号信息业务
 *
 * @author zyw
 * @version [版本号, 2018年4月10日]
 */
public interface IAppleAccountBusiness {

    /**
     * 功能描述: <br>
     * 根据页码获取苹果账号信息
     *
     * @param pageIndex 页码
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveAppleAccountByPage(DataRequest dataRequest);

    /**
     * 功能描述: <br>
     * 查询使用中的苹果账号
     *
     * @author zyw
     * @version [版本号, 2018年4月16日]
     */
    public CSResponse retrieveUsingAppleAccount(AppleAccount appleAccount);

    /**
     * 功能描述: <br>
     * 查看单个苹果账号信息
     *
     * @param id 苹果账号id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */

    public CSResponse retrieveSingleAppleAccount(Integer id);

    /**
     * 功能描述: <br>
     * 更新苹果账号信息
     *
     * @param map 苹果账号相关信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateAppleAccount(AppleAccount appleAccount);

    /**
     * 功能描述: <br>
     * 重置苹果账号状态
     *
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateAppleAccountByStatus(AppleAccount appleAccount);

    /**
     * 功能描述: <br>
     * 删除单个苹果账号信息
     *
     * @param id 要删除的苹果账号id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteSingleAppleAccount(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除苹果账号信息
     *
     * @param list 要删除的苹果账号id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteBatchAppleAccount(List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的苹果账号信息
     *
     * @param map 苹果账号相关信息
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public CSResponse createAppleAccount(AppleAccount appleAccount);

    public CSResponse createBatchAppleAccount(String account, String country);

    public CSResponse selectLockedAppleAccount();
}
