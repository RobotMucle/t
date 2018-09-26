package com.xtzn.mapper;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年6月26日]
 */

import com.xtzn.mapper.entity.Notice;

public interface INoticeMapper {

    public Notice selectLatestNotice();

    public int insertNotice(Notice notice);
}
