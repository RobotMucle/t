package com.xtzn.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xtzn.business.IAccountInfoBusiness;
import com.xtzn.business.IAccountTypeBusiness;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.AccountInfo;
import com.xtzn.mapper.entity.AccountType;
import com.xtzn.utils.ListUtil;
import com.xtzn.vo.CSRequest;
import com.xtzn.vo.DataRequest;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月14日]
 */
@Controller
@RequestMapping("/accountManage")
public class AccountManageController {


    @Autowired
    private IAccountInfoBusiness accountInfoBusiness;

    @Autowired
    private IAccountTypeBusiness accountTypeBusiness;

    /**
     * 功能描述: <br>
     * 添加账号信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/addAccountInfo", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse addAccountInfo(String user, Integer type, Integer userId) {

        if (null == user || null == type || userId == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return accountInfoBusiness.createAccountInfo(user, type, userId);
    }

    /**
     * 功能描述: <br>
     * 删除单个账号信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteSingleAccountInfo", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteSingleAccountInfo(AccountInfo accountInfo) {
        Integer id = accountInfo.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return accountInfoBusiness.deleteSingleAccountInfo(id);
    }

    /**
     * 功能描述: <br>
     * 批量删除账号信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteBatchAccountInfo", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchAccountInfo(String ids) {
        if (null == ids) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return accountInfoBusiness.deleteBatchAccountInfo(list);
    }

    /**
     * 功能描述: <br>
     * 查询单个账号信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveAccountInfo", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveAccountInfo(AccountInfo accountInfo) {
        Integer id = accountInfo.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return accountInfoBusiness.retrieveSingleAccountInfo(id);
    }

    /**
     * 功能描述: <br>
     * 查询账号信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveAccountInfos", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveAccountInfos(DataRequest dataRequest) {
        if (dataRequest.getUserId() == null || dataRequest.getPageIndex() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return accountInfoBusiness.retrieveAccountInfoByPage(dataRequest);
    }

    @RequestMapping(value = "/deleteBatchAccountInfoByCondition", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchAccountInfoByCondition(DataRequest dataRequest) {
        if (dataRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        if (dataRequest.getDateRange() == null && dataRequest.getStatus() == null && dataRequest.getTypeId() == null && dataRequest.getUsedCnt() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return accountInfoBusiness.deleteBatchByCondition(dataRequest);
    }

    /**
     * 功能描述: <br>
     * 修改账号信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyAccountInfo", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyAccountInfo(AccountInfo accountInfo) {
        Integer id = accountInfo.getId();
        String userName = accountInfo.getUserName();
        String userPwd = accountInfo.getUserPwd();
        Integer type = accountInfo.getType();
        if (null == userName || null == userPwd || null == type || null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return accountInfoBusiness.updateAccountInfo(accountInfo);
    }

    /**
     * 功能描述: <br>
     * 修改账号信息使用状态接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyAccountInfoStatus", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyAccountInfoStatus(AccountInfo accountInfo) {
        Integer id = accountInfo.getId();
        Byte status = accountInfo.getStatus();
        if (null == id || null == status) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return accountInfoBusiness.updateAccountInfoByStatus(status, id);
    }

    /**
     * 功能描述: <br>
     * 添加账号类型接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/addAccountType", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse addAccountType(AccountType accountType) {
        String typeName = accountType.getTypeName();
        if (null == typeName) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return accountTypeBusiness.createAccountType(accountType);
    }

    /**
     * 功能描述: <br>
     * 删除单个账号类型接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteSingleAccountType", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteSingleAccountType(AccountType accountType) {
        Integer id = accountType.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return accountTypeBusiness.deleteSingleAccountType(id);
    }

    /**
     * 功能描述: <br>
     * 批量删除账号类型接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteBatchAccountType", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchAccountType(String ids) {
        if (null == ids) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return accountTypeBusiness.deleteBatchAccountType(list);
    }

    /**
     * 功能描述: <br>
     * 查询单个账号类型信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveAccountType", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveAccountType(AccountType accountType) {
        Integer id = accountType.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return accountTypeBusiness.retrieveSingleAccountType(id);
    }

    /**
     * 功能描述: <br>
     * 查询所有账号类型信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveAllAccountType", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveAllAccountType(AccountType accountType) {
        if (accountType.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return accountTypeBusiness.retrieveAllAccountType(accountType);
    }

    /**
     * 功能描述: <br>
     * 查询账号类型信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveAccountTypes", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveAccountTypes(CSRequest csRequest) {
        if (csRequest.getPageIndex() == null || csRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return accountTypeBusiness.retrieveAccountTypeByPage(csRequest);
    }

    /**
     * 功能描述: <br>
     * 修改账号类型接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyAccountType", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyAccountType(AccountType accountType) {
        String typeName = accountType.getTypeName();
        if (null == typeName) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return accountTypeBusiness.updateAccountType(accountType);
    }

    @RequestMapping(value = "/uploadAccountInfo", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse uploadAccountInfo(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        Integer typeId = Integer.parseInt(request.getParameter("typeId"));
        if (null == file) {
            return new CSResponse(ResponseEnum.UPLOAD_EXCEL_ERROR.getCode(), ResponseEnum.UPLOAD_EXCEL_ERROR.getDesc());
        }
        if (null == userId || null == typeId) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return accountInfoBusiness.uploadAccountInfo(request, file);
    }
}
