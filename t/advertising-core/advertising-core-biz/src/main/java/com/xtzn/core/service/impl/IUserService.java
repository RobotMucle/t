package com.xtzn.core.service.impl;

import com.xtzn.core.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年6月15日]
 */
@Service
public class IUserService implements com.xtzn.core.service.IUserService {

    @Autowired
    private IUserMapper userDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月15日]
     */
    @Override
    public List<Integer> selectUserId() {

        return userDao.selectUserId();
    }

}
