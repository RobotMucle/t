package com.xtzn.core.business.impl;

import com.xtzn.core.business.ITaskTransformCheckBusiness;
import com.xtzn.core.commom.Constant;
import com.xtzn.core.service.IIphoneRuleService;
import com.xtzn.core.service.ITaskListService;
import com.xtzn.core.service.ITaskListenningService;
import com.xtzn.core.service.IThirdPartyService;
import com.xtzn.core.utils.CurrentTimeUtil;
import com.xtzn.core.utils.ListUtil;
import com.xtzn.core.vo.CSResponse;
import com.xtzn.core.vo.TaskResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年6月11日]
 */
@Component
public class TaskTransformCheckBusinessImpl implements ITaskTransformCheckBusiness {

    @Autowired
    private ITaskListService taskListService;
    @Autowired
    private ITaskListenningService taskListenningService;
    @Autowired
    private IThirdPartyService thirdPartyService;
    @Autowired
    private IIphoneRuleService iphoneRuleService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月11日]
     */
    @Override
    public CSResponse requestTaskData(String phoneCode, Integer userId) {
        //查看该手机是否有在监控中的任务
        List<Map<String, Object>> listener = taskListenningService.selectTaskByPhoneCode(phoneCode);
        if (!listener.isEmpty() && listener != null) {
            taskListenningService.updateTaskByPhoneCode(phoneCode);
        }
        List<TaskResponse> taskList = taskListService.selectNormalTaskData(Constant.status_4, Constant.status_0, userId);
        if (!taskList.isEmpty() && null != taskList) {
            TaskResponse taskResponse = taskList.get((int) (Math.random() * taskList.size()));
            Integer id = taskResponse.getId();
            String landingPageLink = taskResponse.getLandingPageLink();
            String subid = UUID.randomUUID().toString();
            subid = subid.replaceAll("-", "");
            landingPageLink = landingPageLink.replace("[[subid]]", subid);
            taskResponse.setLandingPageLink(landingPageLink);
            taskResponse.setSubId(subid);
            ;
            taskResponse.setCurrentTime(CurrentTimeUtil.currentTime());
            List<Map<String, Object>> list = iphoneRuleService.selectUrl(userId);
            List<Map<String, Object>> addressList = new ArrayList<Map<String, Object>>();
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put((String) list.get(i).get("name"), list.get(i).get("url"));
                addressList.add(map);
            }
            taskResponse.setRuleAddress(addressList);
            taskListService.updateDistributeTaskWatingForNum(id);
            //retainedService.insertRetained(subid);
            taskListenningService.insertTaskListenning(id, phoneCode);
            //第三方名称的id转换成name
            if (!"".equals(taskResponse.getThirdPartyName()) && taskResponse.getThirdPartyName() != null) {
                List<Integer> tpnList = ListUtil.dataList(taskResponse.getThirdPartyName());
                List<String> curList = thirdPartyService.selectBatchNameById(tpnList);
                String curtpn = StringUtils.join(curList, ",");
                taskResponse.setThirdPartyName(curtpn);
            }
        }
        return null;
    }

}
