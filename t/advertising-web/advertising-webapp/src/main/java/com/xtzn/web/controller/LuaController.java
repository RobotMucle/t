package com.xtzn.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtzn.business.ILuaBusiness;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.click.vo.CSResponse;

import com.xtzn.mapper.entity.AppleAccount;
import com.xtzn.mapper.entity.PersonInfo;
import com.xtzn.mapper.entity.PortList;
import com.xtzn.mapper.entity.RetainedList;
import com.xtzn.mapper.entity.RetainedRecord;
import com.xtzn.vo.LuaReuqest;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月21日]
 */
@Controller
@RequestMapping("/lua")
public class LuaController {


    @Autowired
    private ILuaBusiness luaBusiness;


    @RequestMapping(value = "/uploadPathReplace", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse uploadPathReplace(RetainedList retainedList, String reqTime) {
        if (retainedList.getId() == null || retainedList.getUserId() == null || retainedList.getTaskId() == null || reqTime == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luaBusiness.uploadPathReplace(retainedList, reqTime);
    }

    @RequestMapping(value = "/finishTask", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse finishTask(RetainedList retainedList, String affiliateAccount) {
        if (retainedList.getUploadPath() == null || retainedList.getUserId() == null || retainedList.getTaskId() == null || retainedList.getSubId() == null || retainedList.getIsNewPhone() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        if (retainedList.getKeepDays() == null || retainedList.getRetainedPercent() == null || retainedList.getPhoneCode() == null || affiliateAccount == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        if (retainedList.getUploadPath() == "" || retainedList.getSubId() == "" || retainedList.getRetainedPercent() == "" || affiliateAccount == "") {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luaBusiness.finishTask(retainedList, affiliateAccount);
    }

    @RequestMapping(value = "/finishRetained", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse finishRetained(RetainedRecord retainedReport, Byte distributeType, Byte type, String uploadPath, Integer count, String reqTime) {
        if (distributeType == null || retainedReport.getUserId() == null || retainedReport.getIpAddress() == null || retainedReport.getIsSuccess() == null || retainedReport.getPhoneCode() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        if (retainedReport.getRetainedId() == null || retainedReport.getRetainedKeepDays() == null || retainedReport.getReason() == null || retainedReport.getTaskId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        if (retainedReport.getIpAddress() == "" || retainedReport.getPhoneCode() == "" || retainedReport.getReason() == "" || count == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luaBusiness.finishRetained(retainedReport, distributeType, type, uploadPath, count, reqTime);
    }

    @RequestMapping(value = "/requestPort", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse requestPort(PortList portList) {
        if (portList.getPhoneCode() == null || portList.getPhoneCode() == "" || portList.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luaBusiness.requestPort(portList);
    }

    @RequestMapping(value = "/taskReport", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse taskReport(Integer taskId, String phoneCode, Byte type) {
        if (null == taskId || phoneCode == null || phoneCode == "" || type == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luaBusiness.taskReport(taskId, phoneCode, type);
    }

    @RequestMapping(value = "/createIdfa", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse createIdfa(LuaReuqest luaReuqest) {
        if (luaReuqest.getUserId() == null || luaReuqest.getIdfaCode() == null || luaReuqest.getIdfaCode() == "") {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }

        return luaBusiness.createIdfa(luaReuqest);
    }

    @RequestMapping(value = "/requestIdfa", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse requestIdfa(LuaReuqest luaReuqest) {
        if (luaReuqest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luaBusiness.requestIdfa(luaReuqest);
    }

    @RequestMapping(value = "/requestAccount", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse requestAccount(LuaReuqest luaReuqest) {
        if (luaReuqest.getTypeName() == null || luaReuqest.getTypeName() == "" || luaReuqest.getUserId() == null || luaReuqest.getType() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luaBusiness.requestAccount(luaReuqest);
    }

    @RequestMapping(value = "/createAccount", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse createAccount(LuaReuqest luaReuqest) {
        if (luaReuqest.getTypeName() == null || luaReuqest.getTypeName() == "" || luaReuqest.getUserId() == null || luaReuqest.getUserName() == null || luaReuqest.getUserName() == "") {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luaBusiness.createAccount(luaReuqest);
    }

    @RequestMapping(value = "/requestPersonInfo", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse requestPersonInfo(LuaReuqest luaReuqest) {
        if (luaReuqest.getUserId() == null || luaReuqest.getType() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luaBusiness.requestPersonInfo(luaReuqest);
    }

    @RequestMapping(value = "/updatePersonInfo", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse updatePersonInfo(PersonInfo personInfo) {
        if (personInfo.getId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luaBusiness.updatePersonInfo(personInfo);
    }

    @RequestMapping(value = "/requestBundleName", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse requestBundleName(Integer userId, Byte type) {
        if (userId == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luaBusiness.requestBundleName(userId, type);
    }

    @RequestMapping(value = "/requestIggCode", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse requestIggCode(Integer userId, String phoneCode) {
        if (null == userId || null == phoneCode) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luaBusiness.requestIggCode(userId, phoneCode);
    }

    @RequestMapping(value = "/iggRechargeReport", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse iggRechargeReport(LuaReuqest luaReuqest, String outOfDate) {
        return luaBusiness.iggRechargeReport(luaReuqest, outOfDate);
    }

    @RequestMapping(value = "/requestAppleAccount", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse requestAppleAccount(AppleAccount appleAccount) {
        if (appleAccount.getCountry() == null || appleAccount.getCountry() == "") {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luaBusiness.requestAppleAccount(appleAccount);
    }

    @RequestMapping(value = "/appleAccountReport", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse appleAccountReport(AppleAccount appleAccount) {
        if (appleAccount.getId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luaBusiness.appleAccountReport(appleAccount);
    }

    @RequestMapping(value = "/requestPhoneProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse requestPhoneProgram(Integer userId) {
        if (null == userId) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luaBusiness.requestPhoneProgram(userId);
    }

}
