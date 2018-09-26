package com.xtzn.mapper.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 2878447241869467644L;

    private Integer id;

    private String userName;

    private String password;

    private String franchiseeName;

    private Byte status;

    private Byte isAdmin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFranchiseeName() {
        return franchiseeName;
    }

    public void setFranchiseeName(String franchiseeName) {
        this.franchiseeName = franchiseeName;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }


    public Byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", franchiseeName="
                + franchiseeName + ", status=" + status + ", isAdmin=" + isAdmin + "]";
    }

}