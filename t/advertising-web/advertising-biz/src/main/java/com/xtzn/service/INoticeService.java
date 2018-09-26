package com.xtzn.service;

import com.xtzn.mapper.entity.Notice;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年6月26日]
 */
public interface INoticeService {

    public Notice selectLatestNotice();

    public int insertNotice(Notice notice);
}
