package com.xtzn.business;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年6月26日]
 */

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.Notice;

public interface INoticeBusiness {

    public CSResponse selectLatestNotice();

    public CSResponse createNotice(Notice notice);
}
