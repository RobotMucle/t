package com.xtzn.business.impl;

import com.xtzn.business.IUserBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.common.Constant;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.User;
import com.xtzn.service.IUserService;
import com.xtzn.utils.MDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月17日]
 */
@Component
public class UserBusinessImpl implements IUserBusiness {

    @Autowired
    private IUserService userService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月17日]
     */
    @Override
    public CSResponse login(User user) {
        String password = MDUtil.passwordEncrypt(user.getPassword());
        user.setPassword(password);
        User currentUser = userService.selectUserForLogin(user);
        if (null != currentUser) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) currentUser);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月17日]
     */
    @Override
    public CSResponse retrieveUserByPage(Integer pageIndex) {
        Integer pageSize = Constant.pageSize;
        Integer skips = (pageIndex - 1) * pageSize;
        List<User> list = userService.selectUserByPage(skips, pageSize);
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = userService.selectCount();
            map.put("data", list);
            map.put("count", count);
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) map);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月17日]
     */
    @Override
    public CSResponse createUser(User user) {
        String password = MDUtil.passwordEncrypt(user.getPassword());
        user.setPassword(password);
        int i = userService.insertUser(user);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月17日]
     */
    @Override
    public CSResponse modifyUser(User user) {
        int i = userService.updateUser(user);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月25日]
     */
    @Override
    public CSResponse selectCommonUser() {
        List<Map<String, Object>> list = userService.selectCommonUser();
        if (list.isEmpty() || null == list) {
            return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
        }
        return new CSResponse((Serializable) list);
    }

}
