package com.xtzn.mapper.entity;

import java.io.Serializable;

public class PortList implements Serializable {

    private static final long serialVersionUID = -2781784838351627462L;

    private Integer id;

    private String serverAddress;

    private String serverPort;

    private String httpPort;

    private String port;

    private String groupName;

    private String groupPassword;

    private String phoneCode;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public String getHttpPort() {
        return httpPort;
    }

    public void setHttpPort(String httpPort) {
        this.httpPort = httpPort;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupPassword() {
        return groupPassword;
    }

    public void setGroupPassword(String groupPassword) {
        this.groupPassword = groupPassword;
    }


}