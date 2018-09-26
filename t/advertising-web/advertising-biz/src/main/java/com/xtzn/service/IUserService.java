package com.xtzn.service;

import com.xtzn.mapper.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月17日]
 */
public interface IUserService {

    public User selectUserForLogin(User user);

    public List<User> selectUserByPage(Integer skips, Integer pageSize);

    public int insertUser(User user);

    public int updateUser(User user);

    public Integer selectCount();

    public List<Map<String, Object>> selectCommonUser();
}
