package com.xtzn.service.impl;

import com.xtzn.mapper.IAccountInfoMapper;
import com.xtzn.mapper.entity.AccountInfo;
import com.xtzn.service.IAccountInfoService;
import com.xtzn.vo.DataRequest;
import com.xtzn.vo.LuaReuqest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月12日]
 */
@Service
public class AccountInfoServiceImpl implements IAccountInfoService {

    @Autowired
    private IAccountInfoMapper accountInfoDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public List<Map<String, Object>> selectAccountInfoByPageIndex(DataRequest dataRequest) {

        if ("".equals(dataRequest.getStatus())) {
            dataRequest.setStatus(null);
        }
        return accountInfoDao.selectAccountInfoByPageIndex(dataRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public Map<String, Object> selectAccountInfoById(Integer id) {

        return accountInfoDao.selectAccountInfoById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateAccountInfoContent(AccountInfo accountInfo) {

        return accountInfoDao.updateAccountInfoContent(accountInfo);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateAccountInfoStatus(Byte status, Integer id) {

        return accountInfoDao.updateAccountInfoStatus(status, id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int deleteById(Integer id) {

        return accountInfoDao.deleteById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int deleteBatchById(List<Integer> list) {

        return accountInfoDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int insertAccountInfo(AccountInfo accountInfo) {

        return accountInfoDao.insertAccountInfo(accountInfo);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月17日]
     */
    @Override
    public List<Map<String, Object>> selectAllAccountInfoByPageIndex(Integer skips, Integer pageSize) {

        return accountInfoDao.selectAllAccountInfoByPageIndex(skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public Integer selectCount(DataRequest dataRequest) {
        if ("".equals(dataRequest.getStatus())) {
            dataRequest.setStatus(null);
        }
        return accountInfoDao.selectCount(dataRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月23日]
     */
    @Override
    public int deleteBatchByCondition(DataRequest dataRequest) {
        if ("".equals(dataRequest.getStatus())) {
            dataRequest.setStatus(null);
        }
        return accountInfoDao.deleteBatchByCondition(dataRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月27日]
     */
    @Override
    public List<Map<String, Object>> selectAccountInfoForLua(LuaReuqest luaReuqest) {
        if ("".equals(luaReuqest.getStatus())) {
            luaReuqest.setStatus(null);
        }
        return accountInfoDao.selectAccountInfoForLua(luaReuqest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月27日]
     */
    @Override
    public int insertAccountInfoByLua(LuaReuqest luaReuqest) {

        return accountInfoDao.insertAccountInfoByLua(luaReuqest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月27日]
     */
    @Override
    public int updateAccountInfoByLua(Byte status, Integer id) {

        return accountInfoDao.updateAccountInfoByLua(status, id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月14日]
     */
    @Override
    public int insertBatchAccountInfo(List<AccountInfo> list) {

        return accountInfoDao.insertBatchAccountInfo(list);
    }

}
