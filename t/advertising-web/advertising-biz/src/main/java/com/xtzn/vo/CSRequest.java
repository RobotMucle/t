package com.xtzn.vo;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月17日]
 */
public class CSRequest {

    private Integer userId;

    private Integer pageIndex;

    private Byte isAdmin;

    private String iggCodes;

    private String phoneCodes;

    private String phoneCode;

    private String ids;

    private Byte type;

    private Integer taskId;

    private Byte uploadType;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getIggCodes() {
        return iggCodes;
    }

    public void setIggCodes(String iggCodes) {
        this.iggCodes = iggCodes;
    }

    public String getPhoneCodes() {
        return phoneCodes;
    }

    public void setPhoneCodes(String phoneCodes) {
        this.phoneCodes = phoneCodes;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Byte getUploadType() {
        return uploadType;
    }

    public void setUploadType(Byte uploadType) {
        this.uploadType = uploadType;
    }


}
