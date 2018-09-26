package com.xtzn.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtzn.business.IAllianceBusiness;
import com.xtzn.business.IAppleAccountBusiness;
import com.xtzn.business.ICountryBusiness;
import com.xtzn.business.IIdfaBusiness;
import com.xtzn.business.IIphoneProgramBusiness;
import com.xtzn.business.IIphoneRuleBusiness;
import com.xtzn.business.ILuminatiBusiness;
import com.xtzn.business.INoReturnAllianceBusiness;
import com.xtzn.business.IRetainedProgramBusiness;
import com.xtzn.business.IThirdPartyBusiness;
import com.xtzn.business.ITimelineProgramBusiness;
import com.xtzn.business.ITimezoneBusiness;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.Alliance;
import com.xtzn.mapper.entity.AppleAccount;
import com.xtzn.mapper.entity.Country;
import com.xtzn.mapper.entity.Idfa;
import com.xtzn.mapper.entity.IphoneProgram;
import com.xtzn.mapper.entity.IphoneRule;
import com.xtzn.mapper.entity.Luminati;
import com.xtzn.mapper.entity.RetainedProgram;
import com.xtzn.mapper.entity.ThirdParty;
import com.xtzn.mapper.entity.TimelineProgram;
import com.xtzn.mapper.entity.Timezone;
import com.xtzn.utils.ListUtil;
import com.xtzn.vo.CSRequest;
import com.xtzn.vo.DataRequest;

/**
 * 功能描述: <br>
 * 数据管理
 *
 * @author zyw
 * @version [版本号, 2018年4月12日]
 */
@Controller
@RequestMapping("/dataManage")
public class DataManageController {

    @Autowired
    private ITimezoneBusiness timezoneBusiness;

    @Autowired
    private ICountryBusiness countryBusiness;

    @Autowired
    private IAllianceBusiness allianceBusiness;

    @Autowired
    private IAppleAccountBusiness appleAccountBusiness;

    @Autowired
    private ITimelineProgramBusiness timelineProgramBusiness;

    @Autowired
    private IRetainedProgramBusiness retainedProgramBusiness;

    @Autowired
    private ILuminatiBusiness luminatiBusiness;

    @Autowired
    private IIphoneProgramBusiness iphoneProgramBusiness;

    @Autowired
    private IIphoneRuleBusiness iphoneRuleBusiness;

    @Autowired
    private IThirdPartyBusiness thirdPartyBusiness;

    @Autowired
    private INoReturnAllianceBusiness noReturnAllianceBusiness;

    @Autowired
    private IIdfaBusiness idfaBusiness;

