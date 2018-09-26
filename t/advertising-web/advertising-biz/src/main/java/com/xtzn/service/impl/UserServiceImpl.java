package com.xtzn.service.impl;

import com.xtzn.mapper.IUserMapper;
import com.xtzn.mapper.entity.User;
import com.xtzn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月17日]
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月17日]
     */
    @Override
    public User selectUserForLogin(User user) {

        return userDao.selectUserForLogin(user);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月17日]
     */
    @Override
    public List<User> selectUserByPage(Integer skips, Integer pageSize) {

        return userDao.selectUserByPage(skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月17日]
     */
    @Override
    public int insertUser(User user) {

        return userDao.insertUser(user);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月17日]
     */
    @Override
    public int updateUser(User user) {

        return userDao.updateUser(user);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public Integer selectCount() {

        return userDao.selectCount();
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月25日]
     */
    @Override
    public List<Map<String, Object>> selectCommonUser() {

        return userDao.selectCommonUser();
    }

}
