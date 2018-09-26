package com.xtzn.vo;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月24日]
 */
public class PortRequest {

    private String serverAddress;

    private String serverPort;

    private Integer portStart;

    private Integer portEnd;

    private String groupName;

    private String groupPassword;

    private Integer userId;

    private String newServerAddress;

    private String oldServerAddress;

    private Integer pageIndex;

    private Integer skips;

    private Integer pageSize;

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


    public Integer getPortStart() {
        return portStart;
    }

    public void setPortStart(Integer portStart) {
        this.portStart = portStart;
    }

    public Integer getPortEnd() {
        return portEnd;
    }

    public void setPortEnd(Integer portEnd) {
        this.portEnd = portEnd;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNewServerAddress() {
        return newServerAddress;
    }

    public void setNewServerAddress(String newServerAddress) {
        this.newServerAddress = newServerAddress;
    }

    public String getOldServerAddress() {
        return oldServerAddress;
    }

    public void setOldServerAddress(String oldServerAddress) {
        this.oldServerAddress = oldServerAddress;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getSkips() {
        return skips;
    }

    public void setSkips(Integer skips) {
        this.skips = skips;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


}
