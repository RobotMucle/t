package com.xtzn.mapper.entity;

import java.io.Serializable;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月19日]
 */
public class ThirdParty implements Serializable {

    private static final long serialVersionUID = -4178583741800158939L;

    private Integer id;

    private String name;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
