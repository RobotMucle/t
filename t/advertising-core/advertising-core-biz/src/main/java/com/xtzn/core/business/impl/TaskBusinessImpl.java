package com.xtzn.core.business.impl;

import com.xtzn.core.business.ITaskBusiness;
import com.xtzn.core.commom.Constant;
import com.xtzn.core.enums.ResponseEnum;
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

import java.io.Serializable;
import java.util.*;

/**
 * 功能描述: <br>
 * 获得任务详细数据
 *
 * @author zyw
 * @version [版本号, 2018年3月27日]
 */
@Component("taskBusiness")
public class TaskBusinessImpl implements ITaskBusiness {

    @Autowired
    private ITaskListService taskListService;
    @Autowired
    private ITaskListenningService taskListenningService;
    @Autowired
    private IIphoneRuleService iphoneRuleService;
    @Autowired
    private IThirdPartyService thirdPartyService;

    /**
     * 功能描述: <br>
     * 提供lua任务数据接口
     *
     * @author zyw
     * @version [版本号, 2018年3月27日]
     */
    @Override
    public CSResponse requestTaskData(String phoneCode, Byte type, Integer userId) {
        //查看该手机是否有在监控中的任务
        List<Map<String, Object>> listener = taskListenningService.selectTaskByPhoneCode(phoneCode);
        if (!listener.isEmpty() && listener != null) {
            taskListenningService.updateTaskByPhoneCode(phoneCode);
        }
        //查看是否为账号注册任务
        if (type == 1) {
            List<TaskResponse> taskList = taskListService.selectNormalTaskData(Constant.status_1, type, userId);
            if (!taskList.isEmpty()) {
                //随机获取一个任务
                TaskResponse task = taskList.get((int) (Math.random() * taskList.size()));
                Integer id = task.getId();
                String landingPageLink = task.getLandingPageLink();
                String subid = UUID.randomUUID().toString();
                subid = subid.replaceAll("-", "");
                landingPageLink = landingPageLink.replace("[[subid]]", subid);
                task.setLandingPageLink(landingPageLink);
                task.setSubId(subid);
                ;
                task.setCurrentTime(CurrentTimeUtil.currentTime());
                List<Map<String, Object>> list = iphoneRuleService.selectUrl(userId);
                List<Map<String, Object>> addressList = new ArrayList<Map<String, Object>>();
                for (int i = 0; i < list.size(); i++) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put((String) list.get(i).get("name"), list.get(i).get("url"));
                    addressList.add(map);
                }
                task.setRuleAddress(addressList);
                taskListService.updateDistributeTaskWatingForNum(id);
                //retainedService.insertRetained(subid);
                taskListenningService.insertTaskListenning(id, phoneCode);
                //第三方名称的id转换成name
                if (!"".equals(task.getThirdPartyName()) && task.getThirdPartyName() != null) {
                    List<Integer> tpnList = ListUtil.dataList(task.getThirdPartyName());
                    List<String> curList = thirdPartyService.selectBatchNameById(tpnList);
                    String curtpn = StringUtils.join(curList, ",");
                    task.setThirdPartyName(curtpn);
                }
                return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) task);
            }
        }
        // 查询数据获得可以做的任务,先获取"MODEL_TYPE"为抢量模式的任务,没有再获取普通模式
        Integer robCount = taskListService.selectRobTaskCount(userId);
        if (robCount > 0) {
            for (byte k = 9; k >= 0; k--) {
                List<TaskResponse> taskList = taskListService.selectRobTaskData(userId, k);
                if (taskList.isEmpty() || taskList == null) {
                    continue;
                }
                TaskResponse task = taskList.get((int) (Math.random() * taskList.size()));
                Integer id = task.getId();
                String landingPageLink = task.getLandingPageLink();
                String subid = UUID.randomUUID().toString();
                subid = subid.replaceAll("-", "");
                landingPageLink = landingPageLink.replace("[[subid]]", subid);
                task.setLandingPageLink(landingPageLink);
                task.setSubId(subid);
                ;
                task.setCurrentTime(CurrentTimeUtil.currentTime());
                List<Map<String, Object>> list = iphoneRuleService.selectUrl(userId);
                List<Map<String, Object>> addressList = new ArrayList<Map<String, Object>>();
                for (int i = 0; i < list.size(); i++) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put((String) list.get(i).get("name"), list.get(i).get("url"));
                    addressList.add(map);
                }
                task.setRuleAddress(addressList);
                taskListService.updateDistributeTaskWatingForNum(id);
                //retainedService.insertRetained(subid);
                taskListenningService.insertTaskListenning(id, phoneCode);
                //第三方名称的id转换成name
                if (task.getThirdPartyName() != null) {
                    List<Integer> tpnList = ListUtil.dataList(task.getThirdPartyName());
                    List<String> curList = thirdPartyService.selectBatchNameById(tpnList);
                    String curtpn = StringUtils.join(curList, ",");
                    task.setThirdPartyName(curtpn);
                }
                return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) task);
            }
        }
        //获取普通模式的任务
        else {
            List<TaskResponse> taskList = taskListService.selectNormalTaskData(Constant.status_1, type, userId);
            if (!taskList.isEmpty()) {
                //随机获取一个任务
                TaskResponse task = taskList.get((int) (Math.random() * taskList.size()));
                Integer id = task.getId();
                String landingPageLink = task.getLandingPageLink();
                String subid = UUID.randomUUID().toString();
                subid = subid.replaceAll("-", "");
                landingPageLink = landingPageLink.replace("[[subid]]", subid);
                task.setLandingPageLink(landingPageLink);
                task.setSubId(subid);
                ;
                task.setCurrentTime(CurrentTimeUtil.currentTime());
                List<Map<String, Object>> list = iphoneRuleService.selectUrl(userId);
                List<Map<String, Object>> addressList = new ArrayList<Map<String, Object>>();
                for (int i = 0; i < list.size(); i++) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put((String) list.get(i).get("name"), list.get(i).get("url"));
                    addressList.add(map);
                }
                task.setRuleAddress(addressList);
                taskListService.updateDistributeTaskWatingForNum(id);
                //retainedService.insertRetained(subid);
                taskListenningService.insertTaskListenning(id, phoneCode);
                //第三方名称的id转换成name
                if (!"".equals(task.getThirdPartyName()) && task.getThirdPartyName() != null) {
                    List<Integer> tpnList = ListUtil.dataList(task.getThirdPartyName());
                    List<String> curList = thirdPartyService.selectBatchNameById(tpnList);
                    String curtpn = StringUtils.join(curList, ",");
                    task.setThirdPartyName(curtpn);
                }
                return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) task);
            }
        }
        return new CSResponse(ResponseEnum.TASK_EEROR.getCode(), ResponseEnum.TASK_EEROR.getDesc());

    }


}
