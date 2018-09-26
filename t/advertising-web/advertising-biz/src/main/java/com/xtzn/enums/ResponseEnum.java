package com.xtzn.enums;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年3月24日]
 */
public enum ResponseEnum {

    SUCCESS("0000", "成功"),

    SUCCESS_留存("0001", "成功"),

    SYSTEM_ERROR("9999", "系统异常"),

    ERROR("9998", "失败"),

    NET_EEROR("9997", "网络通信异常"),

    TASK_EEROR("9996", "可接受任务为空"),

    DATA_ERROR("9995", "没有符合要求的数据"),

    RETAINED_EEROR("9994", "可接受留存任务为空"),

    SELECT_EEROR("9993", "查询数据为空"),

    RECEIVE_ERROR("9992", "数据异常,接收数据为空"),

    OVERDUE_ERROR_任务("9991", "任务过期"),

    OVERDUE_ERROR_留存("9990", "留存过期"),

    PORT_NONE_ERROR("9989", "端口用尽"),

    IDFA_NONE_ERROR("9988", "IDFA没有符合条件的"),

    IDFA_CREATE_ERROR("9987", "IDFA重复添加"),

    ACCOUNT_NONE_ERROR("9986", "账号没有符合条件的"),

    ACCOUNT_CREATE_ERROR("9985", "账号重复添加"),

    PERSON_NONE_ERROR("9984", "资料没有符合条件的"),

    IGG_NONE_ERROR("9983", "IGG用完"),

    APPLE_ACCOUNT_NONE_ERROR("9982", "苹果账号没有可用的"),

    UPLOAD_NONE_ERROR("9981", "包路径没有可用的"),

    UPLOAD_EXCEL_ERROR("9980", "上传excel类型错误"),

    TASK_STATUS_IS_ERROR("1001", "任务状态不正常"),

    TASK_NOT_RUN_CLICK("1002", "任务不需要跑点击"),

    PROXY_ERROR("1003", "代理错误"),

    TASK_RESET_ERROR("1004", "无重置任务");

    private String code;

    private String desc;

    private ResponseEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ;


}
