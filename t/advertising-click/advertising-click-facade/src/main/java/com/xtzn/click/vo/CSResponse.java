package com.xtzn.click.vo;

import com.xtzn.click.enums.ResponseEnum;

import java.io.Serializable;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年3月24日]
 */
public class CSResponse implements Serializable {

    private static final long serialVersionUID = 1781180163769527202L;


    private String code;

    private String desc;

    private Serializable content;


    public CSResponse(String code, String desc, Serializable content) {
        super();
        this.code = code;
        this.desc = desc;
        this.content = content;
    }


    public CSResponse(String code, String desc) {
        super();
        this.code = code;
        this.desc = desc;
    }


    public CSResponse(Serializable content) {
        super();
        this.code = ResponseEnum.SUCCESS.getCode();
        this.desc = ResponseEnum.SUCCESS.getDesc();
        this.content = content;
    }


    public CSResponse() {
        super();
        this.code = ResponseEnum.SUCCESS.getCode();
        this.desc = ResponseEnum.SUCCESS.getDesc();

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

    public Serializable getContent() {
        return content;
    }

    public void setContent(Serializable content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "CSResponse [code=" + code + ", desc=" + desc + ", content=" + content + "]";
    }


}
