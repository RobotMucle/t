package com.xtzn.mapper;

import com.xtzn.mapper.entity.AppleAccount;
import com.xtzn.vo.DataRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月10日]
 */
public interface IAppleAccountMapper {

    /**
     * 功能描述: <br>
     * 根据页码获取苹果账号信息
     *
     * @param pageSize 页面大小
     * @param skips    从哪条数据开始
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public List<AppleAccount> selectAppleAccountByPageIndex(DataRequest dataRequest);

    /**
     * 功能描述: <br>
     * 查询使用中的苹果账号
     *
     * @author zyw
     * @version [版本号, 2018年4月16日]
     */
    public List<AppleAccount> selectUsingAppleAccount();

    /**
     * 功能描述: <br>
     * 查看单个苹果账号信息
     *
     * @param id 苹果账号id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public AppleAccount selectAppleAccountById(@Param("id") Integer id);

    /**
     * 功能描述: <br>
     * 更新苹果账号信息
     *
     * @param map 苹果账号相关信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateAppleAccountContent(AppleAccount appleAccount);

    /**
     * 功能描述: <br>
     * 重置苹果账号状态
     *
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateAppleAccountStatus();

    /**
     * 功能描述: <br>
     * 删除单个苹果账号信息
     *
     * @param id 要删除的苹果账号id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteById(@Param("id") Integer id);

    /**
     * 功能描述: <br>
     * 批量删除苹果账号信息
     *
     * @param list 要删除的苹果账号id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteBatchById(@Param("list") List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的苹果账号信息
     *
     * @param map 苹果账号相关信息
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public int insertAppleAccount(AppleAccount appleAccount);

    public Integer selectCount(DataRequest dataRequest);

    public List<AppleAccount> selectAppleAccountByCountry(AppleAccount appleAccount);

    public Integer updateAppleAccountByLua(@Param("id") Integer id);

    public List<AppleAccount> selectNeedUnlockAppleAccount();

    public int insertBatchAppleAccount(@Param("list") List<AppleAccount> list);
}
