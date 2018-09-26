package com.xtzn.service.impl;

import com.xtzn.mapper.ITimelineProgramMapper;
import com.xtzn.mapper.entity.TimelineProgram;
import com.xtzn.service.ITimelineProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月12日]
 */
@Service
public class TimelineProgramServiceImpl implements ITimelineProgramService {

    @Autowired
    private ITimelineProgramMapper timelineProgramDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public List<TimelineProgram> selectTimelineProgramByPageIndex(Integer userId, Integer skips, Integer pageSize) {

        return timelineProgramDao.selectTimelineProgramByPageIndex(userId, skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public TimelineProgram selectTimelineProgramById(Integer id) {

        return timelineProgramDao.selectTimelineProgramById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateTimelineProgramContent(TimelineProgram timelineProgram) {

        return timelineProgramDao.updateTimelineProgramContent(timelineProgram);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateTimelineProgramStatus(Byte status, Integer id) {

        return timelineProgramDao.updateTimelineProgramStatus(status, id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int deleteById(Integer id) {

        return timelineProgramDao.deleteById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int deleteBatchById(List<Integer> list) {

        return timelineProgramDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int insertTimelineProgram(TimelineProgram timelineProgram) {

        return timelineProgramDao.insertTimelineProgram(timelineProgram);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月13日]
     */
    @Override
    public List<TimelineProgram> selectUsingTimelineProgram(Integer userId) {

        return timelineProgramDao.selectUsingTimelineProgram(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public Integer selectCount(Integer userId) {

        return timelineProgramDao.selectCount(userId);
    }

}
