package com.xtzn.mapper.entity;

import java.io.Serializable;
import java.util.Date;

public class PhoneList implements Serializable {

    private static final long serialVersionUID = 7969851916556404604L;

    private Integer id;

    private String phoneCode;

    private Date duetime;

    private Byte status;

    private String reason;

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

    public Date getDuetime() {
        return duetime;
    }

    public void setDuetime(Date duetime) {
        this.duetime = duetime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}