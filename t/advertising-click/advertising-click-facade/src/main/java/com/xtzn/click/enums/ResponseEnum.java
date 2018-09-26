package com.xtzn.click.enums;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年3月24日]
 */
public enum ResponseEnum {

    SUCCESS("0000", "成功"),

    SYSTEM_ERROR("9999", "系统异常"),

    ERROR("9998", "失败"),

    NET_EEROR("9997", "网络通信异常"),

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
