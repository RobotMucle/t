package com.xtzn.mapper.entity;

import java.io.Serializable;
import java.util.Date;

public class IggList implements Serializable {

    private static final long serialVersionUID = 3179963790401162245L;

    private Integer id;

    private String iggCode;

    private String phoneCode;

    private Date usedTime;

    private String reason;

    private Byte status;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIggCode() {
        return iggCode;
    }

    public void setIggCode(String iggCode) {
        this.iggCode = iggCode;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Date getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Date usedTime) {
        this.usedTime = usedTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


}