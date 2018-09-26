package com.xtzn.mapper.entity;

import java.io.Serializable;
import java.util.Date;

public class AccountInfo implements Serializable {

    private static final long serialVersionUID = 3442365698007814341L;

    private Integer id;

    private String userName;

    private String userPwd;

    private Integer type;

    private Date addTime;

    private Date usedTime;

    private Integer usedCnt;

    private Byte status;

    private Integer userId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Date usedTime) {
        this.usedTime = usedTime;
    }

    public Integer getUsedCnt() {
        return usedCnt;
    }

    public void setUsedCnt(Integer usedCnt) {
        this.usedCnt = usedCnt;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}