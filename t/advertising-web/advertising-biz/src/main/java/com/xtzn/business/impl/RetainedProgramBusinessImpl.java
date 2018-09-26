package com.xtzn.business.impl;

import com.xtzn.business.IRetainedProgramBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.common.Constant;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.RetainedProgram;
import com.xtzn.service.IRetainedProgramService;
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
@Component("retainedProgramBusiness")
public class RetainedProgramBusinessImpl implements IRetainedProgramBusiness {

    @Autowired
    private IRetainedProgramService retainedProgramService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    @Override
    public CSResponse retrieveRetainedProgramByPage(CSRequest csRequest) {
        Integer pageSize = Constant.pageSize;
        Integer skips = (csRequest.getPageIndex() - 1) * pageSize;
        List<RetainedProgram> list = retainedProgramService.selectRetainedProgramByPageIndex(csRequest.getUserId(), skips, pageSize);
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = retainedProgramService.selectCount(csRequest.getUserId());
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
    public CSResponse retrieveSingleRetainedProgram(Integer id) {
        RetainedProgram retainedProgram = retainedProgramService.selectRetainedProgramById(id);
        if (null != retainedProgram) {
            String program = retainedProgram.getProgram();
            String[] programs = program.split(",");
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", retainedProgram.getId());
            map.put("programName", retainedProgram.getProgramName());
            map.put("program", programs);
            map.put("status", retainedProgram.getStatus());
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
    public CSResponse updateRetainedProgram(RetainedProgram retainedProgram) {
        int i = retainedProgramService.updateRetainedProgramContent(retainedProgram);
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
    public CSResponse updateRetainedProgramByStatus(Byte status, Integer id) {
        int i = retainedProgramService.updateRetainedProgramStatus(status, id);
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
    public CSResponse deleteSingleRetainedProgram(Integer id) {
        int i = retainedProgramService.deleteById(id);
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
    public CSResponse deleteBatchRetainedProgram(List<Integer> list) {
        int i = retainedProgramService.deleteBatchById(list);
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
    public CSResponse createRetainedProgram(RetainedProgram retainedProgram) {
        int i = retainedProgramService.insertRetainedProgram(retainedProgram);
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
    public CSResponse retrieveUsingRetainedProgram(RetainedProgram retainedProgram) {
        List<RetainedProgram> list = retainedProgramService.selectUsingRetainedProgram(retainedProgram.getUserId());
        if (!list.isEmpty()) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) list);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

}
