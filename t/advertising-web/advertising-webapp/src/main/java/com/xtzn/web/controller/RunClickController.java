package com.xtzn.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtzn.click.enums.ResponseEnum;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.proxy.RunClickBusinessProxy;
import com.xtzn.vo.CSRequest;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年3月24日]
 */
@Controller
@RequestMapping("/api")
public class RunClickController {


    @Autowired
    private RunClickBusinessProxy runClickBusinessProxy;


    /**
     * 功能描述: <br>
     * lua请求跑点击接口
     *
     * @author zyw
     * @version [版本号, 2018年3月30日]
     */
    @RequestMapping("/runClick")
    @ResponseBody
    public CSResponse runClick(CSRequest csRequest) {
        Integer taskId = csRequest.getTaskId();
        Integer userId = csRequest.getUserId();
        if (null == taskId || userId == null) {
            return new CSResponse(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getDesc());
        }
        return runClickBusinessProxy.runClick(taskId, userId);
    }

}
