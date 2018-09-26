package com.xtzn.service.impl;

import com.xtzn.mapper.IAccountTypeMapper;
import com.xtzn.mapper.entity.AccountType;
import com.xtzn.service.IAccountTypeService;
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
public class AccountTypeServiceImpl implements IAccountTypeService {

    @Autowired
    private IAccountTypeMapper accountTypeDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public List<AccountType> selectAccountTypeByPageIndex(Integer userId, Integer skips, Integer pageSize) {

        return accountTypeDao.selectAccountTypeByPageIndex(userId, skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public AccountType selectAccountTypeById(Integer id) {

        return accountTypeDao.selectAccountTypeById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateAccountTypeName(AccountType accountType) {

        return accountTypeDao.updateAccountTypeName(accountType);
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

        return accountTypeDao.deleteById(id);
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

        return accountTypeDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int insertAccountType(AccountType accountType) {

        return accountTypeDao.insertAccountType(accountType);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public List<AccountType> selectAllAccountType(Integer userId) {

        return accountTypeDao.selectAllAccountType(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月17日]
     */
    @Override
    public List<AccountType> selectAllAccountTypeByPageIndex(Integer skips, Integer pageSize) {

        return accountTypeDao.selectAllAccountTypeByPageIndex(skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public Integer selectCount(Integer userId) {

        return accountTypeDao.selectCount(userId);
    }

}
