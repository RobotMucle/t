package com.xtzn.business.impl;

import com.xtzn.business.ILuaBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.common.Constant;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.*;
import com.xtzn.service.*;
import com.xtzn.utils.JedisLockUtil;
import com.xtzn.utils.RedisUtil;
import com.xtzn.vo.LuaReuqest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月21日]
 */
@Component
public class LuaBusinessImpl implements ILuaBusiness {

    private static final Logger log = LoggerFactory.getLogger(LuaBusinessImpl.class);
    @Autowired
    private ITaskListenningService taskListenningService;
    @Autowired
    private IRetainedListService retainedListService;
    @Autowired
    private INoReturnAllianceService noReturnAllianceService;
    @Autowired
    private IRetainedListenningService retainedListenningService;
    @Autowired
    private IRetainedRecordService retainedRecordService;
    @Autowired
    private IPortListService portListService;
    @Autowired
    private ITaskListService taskListService;
    @Autowired
    private IIdfaService idfaService;
    @Autowired
    private IAccountInfoService accountInfoService;
    @Autowired
    private IPersonInfoService personInfoService;
    @Autowired
    private ITaskConfigurationService taskConfigurationService;
    @Autowired
    private IIggListService iggListService;
    @Autowired
    private IPhoneListService phoneListService;
    @Autowired
    private IAppleAccountService appleAccountService;
    @Autowired
    private IIphoneRuleService iphoneRuleService;
    @Autowired
    private IIphoneProgramService iphoneProgramService;

