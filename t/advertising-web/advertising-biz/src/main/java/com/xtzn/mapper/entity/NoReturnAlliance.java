package com.xtzn.mapper.entity;

import java.io.Serializable;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月23日]
 */
public class NoReturnAlliance implements Serializable {

    private static final long serialVersionUID = -8377578471102460997L;

    private Integer id;

    private String affiliateAccountName;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
