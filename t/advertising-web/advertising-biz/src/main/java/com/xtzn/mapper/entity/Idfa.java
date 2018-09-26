package com.xtzn.mapper.entity;

import java.io.Serializable;
import java.util.Date;

public class Idfa implements Serializable {

    private static final long serialVersionUID = 1745480907809601848L;

    private Integer id;

    private String idfaCode;

    private String affiliateAccount;

    private String country;

    private String thirdParty;

    private String bundleName;

    private Date createTime;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdfaCode() {
        return idfaCode;
    }

    public void setIdfaCode(String idfaCode) {
        this.idfaCode = idfaCode;
    }

    public String getAffiliateAccount() {
        return affiliateAccount;
    }

    public void setAffiliateAccount(String affiliateAccount) {
        this.affiliateAccount = affiliateAccount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(String thirdParty) {
        this.thirdParty = thirdParty;
    }


    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}