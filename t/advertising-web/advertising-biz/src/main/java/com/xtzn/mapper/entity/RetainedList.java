package com.xtzn.mapper.entity;

import java.io.Serializable;
import java.util.Date;

public class RetainedList implements Serializable {

    private static final long serialVersionUID = -496920062162250861L;

    private Integer id;

    private String uploadPath;

    private Integer keepDays;

    private Date uploadTime;

    private String phoneCode;

    private Byte secondLoginSign;

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

    private Integer levelCount;

    private String accountUser;

    private String accountPwd;

    private Integer userId;

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


    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Byte getSecondLoginSign() {
        return secondLoginSign;
    }

    public void setSecondLoginSign(Byte secondLoginSign) {
        this.secondLoginSign = secondLoginSign;
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


    public Integer getLevelCount() {
        return levelCount;
    }

    public void setLevelCount(Integer levelCount) {
        this.levelCount = levelCount;
    }

    public String getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(String accountUser) {
        this.accountUser = accountUser;
    }

    public String getAccountPwd() {
        return accountPwd;
    }

    public void setAccountPwd(String accountPwd) {
        this.accountPwd = accountPwd;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}