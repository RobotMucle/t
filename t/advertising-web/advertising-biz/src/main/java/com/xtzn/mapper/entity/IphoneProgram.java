package com.xtzn.mapper.entity;

import java.io.Serializable;

public class IphoneProgram implements Serializable {

    private static final long serialVersionUID = 8403856643113466809L;

    private Integer id;

    private String name;

    private Integer downloadMinNumber;

    private Integer downloadMaxNumber;

    private Integer retainedMinNumber;

    private Integer retainedMaxNumber;

    private Integer registerMinNumber;

    private Integer registerMaxNumber;

    private Integer accountMinNumber;

    private Integer accountMaxNumber;

    private Integer testMinNumber;

    private Integer testMaxNumber;

    private Byte status;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDownloadMinNumber() {
        return downloadMinNumber;
    }

    public void setDownloadMinNumber(Integer downloadMinNumber) {
        this.downloadMinNumber = downloadMinNumber;
    }

    public Integer getDownloadMaxNumber() {
        return downloadMaxNumber;
    }

    public void setDownloadMaxNumber(Integer downloadMaxNumber) {
        this.downloadMaxNumber = downloadMaxNumber;
    }

    public Integer getRetainedMinNumber() {
        return retainedMinNumber;
    }

    public void setRetainedMinNumber(Integer retainedMinNumber) {
        this.retainedMinNumber = retainedMinNumber;
    }

    public Integer getRetainedMaxNumber() {
        return retainedMaxNumber;
    }

    public void setRetainedMaxNumber(Integer retainedMaxNumber) {
        this.retainedMaxNumber = retainedMaxNumber;
    }

    public Integer getRegisterMinNumber() {
        return registerMinNumber;
    }

    public void setRegisterMinNumber(Integer registerMinNumber) {
        this.registerMinNumber = registerMinNumber;
    }

    public Integer getRegisterMaxNumber() {
        return registerMaxNumber;
    }

    public void setRegisterMaxNumber(Integer registerMaxNumber) {
        this.registerMaxNumber = registerMaxNumber;
    }

    public Integer getAccountMinNumber() {
        return accountMinNumber;
    }

    public void setAccountMinNumber(Integer accountMinNumber) {
        this.accountMinNumber = accountMinNumber;
    }

    public Integer getAccountMaxNumber() {
        return accountMaxNumber;
    }

    public void setAccountMaxNumber(Integer accountMaxNumber) {
        this.accountMaxNumber = accountMaxNumber;
    }

    public Integer getTestMinNumber() {
        return testMinNumber;
    }

    public void setTestMinNumber(Integer testMinNumber) {
        this.testMinNumber = testMinNumber;
    }

    public Integer getTestMaxNumber() {
        return testMaxNumber;
    }

    public void setTestMaxNumber(Integer testMaxNumber) {
        this.testMaxNumber = testMaxNumber;
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


}