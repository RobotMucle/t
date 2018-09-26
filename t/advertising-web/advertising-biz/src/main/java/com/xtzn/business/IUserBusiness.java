package com.xtzn.business;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月17日]
 */


import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.User;

public interface IUserBusiness {

    public CSResponse login(User user);

    public CSResponse retrieveUserByPage(Integer pageIndex);

    public CSResponse createUser(User user);

    public CSResponse modifyUser(User user);

    public CSResponse selectCommonUser();
}
