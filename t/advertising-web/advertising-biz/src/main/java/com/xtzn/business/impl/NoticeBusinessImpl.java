package com.xtzn.business.impl;

import com.xtzn.business.INoticeBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.Notice;
import com.xtzn.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年6月26日]
 */
@Component
public class NoticeBusinessImpl implements INoticeBusiness {

    @Autowired
    private INoticeService noticeService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月26日]
     */
    @Override
    public CSResponse selectLatestNotice() {
        Notice notice = noticeService.selectLatestNotice();
        if (null == notice) {
            return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
        }
        return new CSResponse(notice);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月26日]
     */
    @Override
    public CSResponse createNotice(Notice notice) {
        int i = noticeService.insertNotice(notice);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }


}
