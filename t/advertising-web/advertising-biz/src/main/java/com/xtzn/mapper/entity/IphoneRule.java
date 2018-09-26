package com.xtzn.mapper.entity;

import java.io.Serializable;

/**
 * 功能描述: <br>
 * ftp地址及规则
 *
 * @author zyw
 * @version [版本号, 2018年4月11日]
 */
public class IphoneRule implements Serializable {

    private static final long serialVersionUID = -6304732014760133014L;

    private Integer id;

    private String name;
    /**
     * ftp地址
     */
    private String address;
    /**
     * ftp规则地址
     */
    private String url;

    private Byte type;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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
