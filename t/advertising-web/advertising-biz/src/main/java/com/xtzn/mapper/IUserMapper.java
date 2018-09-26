package com.xtzn.mapper;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月17日]
 */

import com.xtzn.mapper.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IUserMapper {

    public User selectUserForLogin(User user);

    public List<User> selectUserByPage(@Param("skips") Integer skips, @Param("pageSize") Integer pageSize);

    public int insertUser(User user);

    public int updateUser(User user);

    public Integer selectCount();

    public List<Map<String, Object>> selectCommonUser();
}
