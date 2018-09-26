package com.xtzn.mapper.entity;

import java.io.Serializable;

public class Alliance implements Serializable {

    private static final long serialVersionUID = -7404634222202480109L;

    private Integer id;

    private String affiliateAccountName;

    private String affiliateAccountLogo;

    private Byte status;

    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAffiliateAccountName() {
        return affiliateAccountName;
    }

    public void setAffiliateAccountName(String affiliateAccountName) {
        this.affiliateAccountName = affiliateAccountName;
    }

    public String getAffiliateAccountLogo() {
        return affiliateAccountLogo;
    }

    public void setAffiliateAccountLogo(String affiliateAccountLogo) {
        this.affiliateAccountLogo = affiliateAccountLogo;
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