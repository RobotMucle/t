package com.xtzn.click.service;

public interface ISubService {

    /**
     * 功能描述: <br>
     * 插入新的subId
     *
     * @param subId
     * @author zyw
     * @version [版本号, 2018年3月19日]
     */
    public int insertSub(String subId);

    /**
     * 功能描述: <br>
     * 查询是否有相同的subid
     *
     * @param subId
     * @author zyw
     * @version [版本号, 2018年3月19日]
     */
    public String selectSubId(String subId);

    /**
     * 功能描述: <br>
     * 获得一个新的subId
     *
     * @author zyw
     * @version [版本号, 2018年3月19日]
     */
    public String getSubId();
}