    /**
     * 功能描述: <br>
     * 留存任务完成
     *
     * @author zyw
     * @version [版本号, 2018年4月21日]
     */
    @Override
    public CSResponse finishRetained(RetainedRecord retainedReport, Byte distributeType, Byte type, String uploadPath, Integer count, String reqTime) {
        RetainedList currentRetained = new RetainedList();
        currentRetained.setId(retainedReport.getRetainedId());
        Date uploadTime = null;
        try {
            uploadTime = new Date(Long.parseLong(reqTime));
        } catch (Exception e) {
            return new CSResponse(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getDesc());
        }
        retainedReport.setUploadTime(uploadTime);
        if (type == 0) {
            if (retainedReport.getIsSuccess() == 1) {
                //若是一次登陆，更新留存表 ,记录上传留存历史表
                if (distributeType == 0) {
                    Date disTime = retainedListenningService.selectDistributeTime(retainedReport.getRetainedId());
                    if (null == disTime) {
                        return new CSResponse(ResponseEnum.OVERDUE_ERROR_任务.getCode(), ResponseEnum.OVERDUE_ERROR_任务.getDesc());
                    }
                    Date curTime = new Date();
                    //过期时间判断
                    Long date = curTime.getTime() - disTime.getTime();
                    if (date < 30 * 60000) {
                        //留存任务没有过期
                        retainedListenningService.updateRetainedListenningOverdue(retainedReport.getRetainedId());
                        //添加留存历史记录
                        retainedRecordService.insertRetainedReport(retainedReport);
                        currentRetained.setLevelCount(count);
                        currentRetained.setUsedCnt(1);
                        retainedListService.updateRetainedListForlua(currentRetained);
                        return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
                    }
                    //留存回滚
                    retainedListenningService.updateRetainedListenningOverdue(retainedReport.getRetainedId());
                    currentRetained.setLevelCount(null);
                    currentRetained.setUsedCnt(null);
                    currentRetained.setIsDoSign(Constant.status_1);
                    retainedListService.updateRetainedListForlua(currentRetained);
                    return new CSResponse(ResponseEnum.OVERDUE_ERROR_留存.getCode(), ResponseEnum.OVERDUE_ERROR_留存.getDesc());
                }
                //二次及多次登陆上传留存历史表,不对留存表处理，添加留存历史记录
                retainedRecordService.updateRetainedCnt(retainedReport);
                return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
            }
            //任务失败
            else if (retainedReport.getIsSuccess() == 0) {
                if (distributeType == 0) {
                    Date disTime = retainedListenningService.selectDistributeTime(retainedReport.getRetainedId());
                    if (null == disTime) {
                        return new CSResponse(ResponseEnum.OVERDUE_ERROR_任务.getCode(), ResponseEnum.OVERDUE_ERROR_任务.getDesc());
                    }
                    Date curTime = new Date();
                    //过期时间判断
                    Long date = curTime.getTime() - disTime.getTime();
                    if (date < 30 * 60000) {
                        //留存任务没有过期
                        retainedListenningService.updateRetainedListenningOverdue(retainedReport.getRetainedId());
                        //留存回滚
                        currentRetained.setIsDoSign(Constant.status_1);
                        retainedListService.updateRetainedListForlua(currentRetained);
                        //添加留存历史记录
                        retainedRecordService.insertRetainedReport(retainedReport);
                        return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
                    }
                    //留存回滚
                    retainedListenningService.updateRetainedListenningOverdue(retainedReport.getRetainedId());
                    currentRetained.setIsDoSign(Constant.status_1);
                    retainedListService.updateRetainedListForlua(currentRetained);
                    return new CSResponse(ResponseEnum.OVERDUE_ERROR_留存.getCode(), ResponseEnum.OVERDUE_ERROR_留存.getDesc());
                }
                //二次及多次登陆上传留存历史表,不对留存表处理，添加留存历史记录
                retainedRecordService.updateRetainedCnt(retainedReport);
                return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
            } else {
                if (distributeType == 0) {
                    retainedListenningService.updateRetainedListenningOverdue(retainedReport.getRetainedId());
                    retainedRecordService.insertRetainedReport(retainedReport);
                    currentRetained.setIsDoSign(Constant.status_2);
                    retainedListService.updateRetainedListForlua(currentRetained);
                } else {
                    retainedRecordService.updateRetainedCnt(retainedReport);
                    currentRetained.setIsDoSign(Constant.status_2);
                    retainedListService.updateRetainedListForlua(currentRetained);
                }
                return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
            }
        } else {
            if (distributeType == 0) {
                Date disTime = retainedListenningService.selectDistributeTime(retainedReport.getRetainedId());
                if (null == disTime) {
                    return new CSResponse(ResponseEnum.OVERDUE_ERROR_任务.getCode(), ResponseEnum.OVERDUE_ERROR_任务.getDesc());
                }
                Date curTime = new Date();
                //过期时间判断
                Long date = curTime.getTime() - disTime.getTime();
                if (date < 30 * 60000) {
                    //留存任务没有过期
                    retainedListenningService.updateRetainedListenningOverdue(retainedReport.getRetainedId());
                    //更新包路径
                    currentRetained.setIsDoSign(Constant.status_0);
                    currentRetained.setUploadPath(uploadPath);
                    retainedListService.updateRetainedListForlua(currentRetained);
                    //添加留存历史记录
                    retainedRecordService.insertRetainedReport(retainedReport);
                    return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
                }
                //留存回滚
                retainedListenningService.updateRetainedListenningOverdue(retainedReport.getRetainedId());
                currentRetained.setUploadPath(uploadPath);
                currentRetained.setIsDoSign(Constant.status_1);
                retainedListService.updateRetainedListForlua(currentRetained);
                return new CSResponse(ResponseEnum.OVERDUE_ERROR_留存.getCode(), ResponseEnum.OVERDUE_ERROR_留存.getDesc());
            }
            //二次及多次登陆上传留存历史表,不对留存表处理，添加留存历史记录
            retainedRecordService.updateRetainedCnt(retainedReport);
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }

    }

