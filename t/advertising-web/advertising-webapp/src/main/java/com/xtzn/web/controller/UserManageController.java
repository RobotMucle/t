package com.xtzn.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtzn.business.INoticeBusiness;
import com.xtzn.business.IUserBusiness;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.Notice;
import com.xtzn.mapper.entity.User;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月17日]
 */
@Controller
@RequestMapping("/userManage")
public class UserManageController {

    @Autowired
    private IUserBusiness userBusiness;
    @Autowired
    private INoticeBusiness noticeBusiness;

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse login(User user) {
        if (user.getUserName() == null || user.getPassword() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return userBusiness.login(user);
    }

    @RequestMapping(value = "/retrieveUserByPage", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveUserByPage(Integer pageIndex) {
        if (pageIndex == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return userBusiness.retrieveUserByPage(pageIndex);
    }

    @RequestMapping(value = "/createUser", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse createUser(User user) {
        if (user.getUserName() == null || user.getPassword() == null || user.getFranchiseeName() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return userBusiness.createUser(user);
    }

    @RequestMapping(value = "/modifyUser", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyUser(User user) {
        if (user.getId() != null) {
            return userBusiness.modifyUser(user);
        }
        return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
    }

    @RequestMapping(value = "/selectCommonUser", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse selectCommonUser() {
        return userBusiness.selectCommonUser();
    }

    @RequestMapping(value = "/selectLatestNotice", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse selectLatestNotice() {
        return noticeBusiness.selectLatestNotice();
    }

    @RequestMapping(value = "/createNotice", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse createNotice(Notice notice) {
        if (notice.getTitle() == null || notice.getContent() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return noticeBusiness.createNotice(notice);
    }
}
