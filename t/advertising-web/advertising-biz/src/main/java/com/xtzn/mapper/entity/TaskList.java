package com.xtzn.mapper.entity;

import java.io.Serializable;
import java.util.Date;

public class TaskList implements Serializable {

    private static final long serialVersionUID = 1638308281656882286L;

    private Integer id;

    private String taskName;

    private Integer targetNum;

    private Integer finishNum;

    private Integer waitingForNum;

    private Byte linkState;

    private Integer errorNum;

    private String country;

    private String affiliateAccount;

    private String landingPageLink;

    private Date createTime;

    private Integer overdueTime;

    private Integer playTimeMin;

    private Integer playTimeMax;

    private Integer specialTimeMin;

    private Integer specialTimeMax;

    private Integer specialPercent;

    private Integer linkWaitTime;

    private Integer appWaitTime;

    private Byte status;

    private String retainedPercent;

    private Integer retainKeepDays;

    private Byte isChangeIdfa;

    private String timeline;

    private String timelinedtl;

    private Double crMin;

    private Double crMax;

    private Double crValue;

    private Byte type;

    private Byte downloadType;

    private Integer clickNum;

    private String newPhonePercent;

    private Date changeTime;

    private Integer taskConfigurationId;

    private Byte isRunClick;

    private Byte isUnlockClick;

    private Byte generateRetainedType;

    private Byte taskModel;

    private Byte modelRank;

    private Integer todayLevelMin;

    private Integer todayLevelMax;

    private Double todayLevelPercent;

    private Integer morrowLevelMin;

    private Integer morrowLevelMax;

    private Double morrowLevelPercent;

    private Integer everydayLevelMin;

    private Integer everydayLevelMax;

    private Double everydayLevelPercent;

    private Integer userId;

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

    public Integer getTargetNum() {
        return targetNum;
    }

    public void setTargetNum(Integer targetNum) {
        this.targetNum = targetNum;
    }

    public Integer getFinishNum() {
        return finishNum;
    }

    public void setFinishNum(Integer finishNum) {
        this.finishNum = finishNum;
    }

    public Integer getWaitingForNum() {
        return waitingForNum;
    }

    public void setWaitingForNum(Integer waitingForNum) {
        this.waitingForNum = waitingForNum;
    }

    public Byte getLinkState() {
        return linkState;
    }

    public void setLinkState(Byte linkState) {
        this.linkState = linkState;
    }

    public Integer getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(Integer errorNum) {
        this.errorNum = errorNum;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOverdueTime() {
        return overdueTime;
    }

    public void setOverdueTime(Integer overdueTime) {
        this.overdueTime = overdueTime;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public Double getCrMin() {
        return crMin;
    }

    public void setCrMin(Double crMin) {
        this.crMin = crMin;
    }

    public Double getCrMax() {
        return crMax;
    }

    public void setCrMax(Double crMax) {
        this.crMax = crMax;
    }

    public Double getCrValue() {
        return crValue;
    }

    public void setCrValue(Double crValue) {
        this.crValue = crValue;
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

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public Integer getTaskConfigurationId() {
        return taskConfigurationId;
    }

    public void setTaskConfigurationId(Integer taskConfigurationId) {
        this.taskConfigurationId = taskConfigurationId;
    }

    public Byte getIsRunClick() {
        return isRunClick;
    }

    public void setIsRunClick(Byte isRunClick) {
        this.isRunClick = isRunClick;
    }

    public Byte getIsUnlockClick() {
        return isUnlockClick;
    }

    public void setIsUnlockClick(Byte isUnlockClick) {
        this.isUnlockClick = isUnlockClick;
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

    public Byte getModelRank() {
        return modelRank;
    }

    public void setModelRank(Byte modelRank) {
        this.modelRank = modelRank;
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

    public Integer getMorrowLevelMin() {
        return morrowLevelMin;
    }

    public void setMorrowLevelMin(Integer morrowLevelMin) {
        this.morrowLevelMin = morrowLevelMin;
    }

    public Integer getMorrowLevelMax() {
        return morrowLevelMax;
    }

    public void setMorrowLevelMax(Integer morrowLevelMax) {
        this.morrowLevelMax = morrowLevelMax;
    }

    public Double getMorrowLevelPercent() {
        return morrowLevelPercent;
    }

    public void setMorrowLevelPercent(Double morrowLevelPercent) {
        this.morrowLevelPercent = morrowLevelPercent;
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

    public Double getEverydayLevelPercent() {
        return everydayLevelPercent;
    }

    public void setEverydayLevelPercent(Double everydayLevelPercent) {
        this.everydayLevelPercent = everydayLevelPercent;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSpecialPercent() {
        return specialPercent;
    }

    public void setSpecialPercent(Integer specialPercent) {
        this.specialPercent = specialPercent;
    }

    public String getNewPhonePercent() {
        return newPhonePercent;
    }

    public void setNewPhonePercent(String newPhonePercent) {
        this.newPhonePercent = newPhonePercent;
    }


}