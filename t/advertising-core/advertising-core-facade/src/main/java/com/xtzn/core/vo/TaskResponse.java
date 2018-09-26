package com.xtzn.core.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年5月8日]
 */
public class TaskResponse implements Serializable {

    private static final long serialVersionUID = -6651033972583668009L;

    private Integer id;

    private String taskName;

    private String country;

    private String affiliateAccount;

    private String landingPageLink;

    private Integer playTimeMin;

    private Integer playTimeMax;

    private Integer specialTimeMin;

    private Integer specialTimeMax;

    private Integer specialPercent;

    private Integer linkWaitTime;

    private Integer appWaitTime;

    private String retainedPercent;

    private Integer retainKeepDays;

    private Byte isChangeIdfa;

    private String timeline;

    private String timelinedtl;

    private Byte type;

    private Byte downloadType;

    private String newPhonePercent;

    private Byte generateRetainedType;

    private Byte taskModel;

    private Integer todayLevelMin;

    private Integer todayLevelMax;

    private Double todayLevelPercent;

    private Integer everydayLevelMin;

    private Double everydayLevelMax;
    private String configurationName;
    private String scriptName;
    private String bundleName;
    private String userName;
    private String password;
    private String thirdPartyName;

    private String subId;

    private String currentTime;

    private List<Map<String, Object>> ruleAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAffiliateAccount() {
        return affiliateAccount;
    }

    public void setAffiliateAccount(String affiliateAccount) {
        this.affiliateAccount = affiliateAccount;
    }

    public String getLandingPageLink() {
        return landingPageLink;
    }

    public void setLandingPageLink(String landingPageLink) {
        this.landingPageLink = landingPageLink;
    }

    public Integer getPlayTimeMin() {
        return playTimeMin;
    }

    public void setPlayTimeMin(Integer playTimeMin) {
        this.playTimeMin = playTimeMin;
    }

    public Integer getPlayTimeMax() {
        return playTimeMax;
    }

    public void setPlayTimeMax(Integer playTimeMax) {
        this.playTimeMax = playTimeMax;
    }

    public Integer getSpecialTimeMin() {
        return specialTimeMin;
    }

    public void setSpecialTimeMin(Integer specialTimeMin) {
        this.specialTimeMin = specialTimeMin;
    }

    public Integer getSpecialTimeMax() {
        return specialTimeMax;
    }

    public void setSpecialTimeMax(Integer specialTimeMax) {
        this.specialTimeMax = specialTimeMax;
    }

    public Integer getSpecialPercent() {
        return specialPercent;
    }

    public void setSpecialPercent(Integer specialPercent) {
        this.specialPercent = specialPercent;
    }

    public Integer getLinkWaitTime() {
        return linkWaitTime;
    }

    public void setLinkWaitTime(Integer linkWaitTime) {
        this.linkWaitTime = linkWaitTime;
    }

    public Integer getAppWaitTime() {
        return appWaitTime;
    }

    public void setAppWaitTime(Integer appWaitTime) {
        this.appWaitTime = appWaitTime;
    }

    public String getRetainedPercent() {
        return retainedPercent;
    }

    public void setRetainedPercent(String retainedPercent) {
        this.retainedPercent = retainedPercent;
    }

    public Integer getRetainKeepDays() {
        return retainKeepDays;
    }

    public void setRetainKeepDays(Integer retainKeepDays) {
        this.retainKeepDays = retainKeepDays;
    }

    public Byte getIsChangeIdfa() {
        return isChangeIdfa;
    }

    public void setIsChangeIdfa(Byte isChangeIdfa) {
        this.isChangeIdfa = isChangeIdfa;
    }

    public String getTimeline() {
        return timeline;
    }

    public void setTimeline(String timeline) {
        this.timeline = timeline;
    }

    public String getTimelinedtl() {
        return timelinedtl;
    }

    public void setTimelinedtl(String timelinedtl) {
        this.timelinedtl = timelinedtl;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getDownloadType() {
        return downloadType;
    }

    public void setDownloadType(Byte downloadType) {
        this.downloadType = downloadType;
    }

    public String getNewPhonePercent() {
        return newPhonePercent;
    }

    public void setNewPhonePercent(String newPhonePercent) {
        this.newPhonePercent = newPhonePercent;
    }

    public Byte getGenerateRetainedType() {
        return generateRetainedType;
    }

    public void setGenerateRetainedType(Byte generateRetainedType) {
        this.generateRetainedType = generateRetainedType;
    }

    public Byte getTaskModel() {
        return taskModel;
    }

    public void setTaskModel(Byte taskModel) {
        this.taskModel = taskModel;
    }

    public Integer getTodayLevelMin() {
        return todayLevelMin;
    }

    public void setTodayLevelMin(Integer todayLevelMin) {
        this.todayLevelMin = todayLevelMin;
    }

    public Integer getTodayLevelMax() {
        return todayLevelMax;
    }

    public void setTodayLevelMax(Integer todayLevelMax) {
        this.todayLevelMax = todayLevelMax;
    }

    public Double getTodayLevelPercent() {
        return todayLevelPercent;
    }

    public void setTodayLevelPercent(Double todayLevelPercent) {
        this.todayLevelPercent = todayLevelPercent;
    }

    public Integer getEverydayLevelMin() {
        return everydayLevelMin;
    }

    public void setEverydayLevelMin(Integer everydayLevelMin) {
        this.everydayLevelMin = everydayLevelMin;
    }

    public Double getEverydayLevelMax() {
        return everydayLevelMax;
    }

    public void setEverydayLevelMax(Double everydayLevelMax) {
        this.everydayLevelMax = everydayLevelMax;
    }

    public String getConfigurationName() {
        return configurationName;
    }

    public void setConfigurationName(String configurationName) {
        this.configurationName = configurationName;
    }

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getThirdPartyName() {
        return thirdPartyName;
    }

    public void setThirdPartyName(String thirdPartyName) {
        this.thirdPartyName = thirdPartyName;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public List<Map<String, Object>> getRuleAddress() {
        return ruleAddress;
    }

    public void setRuleAddress(List<Map<String, Object>> ruleAddress) {
        this.ruleAddress = ruleAddress;
    }

}
