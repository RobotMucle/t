package com.xtzn.business.impl;

import com.xtzn.business.ITimelineProgramBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.common.Constant;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.TimelineProgram;
import com.xtzn.service.ITimelineProgramService;
import com.xtzn.vo.CSRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月10日]
 */
@Component("timelineProgramBusiness")
public class TimelineProgramBusinessImpl implements ITimelineProgramBusiness {

    @Autowired
    private ITimelineProgramService timelineProgramService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    @Override
    public CSResponse retrieveTimelineProgramByPage(CSRequest csRequest) {
        Integer pageSize = Constant.pageSize;
        Integer skips = (csRequest.getPageIndex() - 1) * pageSize;
        List<TimelineProgram> list = timelineProgramService.selectTimelineProgramByPageIndex(csRequest.getUserId(), skips, pageSize);
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = timelineProgramService.selectCount(csRequest.getUserId());
            map.put("data", list);
            map.put("count", count);
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) map);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    @Override
    public CSResponse retrieveSingleTimelineProgram(Integer id) {
        TimelineProgram timelineProgram = timelineProgramService.selectTimelineProgramById(id);
        if (null != timelineProgram) {
            String program = timelineProgram.getProgram();
            String[] programs = program.split(",");
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", timelineProgram.getId());
            map.put("programName", timelineProgram.getProgramName());
            map.put("program", programs);
            map.put("status", timelineProgram.getStatus());
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) map);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    @Override
    public CSResponse updateTimelineProgram(TimelineProgram timelineProgram) {
        int i = timelineProgramService.updateTimelineProgramContent(timelineProgram);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    @Override
    public CSResponse updateTimelineProgramByStatus(Byte status, Integer id) {
        int i = timelineProgramService.updateTimelineProgramStatus(status, id);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    @Override
    public CSResponse deleteSingleTimelineProgram(Integer id) {
        int i = timelineProgramService.deleteById(id);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    @Override
    public CSResponse deleteBatchTimelineProgram(List<Integer> list) {
        int i = timelineProgramService.deleteBatchById(list);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    @Override
    public CSResponse createTimelineProgram(TimelineProgram timelineProgram) {
        int i = timelineProgramService.insertTimelineProgram(timelineProgram);
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月13日]
     */
    @Override
    public CSResponse retrieveUsingTimelineProgram(TimelineProgram timelineProgram) {
        List<TimelineProgram> list = timelineProgramService.selectUsingTimelineProgram(timelineProgram.getUserId());
        if (!list.isEmpty()) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) list);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

}
