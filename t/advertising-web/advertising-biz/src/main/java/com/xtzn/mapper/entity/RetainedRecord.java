package com.xtzn.mapper.entity;

import java.io.Serializable;
import java.util.Date;

public class RetainedRecord implements Serializable {

    private static final long serialVersionUID = 3812631943409534414L;

    private Integer id;

    private String phoneCode;

    private Date createTime;

    private Date uploadTime;

    private Integer retainedKeepDays;

    private Byte isSuccess;

    private String reason;

    private Integer taskId;

    private String ipAddress;

    private Integer retainedId;

    private Integer retainedCnt;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getRetainedKeepDays() {
        return retainedKeepDays;
    }

    public void setRetainedKeepDays(Integer retainedKeepDays) {
        this.retainedKeepDays = retainedKeepDays;
    }

    public Byte getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Byte isSuccess) {
        this.isSuccess = isSuccess;
    }


    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public Integer getRetainedId() {
        return retainedId;
    }

    public void setRetainedId(Integer retainedId) {
        this.retainedId = retainedId;
    }


    public Integer getRetainedCnt() {
        return retainedCnt;
    }

    public void setRetainedCnt(Integer retainedCnt) {
        this.retainedCnt = retainedCnt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "RetainedRecord [id=" + id + ", phoneCode=" + phoneCode + ", createTime=" + createTime + ", uploadTime="
                + uploadTime + ", retainedKeepDays=" + retainedKeepDays + ", isSuccess=" + isSuccess + ", reason="
                + reason + ", taskId=" + taskId + ", ipAddress=" + ipAddress + ", retainedId=" + retainedId
                + ", retainedCnt=" + retainedCnt + ", userId=" + userId + "]";
    }

}