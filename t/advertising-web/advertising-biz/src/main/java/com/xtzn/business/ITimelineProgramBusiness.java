package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.TimelineProgram;
import com.xtzn.vo.CSRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * 时间轴信息业务
 *
 * @author zyw
 * @version [版本号, 2018年4月10日]
 */
public interface ITimelineProgramBusiness {

    /**
     * 功能描述: <br>
     * 根据页码获取时间轴信息
     *
     * @param pageIndex 页码
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveTimelineProgramByPage(CSRequest csRequest);

    /**
     * 功能描述: <br>
     * 查看单个时间轴信息
     *
     * @param id 时间轴id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveSingleTimelineProgram(Integer id);

    /**
     * 功能描述: <br>
     * 更新时间轴信息
     *
     * @param map 时间轴相关信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateTimelineProgram(TimelineProgram timelineProgram);

    /**
     * 功能描述: <br>
     * 更新时间轴状态
     *
     * @param status 时间轴状态
     * @param id     时间轴id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateTimelineProgramByStatus(Byte status, Integer id);

    /**
     * 功能描述: <br>
     * 删除单个时间轴信息
     *
     * @param id 要删除的时间轴id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteSingleTimelineProgram(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除时间轴信息
     *
     * @param list 要删除的时间轴id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteBatchTimelineProgram(List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的时间轴信息
     *
     * @param map 时间轴相关信息
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public CSResponse createTimelineProgram(TimelineProgram timelineProgram);

    /**
     * 功能描述: <br>
     * 查询在使用中的时间轴方案
     *
     * @author zyw
     * @version [版本号, 2018年4月13日]
     */
    public CSResponse retrieveUsingTimelineProgram(TimelineProgram timelineProgram);
}
