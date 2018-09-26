package com.xtzn.mapper.entity;

import java.io.Serializable;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月14日]
 */
public class IosSystemVersion implements Serializable {

    private static final long serialVersionUID = -8025696566513524456L;

    private Integer id;

    private String versionNumber;

    private String iosSystem;

    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getIosSystem() {
        return iosSystem;
    }

    public void setIosSystem(String iosSystem) {
        this.iosSystem = iosSystem;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
