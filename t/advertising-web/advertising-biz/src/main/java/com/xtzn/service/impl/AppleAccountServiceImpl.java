package com.xtzn.service.impl;

import com.xtzn.mapper.IAppleAccountMapper;
import com.xtzn.mapper.entity.AppleAccount;
import com.xtzn.service.IAppleAccountService;
import com.xtzn.vo.DataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月12日]
 */
@Service
public class AppleAccountServiceImpl implements IAppleAccountService {

    @Autowired
    private IAppleAccountMapper appleAccountDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public List<AppleAccount> selectAppleAccountByPageIndex(DataRequest dataRequest) {

        return appleAccountDao.selectAppleAccountByPageIndex(dataRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public AppleAccount selectAppleAccountById(Integer id) {

        return appleAccountDao.selectAppleAccountById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateAppleAccountContent(AppleAccount appleAccount) {

        return appleAccountDao.updateAppleAccountContent(appleAccount);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateAppleAccountStatus() {

        return appleAccountDao.updateAppleAccountStatus();
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

        return appleAccountDao.deleteById(id);
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

        return appleAccountDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int insertAppleAccount(AppleAccount appleAccount) {

        return appleAccountDao.insertAppleAccount(appleAccount);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月16日]
     */
    @Override
    public List<AppleAccount> selectUsingAppleAccount() {

        return appleAccountDao.selectUsingAppleAccount();
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

        return appleAccountDao.selectCount(dataRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public List<AppleAccount> selectAppleAccountByCountry(AppleAccount appleAccount) {

        return appleAccountDao.selectAppleAccountByCountry(appleAccount);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月29日]
     */
    @Override
    public Integer updateAppleAccountByLua(Integer id) {

        return appleAccountDao.updateAppleAccountByLua(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月24日]
     */
    @Override
    public List<AppleAccount> selectNeedUnlockAppleAccount() {

        return appleAccountDao.selectNeedUnlockAppleAccount();
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月24日]
     */
    @Override
    public int insertBatchAppleAccount(List<AppleAccount> list) {

        return appleAccountDao.insertBatchAppleAccount(list);
    }

}
