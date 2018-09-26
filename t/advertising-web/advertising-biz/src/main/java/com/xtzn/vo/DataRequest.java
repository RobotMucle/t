package com.xtzn.vo;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月23日]
 */

import java.util.Date;

public class DataRequest {

    private Integer typeId;

    private Byte status;

    private String fileName;

    private Byte isSuccess;

    private Date startTime;

    private Date endTime;

    private Integer userId;

    private String dateRange;

    private Integer pageIndex;

    private Integer skips;

    private Integer pageSize;

    private Integer usedCnt;

    private String country;

    private String taskName;

    private String thirdParty;

    private String userName;


    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Byte getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Byte isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
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

    public Integer getUsedCnt() {
        return usedCnt;
    }

    public void setUsedCnt(Integer usedCnt) {
        this.usedCnt = usedCnt;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(String thirdParty) {
        this.thirdParty = thirdParty;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
