package com.xtzn.business;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月21日]
 */

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.*;
import com.xtzn.vo.LuaReuqest;

public interface ILuaBusiness {

    public CSResponse finishRetained(RetainedRecord retainedcord, Byte distributeType, Byte type, String uploadPath, Integer count, String reqTime);

    public CSResponse finishTask(RetainedList retainedList, String affiliateAccount);

    public CSResponse requestPort(PortList portList);

    public CSResponse taskReport(Integer taskId, String phoneCode, Byte type);

    public CSResponse createIdfa(LuaReuqest luaReuqest);

    public CSResponse requestIdfa(LuaReuqest luaReuqest);

    public CSResponse requestAccount(LuaReuqest luaReuqest);

    public CSResponse createAccount(LuaReuqest luaReuqest);

    public CSResponse requestPersonInfo(LuaReuqest luaReuqest);

    public CSResponse updatePersonInfo(PersonInfo personInfo);

    public CSResponse requestBundleName(Integer userId, Byte type);

    public CSResponse requestIggCode(Integer userId, String phoneCode);

    public CSResponse iggRechargeReport(LuaReuqest luaReuqest, String outOfDate);

    public CSResponse requestAppleAccount(AppleAccount appleAccount);

    public CSResponse appleAccountReport(AppleAccount appleAccount);

    public CSResponse uploadPathReplace(RetainedList retainedList, String reqTime);

    public CSResponse requestPhoneProgram(Integer userId);
}
