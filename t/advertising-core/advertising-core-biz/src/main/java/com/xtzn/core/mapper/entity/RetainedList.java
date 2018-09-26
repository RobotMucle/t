package com.xtzn.core.mapper.entity;

import java.io.Serializable;
import java.util.Date;

public class RetainedList implements Serializable {

    private static final long serialVersionUID = 2082069628395674779L;

    private Integer id;

    private String uploadPath;

    private Integer keepDays;

    private Date uploadTime;

    private Integer phoneGroup;

    private String phoneNumber;

    private Byte remainNum;

    private String retainedPercent;

    private Integer taskId;

    private String ipAddress;

    private Integer usedCnt;

    private Byte isDoSign;

    private String subId;

    private Byte isSuccess;

    private Byte isNewPhone;

    private Byte longTimeSign;

    private Byte levelType;

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

    public Integer getKeepDays() {
        return keepDays;
    }

    public void setKeepDays(Integer keepDays) {
        this.keepDays = keepDays;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getPhoneGroup() {
        return phoneGroup;
    }

    public void setPhoneGroup(Integer phoneGroup) {
        this.phoneGroup = phoneGroup;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Byte getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(Byte remainNum) {
        this.remainNum = remainNum;
    }

    public String getRetainedPercent() {
        return retainedPercent;
    }

    public void setRetainedPercent(String retainedPercent) {
        this.retainedPercent = retainedPercent;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getUsedCnt() {
        return usedCnt;
    }

    public void setUsedCnt(Integer usedCnt) {
        this.usedCnt = usedCnt;
    }

    public Byte getIsDoSign() {
        return isDoSign;
    }

    public void setIsDoSign(Byte isDoSign) {
        this.isDoSign = isDoSign;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public Byte getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Byte isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Byte getIsNewPhone() {
        return isNewPhone;
    }

    public void setIsNewPhone(Byte isNewPhone) {
        this.isNewPhone = isNewPhone;
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

}