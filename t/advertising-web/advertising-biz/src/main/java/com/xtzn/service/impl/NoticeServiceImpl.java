package com.xtzn.service.impl;

import com.xtzn.mapper.INoticeMapper;
import com.xtzn.mapper.entity.Notice;
import com.xtzn.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年6月26日]
 */
@Service
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    private INoticeMapper noticeDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月26日]
     */
    @Override
    public Notice selectLatestNotice() {

        return noticeDao.selectLatestNotice();
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月26日]
     */
    @Override
    public int insertNotice(Notice notice) {

        return noticeDao.insertNotice(notice);
    }

}
