package com.xtzn.service;

import com.xtzn.mapper.entity.AccountInfo;
import com.xtzn.vo.DataRequest;
import com.xtzn.vo.LuaReuqest;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * 账号信息curd
 *
 * @author zyw
 * @version [版本号, 2018年4月11日]
 */
public interface IAccountInfoService {

    /**
     * 功能描述: <br>
     * 根据页码获取账号信息
     *
     * @param pageSize 页面大小
     * @param skips    从哪条数据开始
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public List<Map<String, Object>> selectAccountInfoByPageIndex(DataRequest dataRequest);

    /**
     * 功能描述: <br>
     * 管理员根据页码获取账号信息
     *
     * @param pageSize 页面大小
     * @param skips    从哪条数据开始
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public List<Map<String, Object>> selectAllAccountInfoByPageIndex(Integer skips, Integer pageSize);

    /**
     * 功能描述: <br>
     * 查看单个账号信息
     *
     * @param id 账号信息id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public Map<String, Object> selectAccountInfoById(Integer id);

    /**
     * 功能描述: <br>
     * 更新账号信息
     *
     * @param map 账号相关信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateAccountInfoContent(AccountInfo accountInfo);

    /**
     * 功能描述: <br>
     * 更新账号状态
     *
     * @param status 账号状态
     * @param id     国家id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateAccountInfoStatus(Byte status, Integer id);

    /**
     * 功能描述: <br>
     * 删除单个账号信息
     *
     * @param id 要删除的账号id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteById(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除账号信息
     *
     * @param list 要删除的账号id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteBatchById(List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的账号信息
     *
     * @param map 账号相关信息
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public int insertAccountInfo(AccountInfo accountInfo);

    public Integer selectCount(DataRequest dataRequest);

    public int deleteBatchByCondition(DataRequest dataRequest);

    public List<Map<String, Object>> selectAccountInfoForLua(LuaReuqest luaReuqest);

    public int insertAccountInfoByLua(LuaReuqest luaReuqest);

    public int updateAccountInfoByLua(Byte status, Integer id);

    public int insertBatchAccountInfo(List<AccountInfo> list);
}