    /**
     * 功能描述: <br>
     * 任务完成
     *
     * @author zyw
     * @version [版本号, 2018年4月21日]
     */
    @Override
    public CSResponse finishTask(RetainedList retainedList, String affiliateAccount) {
        Byte[] type = {0, 1};
        Integer taskId = retainedList.getTaskId();
        String phoneCode = retainedList.getPhoneCode();
        Date disTime = taskListenningService.selectDistributeTime(taskId, phoneCode);
        if (null == disTime) {
            return new CSResponse(ResponseEnum.OVERDUE_ERROR_任务.getCode(), ResponseEnum.OVERDUE_ERROR_任务.getDesc());
        }
        Date curTime = new Date();
        retainedList.setUploadTime(curTime);
        Long date = curTime.getTime() - disTime.getTime();
        if (date < 30 * 60000) {
            //任务没有过期,将该监控移除
            taskListenningService.updateByResultTask(taskId, phoneCode);
            //更新已完成任务数
            taskListService.updateFinishNum(taskId);
            String retainedPercent = retainedList.getRetainedPercent();
            String[] rp = retainedPercent.split(",");
            Integer percent = Integer.parseInt(rp[0]);
            int i = (int) (Math.random() * 100) + 1;
            if (i <= percent) {
                retainedList.setIsDoSign(type[1]);
            }
            //查看是否有postback
            String afa = noReturnAllianceService.selectNoReturnAllianceName(retainedList.getUserId(), affiliateAccount);
            if (null != afa) {
                retainedList.setIsSuccess(type[1]);
            }
            //查看是否有subId,有则修改记录，无则新建记录
            String subId = retainedListService.selectSubId(retainedList.getSubId());
            if (null == subId) {
                retainedListService.insertRetainedList(retainedList);
            } else {
                retainedListService.updateRetainedList(retainedList);
            }
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        //任务过期
        return new CSResponse(ResponseEnum.OVERDUE_ERROR_任务.getCode(), ResponseEnum.OVERDUE_ERROR_任务.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月26日]
     */
    @Override
    public CSResponse requestPort(PortList portList) {
        Long now = new Date().getTime();
        JedisLockUtil jedisLock = new JedisLockUtil(String.valueOf(portList.getUserId()), "requestPort", String.valueOf(now));
        try {
            if (jedisLock.lock()) {
                Map<String, Object> map = portListService.selectPortListForLua(portList);
                if (null == map) {
                    String phoneCode = portList.getPhoneCode();
                    portList.setPhoneCode(null);
                    map = portListService.selectPortListForLua(portList);
                    if (null == map) {
                        return new CSResponse(ResponseEnum.PORT_NONE_ERROR.getCode(), ResponseEnum.PORT_NONE_ERROR.getDesc());
                    }
                    portListService.updatePhoneCodeByLua(phoneCode, (Integer) map.get("id"));
                }
                return new CSResponse((Serializable) map);
            }
            return new CSResponse(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getDesc());
        } catch (Exception e) {
            log.debug("jedis lock is exception ");
            return new CSResponse(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getDesc());
        } finally {
            RedisUtil.delField(String.valueOf(portList.getUserId()), "requestPort");
            ;
        }
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月26日]
     */
    @Override
    public CSResponse taskReport(Integer taskId, String phoneCode, Byte type) {
        Date disTime = taskListenningService.selectDistributeTime(taskId, phoneCode);
        if (disTime == null) {
            return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
        }
        Date curTime = new Date();
        Long date = curTime.getTime() - disTime.getTime();
        if (date < 30 * 60000) {
            if (type == 1) {
                taskListenningService.updateByResultTask(taskId, phoneCode);
                taskListService.updateFinishNum(taskId);
                return new CSResponse();
            } else {
                taskListenningService.updateByResultTask(taskId, phoneCode);
                TaskList taskList = new TaskList();
                taskList.setLinkState(type);
                taskList.setId(taskId);
                taskListService.updateLinkStateById(taskList);
                return new CSResponse();
            }
        }
        taskListenningService.updateByResultTask(taskId, phoneCode);
        return new CSResponse(ResponseEnum.OVERDUE_ERROR_任务.getCode(), ResponseEnum.OVERDUE_ERROR_任务.getDesc());

    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月27日]
     */
    @Override
    public CSResponse createIdfa(LuaReuqest luaReuqest) {
        Long now = new Date().getTime();
        JedisLockUtil jedisLock = new JedisLockUtil(String.valueOf(luaReuqest.getUserId()), "createIdfa", String.valueOf(now));
        try {
            if (jedisLock.lock()) {
                if (luaReuqest.getThirdParty() == "") {
                    luaReuqest.setThirdParty(null);
                }
                LuaReuqest curRequest = new LuaReuqest();
                curRequest.setIdfaCode(luaReuqest.getIdfaCode());
                curRequest.setUserId(luaReuqest.getUserId());
                Map<String, Object> map = idfaService.selectAccessibleIdfaForLua(curRequest);
                if (null != map) {
                    return new CSResponse(ResponseEnum.IDFA_CREATE_ERROR.getCode(), ResponseEnum.IDFA_CREATE_ERROR.getDesc());
                }
                int i = idfaService.insertIdfaByLua(luaReuqest);
                if (i > 0) {
                    return new CSResponse();
                }
                return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
            }
            return new CSResponse(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getDesc());
        } catch (Exception e) {
            log.debug("jedis lock is exception ");
            return new CSResponse(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getDesc());
        } finally {
            RedisUtil.delField(String.valueOf(luaReuqest.getUserId()), "createIdfa");
            ;
        }

    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月27日]
     */
    @Override
    @Transactional()
    public CSResponse requestIdfa(LuaReuqest luaReuqest) {
        String bundleName = luaReuqest.getBundleName();
        Integer userId = luaReuqest.getUserId();
        Long now = new Date().getTime();
        JedisLockUtil jedisLock = new JedisLockUtil(String.valueOf(userId), bundleName, String.valueOf(now));
        try {
            if (jedisLock.lock()) {
                Map<String, Object> map = null;
                LuaReuqest curRequest = new LuaReuqest();
                curRequest.setUserId(luaReuqest.getUserId());
                if (!"".equals(luaReuqest.getBundleName())) {
                    curRequest.setBundleName(luaReuqest.getBundleName());
                }
                if (!"".equals(luaReuqest.getCountry())) {
                    curRequest.setCountry(luaReuqest.getCountry());
                }
                if (!"".equals(luaReuqest.getThirdParty())) {
                    curRequest.setThirdParty(luaReuqest.getThirdParty());
                }
                map = idfaService.selectAccessibleIdfaForLua(curRequest);
                if (null != map) {
                    idfaService.updateIdfaByLua(luaReuqest.getBundleName(), (String) map.get("bundleName"), (Integer) map.get("id"));
                    return new CSResponse((Serializable) map);
                }
                curRequest.setCountry(null);
                map = idfaService.selectAccessibleIdfaForLua(curRequest);
                if (null != map) {
                    idfaService.updateIdfaByLua(luaReuqest.getBundleName(), (String) map.get("bundleName"), (Integer) map.get("id"));
                    return new CSResponse((Serializable) map);
                }
                curRequest.setThirdParty(null);
                map = idfaService.selectAccessibleIdfaForLua(curRequest);
                if (null != map) {
                    idfaService.updateIdfaByLua(luaReuqest.getBundleName(), (String) map.get("bundleName"), (Integer) map.get("id"));
                    return new CSResponse((Serializable) map);
                }
                return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
            }
            return new CSResponse(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getDesc());
        } catch (Exception e) {
            log.debug("jedis lock is exception ");
            return new CSResponse(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getDesc());
        } finally {
            RedisUtil.delField(String.valueOf(userId), bundleName);
        }
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月27日]
     */
    @Override
    public CSResponse requestAccount(LuaReuqest luaReuqest) {
        Long now = new Date().getTime();
        JedisLockUtil jedisLock = new JedisLockUtil(String.valueOf(luaReuqest.getUserId()), "requestAccount", String.valueOf(now));
        try {
            if (jedisLock.lock()) {
                if (luaReuqest.getType() != 2) {
                    luaReuqest.setStatus(luaReuqest.getType());
                    List<Map<String, Object>> list = accountInfoService.selectAccountInfoForLua(luaReuqest);
                    if (!list.isEmpty()) {
                        Map<String, Object> map = list.get((int) (Math.random() * list.size()));
                        if (luaReuqest.getType() == 1) {
                            accountInfoService.updateAccountInfoByLua(null, (Integer) map.get("id"));
                        } else {
                            accountInfoService.updateAccountInfoByLua(Constant.status_1, (Integer) map.get("id"));
                        }
                        return new CSResponse((Serializable) map);
                    }
                    return new CSResponse(ResponseEnum.ACCOUNT_NONE_ERROR.getCode(), ResponseEnum.ACCOUNT_NONE_ERROR.getDesc());
                }
                luaReuqest.setStatus(null);
                List<Map<String, Object>> list = accountInfoService.selectAccountInfoForLua(luaReuqest);
                if (!list.isEmpty()) {
                    Map<String, Object> map = list.get((int) (Math.random() * list.size()));
                    Integer status = (Integer) map.get("status");
                    if (status == 1) {
                        accountInfoService.updateAccountInfoByLua(null, (Integer) map.get("id"));
                    } else {
                        accountInfoService.updateAccountInfoByLua(Constant.status_1, (Integer) map.get("id"));
                    }
                    return new CSResponse((Serializable) map);
                }
                return new CSResponse(ResponseEnum.ACCOUNT_NONE_ERROR.getCode(), ResponseEnum.ACCOUNT_NONE_ERROR.getDesc());
            }
            return new CSResponse(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getDesc());
        } catch (Exception e) {
            return new CSResponse(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getDesc());
        } finally {
            RedisUtil.delField(String.valueOf(luaReuqest.getUserId()), "requestAccount");
            ;
        }
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月27日]
     */
    @Override
    public CSResponse createAccount(LuaReuqest luaReuqest) {
        List<Map<String, Object>> list = accountInfoService.selectAccountInfoForLua(luaReuqest);
        if (!list.isEmpty()) {
            return new CSResponse(ResponseEnum.ACCOUNT_CREATE_ERROR.getCode(), ResponseEnum.ACCOUNT_CREATE_ERROR.getDesc());
        }
        accountInfoService.insertAccountInfoByLua(luaReuqest);
        return new CSResponse();
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月27日]
     */
    @Override
    public CSResponse requestPersonInfo(LuaReuqest luaReuqest) {
        if (luaReuqest.getType() == 0) {
            Long now = new Date().getTime();
            JedisLockUtil jedisLock = new JedisLockUtil(String.valueOf(luaReuqest.getUserId()), "requestPersonInfo", String.valueOf(now));
            try {
                if (jedisLock.lock()) {
                    List<PersonInfo> list = personInfoService.selectPersonInfoByLua(luaReuqest);
                    if (!list.isEmpty()) {
                        PersonInfo personInfo = list.get((int) (Math.random() * list.size()));
                        PersonInfo curp = new PersonInfo();
                        curp.setId(personInfo.getId());
                        curp.setUsedCnt(1);
                        curp.setStatus(Constant.status_1);
                        personInfoService.updatePersonInfoContent(curp);
                        return new CSResponse(personInfo);
                    }
                    return new CSResponse(ResponseEnum.PERSON_NONE_ERROR.getCode(), ResponseEnum.PERSON_NONE_ERROR.getDesc());
                }
                return new CSResponse(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getDesc());
            } catch (Exception e) {
                return new CSResponse(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getDesc());
            } finally {
                RedisUtil.delField(String.valueOf(luaReuqest.getUserId()), "requestPersonInfo");
                ;
            }
        } else {
            List<PersonInfo> list = personInfoService.selectPersonInfoByFileName(luaReuqest.getFileName(), luaReuqest.getUserId());
            if (!list.isEmpty()) {
                PersonInfo personInfo = list.get((int) (Math.random() * list.size()));
                return new CSResponse(personInfo);
            }
            return new CSResponse(ResponseEnum.PERSON_NONE_ERROR.getCode(), ResponseEnum.PERSON_NONE_ERROR.getDesc());
        }
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月27日]
     */
    @Override
    public CSResponse updatePersonInfo(PersonInfo personInfo) {
        int i = personInfoService.updatePersonInfoContent(personInfo);
        if (i > 0) {
            return new CSResponse();
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());

    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public CSResponse requestBundleName(Integer userId, Byte type) {
        if (type == 0) {
            List<String> list = taskConfigurationService.selectBundleNameByLua(userId);
            if (!list.isEmpty()) {
                return new CSResponse((Serializable) list);
            }
        } else if (type == 1) {
            List<String> list = taskConfigurationService.selectBundleNameForTask(userId);
            if (!list.isEmpty()) {
                return new CSResponse((Serializable) list);
            }
        } else {
            List<String> list = taskConfigurationService.selectDifferBundleName(userId);
            if (!list.isEmpty()) {
                return new CSResponse((Serializable) list);
            }
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public CSResponse requestIggCode(Integer userId, String phoneCode) {
		/*Long now = new Date().getTime();
		JedisLockUtil jedisLock = new JedisLockUtil(String.valueOf(userId),"requestIggCode", String.valueOf(now));
		try{
			if(jedisLock.lock()){
				List<IggList> list = iggListService.selectIggByLua(userId);
				if(!list.isEmpty()){
					IggList iggList = list.get((int)(Math.random()*list.size()));
					iggList.setPhoneCode(phoneCode);
					iggList.setStatus(Constant.status_2);
					iggList.setUsedTime(new Date());
					iggListService.updateIggList(iggList);
					return new CSResponse(iggList);
				}
				return new CSResponse(ResponseEnum.IGG_NONE_ERROR.getCode(),ResponseEnum.IGG_NONE_ERROR.getDesc());
			}
			return new CSResponse(ResponseEnum.ERROR.getCode(),ResponseEnum.ERROR.getDesc());
		}
		catch(Exception e){
			return new CSResponse(ResponseEnum.ERROR.getCode(),ResponseEnum.ERROR.getDesc());
		}
		finally{
			RedisUtil.delField(String.valueOf(userId), "requestIggCode");;
		}*/
        List<IggList> list = iggListService.selectIggByLua(userId);
        if (!list.isEmpty()) {
            IggList iggList = list.get((int) (Math.random() * list.size()));
            iggList.setPhoneCode(phoneCode);
            iggList.setStatus(Constant.status_2);
            iggList.setUsedTime(new Date());
            iggListService.updateIggList(iggList);
            return new CSResponse(iggList);
        }
        return new CSResponse(ResponseEnum.IGG_NONE_ERROR.getCode(), ResponseEnum.IGG_NONE_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public CSResponse iggRechargeReport(LuaReuqest luaReuqest, String outOfDate) {
        Byte isSuccess = luaReuqest.getIsSuccess();
        if (isSuccess == 0) {
            IggList iggList = new IggList();
            iggList.setId(luaReuqest.getIggId());
            iggList.setStatus(Constant.status_1);
            iggListService.updateIggList(iggList);
            PhoneList phoneList = new PhoneList();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = sdf.parse(outOfDate);
            } catch (ParseException e) {
                return new CSResponse(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getDesc());
            }
            phoneList.setDuetime(date);
            phoneList.setPhoneCode(luaReuqest.getPhoneCode());
            phoneList.setStatus(Constant.status_1);
            phoneList.setUserId(luaReuqest.getUserId());
            List<String> list = phoneListService.selectPhoneCode(phoneList);
            if (!list.isEmpty()) {
                phoneListService.updatePhoneListByLua(phoneList);
            } else {
                phoneListService.insertPhoneListByLua(phoneList);
            }
            return new CSResponse();
        } else if (isSuccess == 1) {
            IggList iggList = new IggList();
            iggList.setId(luaReuqest.getIggId());
            iggList.setStatus(Constant.status_1);
            iggListService.updateIggList(iggList);
            return new CSResponse();
        } else {
            IggList iggList = new IggList();
            iggList.setId(luaReuqest.getIggId());
            iggList.setStatus(Constant.status_0);
            iggListService.updateIggResetByLua(iggList);
            return new CSResponse();
        }
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public CSResponse requestAppleAccount(AppleAccount appleAccount) {
        List<AppleAccount> list = appleAccountService.selectAppleAccountByCountry(appleAccount);
        if (!list.isEmpty()) {
            AppleAccount cur = list.get((int) (Math.random() * list.size()));
            return new CSResponse(cur);
        }
        return new CSResponse(ResponseEnum.APPLE_ACCOUNT_NONE_ERROR.getCode(), ResponseEnum.APPLE_ACCOUNT_NONE_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public CSResponse appleAccountReport(AppleAccount appleAccount) {
        int i = appleAccountService.updateAppleAccountByLua(appleAccount.getId());
        if (i > 0) {
            return new CSResponse();
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public CSResponse uploadPathReplace(RetainedList retainedList, String reqTime) {
        Date date = null;
        try {
            date = new Date(Long.parseLong(reqTime));
        } catch (Exception e) {
            return new CSResponse(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getDesc());
        }
        retainedList.setUploadTime(date);
        List<RetainedList> list = retainedListService.selectRetainedListForReplaceUploadPath(retainedList);
        if (!list.isEmpty()) {
            RetainedList uploadPath = list.get((int) (Math.random() * list.size()));
            uploadPath.setIsDoSign(Constant.status_2);
            retainedListService.updateRetainedListForlua(uploadPath);
            return new CSResponse(uploadPath);
        }
        RetainedList curRetained = new RetainedList();
        curRetained.setIsDoSign(Constant.status_2);
        curRetained.setId(retainedList.getId());
        retainedListService.updateRetainedListForlua(curRetained);
        return new CSResponse(ResponseEnum.UPLOAD_NONE_ERROR.getCode(), ResponseEnum.UPLOAD_NONE_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public CSResponse requestPhoneProgram(Integer userId) {
        Map<String, Object> map = iphoneProgramService.selectIphoneProgramForLua(userId);
        Map<String, Object> address = iphoneRuleService.selectIphoneRuleForLua(userId);
        if (null != map && null != address) {
            map.put("address", address.get("address"));
            return new CSResponse((Serializable) map);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }


}
