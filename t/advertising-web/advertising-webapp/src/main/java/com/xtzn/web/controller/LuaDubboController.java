package com.xtzn.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtzn.common.Constant;
import com.xtzn.core.vo.CSResponse;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.proxy.RetainedBusinessProxy;
import com.xtzn.proxy.TaskBusinessProxy;
import com.xtzn.vo.CSRequest;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月29日]
 */
@Controller
@RequestMapping("/luaDubbo")
public class LuaDubboController {

    @Autowired
    private RetainedBusinessProxy retainedBusinessProxy;

    @Autowired
    private TaskBusinessProxy taskBusinessProxy;

    @RequestMapping(value = "/distributeTask", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse distributeTask(CSRequest csRequest) {
        if (csRequest.getPhoneCode() == null || "".equals(csRequest.getPhoneCode()) || csRequest.getType() == null || csRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return taskBusinessProxy.requestTaskData(csRequest.getPhoneCode(), csRequest.getType(), csRequest.getUserId());
    }

    @RequestMapping(value = "/distributeRetained", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse distributeRetained(CSRequest csRequest) {
        if (csRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        if (csRequest.getUploadType() == null) {
            csRequest.setUploadType(Constant.status_0);
        }
        return retainedBusinessProxy.requestRetainedData(csRequest.getUserId(), csRequest.getUploadType());
    }
}
