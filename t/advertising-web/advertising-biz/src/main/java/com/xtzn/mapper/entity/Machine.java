package com.xtzn.mapper.entity;

import java.io.Serializable;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年7月10日]
 */
public class Machine implements Serializable {

    private static final long serialVersionUID = -794899672932638828L;

    private Integer id;

    private String phoneCode;

    private String phoneUuid;

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

    public String getPhoneUuid() {
        return phoneUuid;
    }

    public void setPhoneUuid(String phoneUuid) {
        this.phoneUuid = phoneUuid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
