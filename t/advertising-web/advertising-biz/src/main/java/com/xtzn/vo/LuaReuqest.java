package com.xtzn.vo;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月27日]
 */

import java.util.Date;
import java.util.List;

public class LuaReuqest {

    private Integer userId;

    private String idfaCode;

    private String affiliateAccount;

    private String country;

    private String thirdParty;

    private String bundleName;

    private Byte status;

    private Byte type;

    private String typeName;

    private String userName;

    private String userPwd;

    private List<String> thirdPartyList;

    private Integer iggId;

    private Byte isSuccess;

    private String phoneCode;

    private Date overdueTime;

    private String fileName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public List<String> getThirdPartyList() {
        return thirdPartyList;
    }

    public void setThirdPartyList(List<String> thirdPartyList) {
        this.thirdPartyList = thirdPartyList;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public Integer getIggId() {
        return iggId;
    }

    public void setIggId(Integer iggId) {
        this.iggId = iggId;
    }

    public Byte getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Byte isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Date getOverdueTime() {
        return overdueTime;
    }

    public void setOverdueTime(Date overdueTime) {
        this.overdueTime = overdueTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


}
