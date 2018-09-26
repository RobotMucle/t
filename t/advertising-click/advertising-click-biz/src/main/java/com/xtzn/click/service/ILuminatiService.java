package com.xtzn.click.service;

import com.xtzn.click.mapper.entity.Luminati;

public interface ILuminatiService {

    /**
     * 功能描述: <br>
     * 获取luminati账号信息
     *
     * @author zyw
     * @version [版本号, 2018年3月19日]
     */
    public Luminati selectByStatus(Integer userId);
}
