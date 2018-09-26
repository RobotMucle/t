package com.xtzn.mapper.entity;

import java.io.Serializable;

public class TaskConfiguration implements Serializable {

    private static final long serialVersionUID = -6981247693941446771L;

    private Integer id;

    private String configurationName;

    private String scriptName;

    private String bundleName;

    private Integer appleAccountId;

    private String thirdPartyName;

    private String itunesId;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getAppleAccountId() {
        return appleAccountId;
    }

    public void setAppleAccountId(Integer appleAccountId) {
        this.appleAccountId = appleAccountId;
    }

    public String getThirdPartyName() {
        return thirdPartyName;
    }

    public void setThirdPartyName(String thirdPartyName) {
        this.thirdPartyName = thirdPartyName;
    }

    public String getItunesId() {
        return itunesId;
    }

    public void setItunesId(String itunesId) {
        this.itunesId = itunesId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}