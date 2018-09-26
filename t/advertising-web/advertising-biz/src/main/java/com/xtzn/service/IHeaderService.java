package com.xtzn.service;

import com.xtzn.mapper.entity.Header;

import java.util.List;

public interface IHeaderService {

    /**
     * 功能描述: <br>
     * 获取一个userAgent
     *
     * @param id userAent id
     * @author zyw
     * @version [版本号, 2018年3月19日]
     */
    public List<Header> selectHeader();
}
