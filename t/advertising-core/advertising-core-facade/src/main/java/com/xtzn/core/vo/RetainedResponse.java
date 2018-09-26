package com.xtzn.core.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年5月8日]
 */
public class RetainedResponse implements Serializable {

    private static final long serialVersionUID = -3880292606133729029L;
    private Integer id;
    private String uploadPath;
    private Integer keepDays;
    private Date uploadTime;

    private Integer taskId;
    private Byte longTimeSign;
    private Byte levelType;
    private String country;
    private String affiliateAccount;
    private Integer playTimeMin;
    private Integer playTimeMax;
    private Byte generateRetainedType;
    private Integer everydayLevelMin;
    private Integer everydayLevelMax;
    private Integer morrowdayLevelMin;
    private Integer morrowdayLevelMax;
    private String configurationName;
    private String scriptName;
    private String bundleName;
    private String userName;
    private String password;
    private String thirdPartyName;

    private Byte distributeType;

    private String currentTime;

    private List<Map<String, Object>> ruleAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Byte getLongTimeSign() {
        return longTimeSign;
    }

    public void setLongTimeSign(Byte longTimeSign) {
        this.longTimeSign = longTimeSign;
    }

    public Byte getLevelType() {
        return levelType;
    }

    public void setLevelType(Byte levelType) {
        this.levelType = levelType;
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

    public Byte getGenerateRetainedType() {
        return generateRetainedType;
    }

    public void setGenerateRetainedType(Byte generateRetainedType) {
        this.generateRetainedType = generateRetainedType;
    }

    public Integer getEverydayLevelMin() {
        return everydayLevelMin;
    }

    public void setEverydayLevelMin(Integer everydayLevelMin) {
        this.everydayLevelMin = everydayLevelMin;
    }

    public Integer getEverydayLevelMax() {
        return everydayLevelMax;
    }

    public void setEverydayLevelMax(Integer everydayLevelMax) {
        this.everydayLevelMax = everydayLevelMax;
    }

    public Integer getMorrowdayLevelMin() {
        return morrowdayLevelMin;
    }

    public void setMorrowdayLevelMin(Integer morrowdayLevelMin) {
        this.morrowdayLevelMin = morrowdayLevelMin;
    }

    public Integer getMorrowdayLevelMax() {
        return morrowdayLevelMax;
    }

    public void setMorrowdayLevelMax(Integer morrowdayLevelMax) {
        this.morrowdayLevelMax = morrowdayLevelMax;
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

    public Byte getDistributeType() {
        return distributeType;
    }

    public void setDistributeType(Byte distributeType) {
        this.distributeType = distributeType;
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

    public Integer getKeepDays() {
        return keepDays;
    }

    public void setKeepDays(Integer keepDays) {
        this.keepDays = keepDays;
    }

}
