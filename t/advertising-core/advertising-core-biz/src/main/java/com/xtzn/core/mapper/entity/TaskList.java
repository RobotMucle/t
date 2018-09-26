package com.xtzn.core.mapper.entity;

import java.io.Serializable;
import java.util.Date;

public class TaskList implements Serializable {

    private static final long serialVersionUID = -8220662917509694680L;

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

    private Date startTime;

    private Date updateTime;

    private Integer playTimeMin;

    private Integer playTimeMax;

    private Integer linkWaitTime;

    private Integer appWaitTime;

    private Byte status;

    private String retainedPercent;

    private Integer retainKeepDays;

    private Byte isChangeIdfa;

    private String timeline;

    private String timelinedtl;

    private Float crMin;

    private Float crMax;

    private Float crValue;

    private Byte type;

    private Byte downloadType;

    private Integer clickNum;

    private String newPhonePercent;

    private Date changeTime;

    private Integer taskConfigurationId;

    private Byte isRunClick;

    private Byte isUnlockClick;

    private Byte generateRetainedType;

    private Integer dotayLevelMin;

    private Integer dotayLevelMax;

    private Double dotayLevelPercent;

    private Integer morrowLevelMin;

    private Integer morrowLevelMax;

    private Double morrowLevelPercent;

    private Integer everydayLevelMin;

    private Integer everydayLevelMax;

    private Double everydayLevelPercent;

    private Byte taskModel;

    private Byte modelRank;

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
        this.country = country == null ? null : country.trim();
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        this.timeline = timeline == null ? null : timeline.trim();
    }

    public String getTimelinedtl() {
        return timelinedtl;
    }

    public void setTimelinedtl(String timelinedtl) {
        this.timelinedtl = timelinedtl;
    }

    public Float getCrMin() {
        return crMin;
    }

    public void setCrMin(Float crMin) {
        this.crMin = crMin;
    }

    public Float getCrMax() {
        return crMax;
    }

    public void setCrMax(Float crMax) {
        this.crMax = crMax;
    }

    public Float getCrValue() {
        return crValue;
    }

    public void setCrValue(Float crValue) {
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


    public String getNewPhonePercent() {
        return newPhonePercent;
    }

    public void setNewPhonePercent(String newPhonePercent) {
        this.newPhonePercent = newPhonePercent;
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

    public Integer getDotayLevelMin() {
        return dotayLevelMin;
    }

    public void setDotayLevelMin(Integer dotayLevelMin) {
        this.dotayLevelMin = dotayLevelMin;
    }

    public Integer getDotayLevelMax() {
        return dotayLevelMax;
    }

    public void setDotayLevelMax(Integer dotayLevelMax) {
        this.dotayLevelMax = dotayLevelMax;
    }

    public Double getDotayLevelPercent() {
        return dotayLevelPercent;
    }

    public void setDotayLevelPercent(Double dotayLevelPercent) {
        this.dotayLevelPercent = dotayLevelPercent;
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

}