    /**
     * 功能描述: <br>
     * 添加时区接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/addTimezone", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse addTimezone(Timezone param) {
        String country = param.getCountry();
        String timezone = param.getTimezone();
        if (null == country || null == timezone) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return timezoneBusiness.createTimezone(param);
    }

    /**
     * 功能描述: <br>
     * 删除单个时区信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteSingleTimezone", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteSingleTimezone(Timezone param) {
        Integer id = param.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return timezoneBusiness.deleteSingleTimezone(id);
    }

    /**
     * 功能描述: <br>
     * 批量删除时区信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteBatchTimezone", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchTimezone(String ids) {
        if (null == ids) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return timezoneBusiness.deleteBatchTimezone(list);
    }

    /**
     * 功能描述: <br>
     * 查询单个时区信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveTimezone", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveTimezone(Timezone param) {
        Integer id = param.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return timezoneBusiness.retrieveSingleTimezone(id);
    }

    /**
     * 功能描述: <br>
     * 查询时区信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveTimezones", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveTimezones(CSRequest csRequest) {
        if (null == csRequest.getPageIndex()) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return timezoneBusiness.retrieveTimezoneByPage(csRequest);
    }

    /**
     * 功能描述: <br>
     * 修改时区信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyTimezone", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyTimezone(Timezone param) {
        String country = param.getCountry();
        String timezone = param.getTimezone();
        Integer id = param.getId();
        if (null == country || null == timezone || null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return timezoneBusiness.updateTimezone(param);
    }

    /**
     * 功能描述: <br>
     * 修改时区信息使用状态接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyTimezoneStatus", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyTimezoneStatus(Timezone param) {
        Byte status = param.getStatus();
        Integer id = param.getId();
        if (null == status || null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return timezoneBusiness.updateTimezoneByStatus(status, id);
    }

    /**
     * 功能描述: <br>
     * 添加国家信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/addCountry", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse addCountry(Country country) {
        String name = country.getName();
        if (null == name) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return countryBusiness.createCountry(country);
    }

    /**
     * 功能描述: <br>
     * 删除单个国家信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteSingleCountry", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteSingleCountry(Country country) {
        Integer id = country.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return countryBusiness.deleteSingleCountry(id);
    }

    /**
     * 功能描述: <br>
     * 批量删除国家信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteBatchCountry", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchCountry(String ids) {
        if (null == ids) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return countryBusiness.deleteBatchCountry(list);
    }

    /**
     * 功能描述: <br>
     * 查询单个国家信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveCountry", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveCountry(Country country) {
        Integer id = country.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return countryBusiness.retrieveSingleCountry(id);
    }

    /**
     * 功能描述: <br>
     * 查询国家信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveCountries", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveCountries(CSRequest csRequest) {
        if (csRequest.getPageIndex() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return countryBusiness.retrieveCountryByPage(csRequest);
    }

    /**
     * 功能描述: <br>
     * 查询所有国家信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveUsingCountry", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveUsingCountry(Country country) {
        return countryBusiness.retrieveUsingCountry(country);
    }

    /**
     * 功能描述: <br>
     * 修改国家信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyCountry", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyCountry(Country country) {
        String name = country.getName();
        Integer id = country.getId();
        if (null == name) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return countryBusiness.updateCountry(name, id);
    }

    /**
     * 功能描述: <br>
     * 修改国家信息使用状态接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyCountryStatus", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyCountryStatus(Country country) {
        Byte status = country.getStatus();
        Integer id = country.getId();
        if (null == id || null == status) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return countryBusiness.updateCountryByStatus(status, id);
    }

    /**
     * 功能描述: <br>
     * 添加新的联盟接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/addAlliance", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse addAlliance(Alliance alliance) {
        String affiliateAccountName = alliance.getAffiliateAccountName();
        String affiliateAccountLogo = alliance.getAffiliateAccountLogo();
        Integer userId = alliance.getUserId();
        if (null == affiliateAccountName || null == affiliateAccountLogo || null == userId) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return allianceBusiness.createAlliance(alliance);
    }

    /**
     * 功能描述: <br>
     * 删除单个联盟接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteSingleAlliance", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteSingleAlliance(Alliance alliance) {
        Integer id = alliance.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return allianceBusiness.deleteSingleAlliance(id);
    }

    /**
     * 功能描述: <br>
     * 批量删除联盟接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteBatchAlliance", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchAlliance(String ids) {
        if (null == ids) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return allianceBusiness.deleteBatchAlliance(list);
    }

    /**
     * 功能描述: <br>
     * 查询单个联盟信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveAlliance", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveAlliance(Alliance alliance) {
        Integer id = alliance.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return allianceBusiness.retrieveSingleAlliance(id);
    }

    /**
     * 功能描述: <br>
     * 查询在使用的联盟信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveUsingAlliance", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveUsingAlliance(Alliance alliance) {
        if (alliance.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return allianceBusiness.retrieveUsingAlliance(alliance);
    }

    /**
     * 功能描述: <br>
     * 查询在使用的联盟名称接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveUsingAllianceName", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveUsingAllianceName(Alliance alliance) {
        if (alliance.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return allianceBusiness.retrieveUsingAllianceName(alliance);
    }

    /**
     * 功能描述: <br>
     * 根据联盟名称查询联盟信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveUsingAllianceByName", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveUsingAllianceByName(Alliance alliance) {
        if (alliance.getUserId() == null || alliance.getAffiliateAccountName() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return allianceBusiness.retrieveAllianceByName(alliance);
    }

    /**
     * 功能描述: <br>
     * 普通用户查询联盟信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveAlliances", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveAlliances(CSRequest csRequest) {
        if (csRequest.getPageIndex() == null || csRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return allianceBusiness.retrieveAllianceByPage(csRequest);
    }

    //管理元查询联盟信息接口
    @RequestMapping(value = "/retrieveAllAlliances", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveAllAlliances(CSRequest csRequest) {
        if (csRequest.getPageIndex() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return allianceBusiness.retrieveAllAllianceByPage(csRequest);
    }

    /**
     * 功能描述: <br>
     * 修改联盟信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyAlliance", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyAlliance(Alliance alliance) {
        Integer id = alliance.getId();
        String affiliateAccountName = alliance.getAffiliateAccountName();
        String affiliateAccountLogo = alliance.getAffiliateAccountLogo();
        if (null == affiliateAccountName || null == affiliateAccountLogo || null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return allianceBusiness.updateAlliance(alliance);
    }

    /**
     * 功能描述: <br>
     * 修改联盟使用状态接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyAllianceStatus", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyAllianceStatus(Alliance alliance) {
        Integer id = alliance.getId();
        Byte status = alliance.getStatus();
        if (null == status || null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return allianceBusiness.updateAllianceByStatus(status, id);
    }

    /**
     * 功能描述: <br>
     * 添加苹果账号接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/addAppleAccount", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse addAppleAccount(AppleAccount appleAccount) {
        String userName = appleAccount.getUserName();
        String password = appleAccount.getPassword();
        String country = appleAccount.getCountry();
        if (null == userName || null == password || null == country) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return appleAccountBusiness.createAppleAccount(appleAccount);
    }

    @RequestMapping(value = "/createBatchAppleAccount", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse createBatchAppleAccount(String account, String country, Integer userId) {
        if (null == account || null == country) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return appleAccountBusiness.createBatchAppleAccount(account, country);
    }

    /**
     * 功能描述: <br>
     * 删除单个苹果账号接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteSingleAppleAccount", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteSingleAppleAccount(AppleAccount appleAccount) {
        Integer id = appleAccount.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return appleAccountBusiness.deleteSingleAppleAccount(id);
    }

    /**
     * 功能描述: <br>
     * 批量删除苹果账号接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteBatchAppleAccount", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchAppleAccount(String ids) {
        if (null == ids) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return appleAccountBusiness.deleteBatchAppleAccount(list);
    }

    /**
     * 功能描述: <br>
     * 查询单个苹果账号接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveAppleAccount", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveAppleAccount(AppleAccount appleAccount) {
        Integer id = appleAccount.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return appleAccountBusiness.retrieveSingleAppleAccount(id);
    }

    /**
     * 功能描述: <br>
     * 查询使用中的所有苹果账号接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveUsingAppleAccount", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveUsingAppleAccount(AppleAccount appleAccount) {
        return appleAccountBusiness.retrieveUsingAppleAccount(appleAccount);
    }

    /**
     * 功能描述: <br>
     * 查询苹果账号接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveAppleAccounts", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveAppleAccounts(DataRequest dataRequest) {
        if (dataRequest.getPageIndex() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return appleAccountBusiness.retrieveAppleAccountByPage(dataRequest);
    }

    /**
     * 功能描述: <br>
     * 修改苹果账号接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyAppleAccount", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyAppleAccount(AppleAccount appleAccount) {
        Integer id = appleAccount.getId();
        String country = appleAccount.getCountry();
        String password = appleAccount.getPassword();
        String userName = appleAccount.getUserName();
        if (null == id || null == country || null == password || null == userName) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return appleAccountBusiness.updateAppleAccount(appleAccount);
    }

    /**
     * 功能描述: <br>
     * 重置苹果账号使用状态接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyAppleAccountStatus", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyAppleAccountStatus(AppleAccount appleAccount) {
        return appleAccountBusiness.updateAppleAccountByStatus(appleAccount);
    }

    /**
     * 功能描述: <br>
     * 添加时间轴方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/addTimelineProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse addTimelineProgram(TimelineProgram timelineProgram) {
        String programName = timelineProgram.getProgramName();
        String program = timelineProgram.getProgram();
        Integer userId = timelineProgram.getUserId();
        if (null == programName || null == program || null == userId) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return timelineProgramBusiness.createTimelineProgram(timelineProgram);
    }

    /**
     * 功能描述: <br>
     * 删除单个时间轴方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteSingleTimelineProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteSingleTimelineProgram(TimelineProgram timelineProgram) {
        Integer id = timelineProgram.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return timelineProgramBusiness.deleteSingleTimelineProgram(id);
    }

    /**
     * 功能描述: <br>
     * 批量删除时间轴方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteBatchTimelineProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchTimelineProgram(String ids) {

        if (null == ids) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return timelineProgramBusiness.deleteBatchTimelineProgram(list);
    }

    /**
     * 功能描述: <br>
     * 查询单个时间轴方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveTimelineProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveTimelineProgram(TimelineProgram timelineProgram) {
        Integer id = timelineProgram.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return timelineProgramBusiness.retrieveSingleTimelineProgram(id);
    }

    /**
     * 功能描述: <br>
     * 查询使用中的时间轴方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveUsingTimelineProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveUsingTimelineProgram(TimelineProgram timelineProgram) {
        if (timelineProgram.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return timelineProgramBusiness.retrieveUsingTimelineProgram(timelineProgram);
    }

    /**
     * 功能描述: <br>
     * 查询时间轴方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveTimelinePrograms", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveTimelinePrograms(CSRequest csRequest) {
        if (null == csRequest.getPageIndex() || null == csRequest.getUserId()) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return timelineProgramBusiness.retrieveTimelineProgramByPage(csRequest);
    }

    /**
     * 功能描述: <br>
     * 修改时间轴方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyTimelineProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyTimelineProgram(TimelineProgram timelineProgram) {
        Integer id = timelineProgram.getId();
        String programName = timelineProgram.getProgramName();
        String program = timelineProgram.getProgram();
        if (null == id || null == programName || null == program) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return timelineProgramBusiness.updateTimelineProgram(timelineProgram);
    }

    /**
     * 功能描述: <br>
     * 修改时间轴方案使用状态接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyTimelineProgramStatus", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyTimelineProgramStatus(TimelineProgram timelineProgram) {
        Integer id = timelineProgram.getId();
        Byte status = timelineProgram.getStatus();
        if (null == id || null == status) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return timelineProgramBusiness.updateTimelineProgramByStatus(status, id);
    }

    /**
     * 功能描述: <br>
     * 添加留存方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/addRetainedProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse addRetainedProgram(RetainedProgram retainedProgram) {
        String programName = retainedProgram.getProgramName();
        String program = retainedProgram.getProgram();
        Integer userId = retainedProgram.getUserId();
        if (null == programName || null == program || null == userId) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return retainedProgramBusiness.createRetainedProgram(retainedProgram);
    }

    /**
     * 功能描述: <br>
     * 删除单个留存方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteSingleRetainedProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteSingleRetainedProgram(RetainedProgram retainedProgram) {
        Integer id = retainedProgram.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return retainedProgramBusiness.deleteSingleRetainedProgram(id);
    }

    /**
     * 功能描述: <br>
     * 批量删除留存方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteBatchRetainedProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchRetainedProgram(String ids) {
        if (null == ids) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return retainedProgramBusiness.deleteBatchRetainedProgram(list);
    }

    /**
     * 功能描述: <br>
     * 查询单个留存方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveRetainedProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveRetainedProgram(RetainedProgram retainedProgram) {
        Integer id = retainedProgram.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return retainedProgramBusiness.retrieveSingleRetainedProgram(id);
    }

    /**
     * 功能描述: <br>
     * 查询使用中的留存方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveUsingRetainedProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveUsingRetainedProgram(RetainedProgram retainedProgram) {
        if (retainedProgram.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return retainedProgramBusiness.retrieveUsingRetainedProgram(retainedProgram);
    }

    /**
     * 功能描述: <br>
     * 查询留存方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveRetainedPrograms", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveRetainedPrograms(CSRequest csRequest) {
        if (null == csRequest.getPageIndex() || null == csRequest.getUserId()) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return retainedProgramBusiness.retrieveRetainedProgramByPage(csRequest);
    }

    /**
     * 功能描述: <br>
     * 修改留存方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyRetainedProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyRetainedProgram(RetainedProgram retainedProgram) {
        Integer id = retainedProgram.getId();
        String programName = retainedProgram.getProgramName();
        String program = retainedProgram.getProgram();
        if (null == id || null == programName || null == program) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return retainedProgramBusiness.updateRetainedProgram(retainedProgram);
    }

    /**
     * 功能描述: <br>
     * 修改留存方案状态接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyRetainedProgramStatus", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyRetainedProgramStatus(RetainedProgram retainedProgram) {
        Integer id = retainedProgram.getId();
        Byte status = retainedProgram.getStatus();
        if (null == id || null == status) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return retainedProgramBusiness.updateRetainedProgramByStatus(status, id);
    }

    /**
     * 功能描述: <br>
     * 添加luminati接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/addLuminati", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse addLuminati(Luminati luminati) {
        String customer = luminati.getCustomer();
        String zone = luminati.getZone();
        String password = luminati.getPassword();
        Integer port = luminati.getPort();
        Integer userId = luminati.getUserId();
        if (null == customer || null == zone || null == password || null == port || null == userId) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luminatiBusiness.createLuminati(luminati);
    }

    /**
     * 功能描述: <br>
     * 删除单个luminati接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteSingleLuminati", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteSingleLuminati(Luminati luminati) {
        Integer id = luminati.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luminatiBusiness.deleteSingleLuminati(id);
    }

    /**
     * 功能描述: <br>
     * 批量删除luminati接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteBatchLuminati", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchLuminati(String ids) {
        if (null == ids) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return luminatiBusiness.deleteBatchLuminati(list);
    }

    /**
     * 功能描述: <br>
     * 查询单个luminati接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveLuminati", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveLuminati(Luminati luminati) {
        Integer id = luminati.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luminatiBusiness.retrieveSingleLuminati(id);
    }

    /**
     * 功能描述: <br>
     * 查询luminati接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveLuminatis", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveLuminatis(CSRequest csRequest) {
        if (null == csRequest.getPageIndex() || null == csRequest.getUserId()) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luminatiBusiness.retrieveLuminatiByPage(csRequest);
    }

    /**
     * 功能描述: <br>
     * 修改luminati信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyLuminati", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyLuminati(Luminati luminati) {
        Integer id = luminati.getId();
        String customer = luminati.getCustomer();
        String zone = luminati.getZone();
        String password = luminati.getPassword();
        Integer port = luminati.getPort();
        if (null == id || null == customer || null == zone || null == password || null == port) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luminatiBusiness.updateLuminati(luminati);
    }

    /**
     * 功能描述: <br>
     * 更换使用的luminati接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyLuminatiStatus", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyLuminatiStatus(Luminati luminati) {
        Integer id = luminati.getId();
        Integer userId = luminati.getUserId();
        if (null == id || null == userId) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return luminatiBusiness.updateLuminatiByStatus(luminati);
    }

    /**
     * 功能描述: <br>
     * 添加手机配置方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/addIphoneProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse addIphoneProgram(IphoneProgram iphoneProgram) {
        String name = iphoneProgram.getName();
        Integer downloadMinNumber = iphoneProgram.getDownloadMinNumber();
        Integer downloadMaxNumber = iphoneProgram.getDownloadMaxNumber();
        Integer retainedMinNumber = iphoneProgram.getRetainedMinNumber();
        Integer retainedMaxNumber = iphoneProgram.getRetainedMaxNumber();
        Integer registerMinNumber = iphoneProgram.getRegisterMinNumber();
        Integer registerMaxNumber = iphoneProgram.getRegisterMaxNumber();
        Integer accountMinNumber = iphoneProgram.getAccountMinNumber();
        Integer accountMaxNumber = iphoneProgram.getAccountMaxNumber();
        Integer testMinNumber = iphoneProgram.getTestMinNumber();
        Integer testMaxNumber = iphoneProgram.getTestMaxNumber();
        Integer userId = iphoneProgram.getUserId();
        if (null == name || null == downloadMaxNumber || null == downloadMinNumber || null == registerMaxNumber || null == registerMinNumber || null == retainedMaxNumber || null == retainedMinNumber || null == accountMaxNumber || null == accountMinNumber || null == testMaxNumber || null == testMinNumber || null == userId) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iphoneProgramBusiness.createIphoneProgram(iphoneProgram);
    }

    /**
     * 功能描述: <br>
     * 删除单个手机配置方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteSingleIphoneProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteSingleIphoneProgram(IphoneProgram iphoneProgram) {
        Integer id = iphoneProgram.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iphoneProgramBusiness.deleteSingleIphoneProgram(id);
    }

    /**
     * 功能描述: <br>
     * 批量删除手机配置方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteBatchIphoneProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchIphoneProgram(String ids) {
        if (null == ids) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return iphoneProgramBusiness.deleteBatchIphoneProgram(list);
    }

    /**
     * 功能描述: <br>
     * 查看单个手机配置方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveIphoneProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveIphoneProgram(IphoneProgram iphoneProgram) {
        Integer id = iphoneProgram.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iphoneProgramBusiness.retrieveSingleIphoneProgram(id);
    }

    /**
     * 功能描述: <br>
     * 查看手机配置方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveIphonePrograms", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveIphonePrograms(CSRequest csRequest) {
        if (csRequest.getPageIndex() == null || csRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iphoneProgramBusiness.retrieveIphoneProgramByPage(csRequest);
    }

    /**
     * 功能描述: <br>
     * 修改手机配置方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyIphoneProgram", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyIphoneProgram(IphoneProgram iphoneProgram) {
        String name = iphoneProgram.getName();
        Integer downloadMinNumber = iphoneProgram.getDownloadMinNumber();
        Integer downloadMaxNumber = iphoneProgram.getDownloadMaxNumber();
        Integer retainedMinNumber = iphoneProgram.getRetainedMinNumber();
        Integer retainedMaxNumber = iphoneProgram.getRetainedMaxNumber();
        Integer registerMinNumber = iphoneProgram.getRegisterMinNumber();
        Integer registerMaxNumber = iphoneProgram.getRegisterMaxNumber();
        Integer accountMinNumber = iphoneProgram.getAccountMinNumber();
        Integer accountMaxNumber = iphoneProgram.getAccountMaxNumber();
        Integer testMinNumber = iphoneProgram.getTestMinNumber();
        Integer testMaxNumber = iphoneProgram.getTestMaxNumber();
        if (null == name || null == downloadMaxNumber || null == downloadMinNumber || null == registerMaxNumber || null == registerMinNumber || null == retainedMaxNumber || null == retainedMinNumber || null == accountMaxNumber || null == accountMinNumber || null == testMaxNumber || null == testMinNumber) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iphoneProgramBusiness.updateIphoneProgram(iphoneProgram);
    }

    /**
     * 功能描述: <br>
     * 更换正在使用的手机配置方案接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyIphoneProgramStatus", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyIphoneProgramStatus(IphoneProgram iphoneProgram) {
        Integer id = iphoneProgram.getId();
        Integer userId = iphoneProgram.getUserId();
        if (null == id || null == userId) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iphoneProgramBusiness.updateIphoneProgramByStatus(iphoneProgram);
    }

    /**
     * 功能描述: <br>
     * 添加ftp规则及地址接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/addIphoneRule", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse addIphoneRule(IphoneRule iphoneRule) {
        String name = iphoneRule.getName();
        String address = iphoneRule.getAddress();
        String url = iphoneRule.getUrl();
        Byte type = iphoneRule.getType();
        Integer userId = iphoneRule.getUserId();
        if (null == name || null == address || null == url || null == type || null == userId) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iphoneRuleBusiness.createIphoneRule(iphoneRule);
    }

    /**
     * 功能描述: <br>
     * 删除单个ftp规则及地址接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteSingleIphoneRule", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteSingleIphoneRule(IphoneRule iphoneRule) {
        Integer id = iphoneRule.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iphoneRuleBusiness.deleteSingleIphoneRule(id);
    }

    /**
     * 功能描述: <br>
     * 批量删除ftp规则及地址接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/deleteBatchIphoneRule", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchIphoneRule(String ids) {
        if (null == ids) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return iphoneRuleBusiness.deleteBatchIphoneRule(list);
    }

    /**
     * 功能描述: <br>
     * 查询单个ftp规则及地址接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveIphoneRule", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveIphoneRule(IphoneRule iphoneRule) {
        Integer id = iphoneRule.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iphoneRuleBusiness.retrieveSingleIphoneRule(id);
    }

    /**
     * 功能描述: <br>
     * 查询单个ftp规则及地址接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/retrieveIphoneRules", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveIphoneRules(CSRequest csRequest) {
        if (null == csRequest.getPageIndex() || null == csRequest.getUserId()) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iphoneRuleBusiness.retrieveIphoneRuleByPage(csRequest);
    }

    /**
     * 功能描述: <br>
     * 修改ftp规则及地址信息接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyIphoneRule", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyIphoneRule(IphoneRule iphoneRule) {
        String name = iphoneRule.getName();
        String address = iphoneRule.getAddress();
        String url = iphoneRule.getUrl();
        Byte type = iphoneRule.getType();
        if (null == name || null == address || null == url || null == type) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iphoneRuleBusiness.updateIphoneRule(iphoneRule);
    }

    /**
     * 功能描述: <br>
     * 修改ftp规则及地址使用状态接口
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @RequestMapping(value = "/modifyIphoneRuleStatus", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyIphoneRuleStatus(IphoneRule iphoneRule) {
        Integer id = iphoneRule.getId();
        Byte status = iphoneRule.getStatus();
        if (null == id || null == status) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iphoneRuleBusiness.updateIphoneRuleByStatus(id, status);
    }

    @RequestMapping(value = "/createThirdParty", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse createThirdParty(ThirdParty thirdParty) {
        if (thirdParty.getName() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return thirdPartyBusiness.insertThirdParty(thirdParty);
    }

    @RequestMapping(value = "/retrieveThirdPartyById", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveThirdPartyById(ThirdParty thirdParty) {
        if (thirdParty.getId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return thirdPartyBusiness.selectThirdPartyById(thirdParty);
    }

    @RequestMapping(value = "/retrieveThirdPartyByPage", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveThirdPartyByPage(CSRequest csRequest) {
        if (csRequest.getPageIndex() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return thirdPartyBusiness.selectThirdPartyByPage(csRequest);
    }

    @RequestMapping(value = "/retrieveAllThirdParty", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveAllThirdParty() {
        return thirdPartyBusiness.selectAllThirdParty();
    }

    @RequestMapping(value = "/retrieveNameByCondition", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveNameByCondition(ThirdParty thirdParty) {
        if (thirdParty.getName() == null || "".equals(thirdParty.getName())) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return thirdPartyBusiness.selectNameByCondition(thirdParty);
    }

    @RequestMapping(value = "/deleteThirdPartyById", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteThirdPartyById(ThirdParty thirdParty) {
        if (thirdParty.getId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return thirdPartyBusiness.deleteById(thirdParty);
    }

    @RequestMapping(value = "/deleteBatchThirdParty", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchThirdParty(String ids) {
        if (ids == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return thirdPartyBusiness.deleteBatchById(list);
    }

    @RequestMapping(value = "/modifyThirdParty", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyThirdParty(ThirdParty thirdParty) {
        if (thirdParty.getId() == null || thirdParty.getName() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return thirdPartyBusiness.updateThirdParty(thirdParty);
    }

    @RequestMapping(value = "/retrieveNoReturnAlliance", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveNoReturnAlliance(CSRequest csRequest) {
        if (csRequest.getUserId() == null || csRequest.getPageIndex() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return noReturnAllianceBusiness.selectNoReturnAllianceByPage(csRequest);
    }

    @RequestMapping(value = "/createNoReturnAlliance", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse createNoReturnAlliance(String noReturnAlliances, Integer userId) {
        if (noReturnAlliances == null || userId == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<String> list = Arrays.asList(noReturnAlliances.split(","));
        return noReturnAllianceBusiness.insertNoReturnAlliance(list, userId);
    }

    @RequestMapping(value = "/deleteBatchNoReturnAlliance", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchNoReturnAlliance(CSRequest csRequest) {
        if (csRequest.getIds() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(csRequest.getIds());
        return noReturnAllianceBusiness.deleteBatchById(list);
    }

    @RequestMapping(value = "/accessibleIdfaCount", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse accessibleIdfaCount(DataRequest dataRequest) {
        if (dataRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        if (dataRequest.getThirdParty() == null && dataRequest.getTaskName() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return idfaBusiness.selectAccessibleIdfaCount(dataRequest);
    }

    @RequestMapping(value = "/createIdfa", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse createIdfa(Idfa idfa) {
        if (idfa.getIdfaCode() == null || idfa.getThirdParty() == null || idfa.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return idfaBusiness.createIdfa(idfa);
    }

    @RequestMapping(value = "/selectLockedAppleAccount", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse selectLockedAppleAccount() {
        return appleAccountBusiness.selectLockedAppleAccount();
    }
}
