package com.xtzn.service;

import com.xtzn.mapper.entity.TimelineProgram;

import java.util.List;

/**
 * 功能描述: <br>
 * 时间轴信息curd
 *
 * @author zyw
 * @version [版本号, 2018年4月10日]
 */
public interface ITimelineProgramService {

    /**
     * 功能描述: <br>
     * 根据页码获取时间轴信息
     *
     * @param pageSize 页面大小
     * @param skips    从哪条数据开始
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public List<TimelineProgram> selectTimelineProgramByPageIndex(Integer userId, Integer skips, Integer pageSize);

    /**
     * 功能描述: <br>
     * 查看单个时间轴信息
     *
     * @param id 时间轴id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public TimelineProgram selectTimelineProgramById(Integer id);

    /**
     * 功能描述: <br>
     * 更新时间轴信息
     *
     * @param map 时间轴相关信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateTimelineProgramContent(TimelineProgram timelineProgram);

    /**
     * 功能描述: <br>
     * 更新时间轴状态
     *
     * @param status 时间轴状态
     * @param id     国家id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateTimelineProgramStatus(Byte status, Integer id);

    /**
     * 功能描述: <br>
     * 删除单个时间轴信息
     *
     * @param id 要删除的时间轴id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteById(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除时间轴信息
     *
     * @param list 要删除的时间轴id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteBatchById(List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的时间轴信息
     *
     * @param map 时间轴相关信息
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public int insertTimelineProgram(TimelineProgram timelineProgram);

    /**
     * 功能描述: <br>
     * 查询在使用中的时间轴方案
     *
     * @author zyw
     * @version [版本号, 2018年4月13日]
     */
    public List<TimelineProgram> selectUsingTimelineProgram(Integer userId);

    public Integer selectCount(Integer userId);
}
