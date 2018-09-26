package com.xtzn.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtzn.business.IPortListBusiness;
import com.xtzn.business.IRetainedListBusiness;
import com.xtzn.business.ITaskConfigurationBusiness;
import com.xtzn.business.ITaskListBusiness;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.TaskConfiguration;
import com.xtzn.mapper.entity.TaskList;
import com.xtzn.utils.ListUtil;
import com.xtzn.vo.CSRequest;
import com.xtzn.vo.DataRequest;
import com.xtzn.vo.PortRequest;
import com.xtzn.vo.TaskRequest;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年3月30日]
 */
@Controller
@RequestMapping("/taskManage")
public class TaskController {


    @Autowired
    private ITaskListBusiness taskListBusiness;

    @Autowired
    private ITaskConfigurationBusiness taskConfigurationBusiness;

    @Autowired
    private IRetainedListBusiness retainedListBusiness;

    @Autowired
    private IPortListBusiness portListBusiness;


    @RequestMapping(value = "/createTaskList", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse createTaskList(TaskList taskList) {
        if (taskList.getAffiliateAccount() == null || null == taskList.getUserId()) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return taskListBusiness.insertTaskList(taskList);
    }

    @RequestMapping(value = "/retrieveTaskListByPage", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveTaskListByPage(TaskRequest taskRequest) {
        if (taskRequest.getUserId() == null || taskRequest.getType() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return taskListBusiness.retrieveTaskListByPage(taskRequest);
    }

    @RequestMapping(value = "/retrieveTaskListById", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveTaskListById(TaskList taskList) {
        if (taskList.getId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return taskListBusiness.retrieveTaskListById(taskList.getId());
    }

    @RequestMapping(value = "/deleteTaskListById", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteTaskListById(Integer id, Byte type) {
        if (null == id || null == type) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return taskListBusiness.deleteById(id, type);
    }

    @RequestMapping(value = "/deleteBatchTaskList", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchTaskList(String ids) {
        if (null == ids) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return taskListBusiness.updateBatchById(list);
    }

    @RequestMapping(value = "/modifyTaskList", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyTaskList(TaskList taskList) {
        if (taskList.getId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return taskListBusiness.updateTaskList(taskList);
    }

    @RequestMapping(value = "/createTaskConfiguration", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse createTaskConfiguration(TaskConfiguration taskConfiguration, String users) {
        if (taskConfiguration.getConfigurationName() == null || null == users) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return taskConfigurationBusiness.insertTaskConfiguration(taskConfiguration, users);
    }

    //管理员显示页面
    @RequestMapping(value = "/retrieveTaskConfigurationByPage", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveTaskConfigurationByPage(CSRequest csRequest) {
        if (csRequest.getPageIndex() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return taskConfigurationBusiness.selectTaskConfigurationByPage(csRequest);
    }

    //普通用户显示页面
    @RequestMapping(value = "/retrieveTaskConfigurationByUser", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveTaskConfigurationByUser(CSRequest csRequest) {
        if (csRequest.getPageIndex() == null || csRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return taskConfigurationBusiness.selectTaskConfigurationByUser(csRequest);
    }

    @RequestMapping(value = "/retrieveAllTaskConfiguration", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveAllTaskConfiguration(Integer userId) {
        if (userId == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return taskConfigurationBusiness.selectAllTaskConfiguration(userId);
    }

    @RequestMapping(value = "/retrieveTaskConfigurationById", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveTaskConfigurationByPId(TaskConfiguration taskConfiguration) {
        if (taskConfiguration.getId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return taskConfigurationBusiness.selectTaskConfigurationById(taskConfiguration.getId());
    }

    //任务名称去重复
    @RequestMapping(value = "/selectConfigurationName", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse selectConfigurationName(String configurationName, Integer userId) {
        if (null == configurationName || null == userId) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return taskConfigurationBusiness.selectConfigurationName(configurationName, userId);
    }

    @RequestMapping(value = "/deleteTaskConfigurationById", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteTaskConfigurationById(TaskConfiguration taskConfiguration) {
        if (taskConfiguration.getId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return taskConfigurationBusiness.deleteById(taskConfiguration.getId());
    }

    @RequestMapping(value = "/deleteBatchTaskConfiguration", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchTaskConfiguration(String ids) {
        if (ids == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return taskConfigurationBusiness.deleteBatchById(list);
    }

    @RequestMapping(value = "/modifyTaskConfiguration", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyTaskConfiguration(TaskConfiguration taskConfiguration) {
        if (taskConfiguration.getId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return taskConfigurationBusiness.updateTaskConfiguration(taskConfiguration);
    }

    @RequestMapping(value = "/retrieveRetainedListForManage", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveRetainedListForManage(TaskRequest taskRequest) {
        if (taskRequest.getPageIndex() == null || taskRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return retainedListBusiness.selectRetainedListForManage(taskRequest);
    }

    @RequestMapping(value = "/deleteRetainedListByCondition", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteRetainedListByCondition(TaskRequest taskRequest) {
        if (taskRequest.getCountry() == null && taskRequest.getAffiliateAccount() == null && taskRequest.getDateRange() == null && taskRequest.getPhoneCode() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        if (taskRequest.getCountry().equals("") && taskRequest.getAffiliateAccount().equals("") && taskRequest.getDateRange().equals("") && taskRequest.getPhoneCode().equals("")) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return retainedListBusiness.deleteByCondition(taskRequest);
    }

    @RequestMapping(value = "/deleteBatchRetainedList", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchRetainedList(CSRequest csRequest) {
        if (csRequest.getIds() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(csRequest.getIds());
        return retainedListBusiness.deleteBatchById(list);
    }

    @RequestMapping(value = "/retrieveRetainedListForReport", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveRetainedListForReport(TaskRequest taskRequest) {
        if (taskRequest.getPageIndex() == null || taskRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return retainedListBusiness.selectRetaiedListForReport(taskRequest);
    }

    @RequestMapping(value = "/updateIsSuccessBySubId", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse updateIsSuccessBySubId(String subId) {
        if (null == subId) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return retainedListBusiness.updateIsSuccessBySubId(subId);
    }

    @RequestMapping(value = "/createPortList", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse createPortList(PortRequest portRequest) {
        if (portRequest.getServerAddress() == null || portRequest.getServerPort() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        if (portRequest.getPortStart() == null || portRequest.getPortEnd() == null || portRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        if (portRequest.getPortEnd() < portRequest.getPortStart()) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return portListBusiness.insertBatchPortList(portRequest);
    }

    @RequestMapping(value = "/retrievePortListByGroup", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrievePortListByGroup(DataRequest dataRequest) {
        if (dataRequest.getUserId() == null || dataRequest.getPageIndex() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return portListBusiness.selectPortListByGroup(dataRequest);
    }

    @RequestMapping(value = "/retrievePortListInfo", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrievePortListInfo(PortRequest portRequest) {
        if (portRequest.getUserId() == null || portRequest.getPageIndex() == null || portRequest.getServerAddress() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return portListBusiness.selectPortListInfo(portRequest);
    }

    @RequestMapping(value = "/retrievePortListByServerAddress", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrievePortListByServerAddress(PortRequest portRequest) {
        if (portRequest.getServerAddress() == null || portRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return portListBusiness.selectPortListByServerAddress(portRequest);
    }

    @RequestMapping(value = "/deleteBatchPortListByCondition", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchPortListByCondition(PortRequest portRequest) {
        if (portRequest.getUserId() == null || portRequest.getServerAddress() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return portListBusiness.deleteBatchByCondition(portRequest);
    }

    @RequestMapping(value = "/updatePortList", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse updatePortList(PortRequest portRequest) {
        if (portRequest.getUserId() == null || portRequest.getNewServerAddress() == null || portRequest.getOldServerAddress() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return portListBusiness.updatePortList(portRequest);
    }

    @RequestMapping(value = "/updatePhoneCode", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse updatePhoneCode(PortRequest portRequest) {
        if (portRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return portListBusiness.updatePhoneCode(portRequest);
    }

    @RequestMapping(value = "/selectRetaiedListForReportdtl", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse selectRetaiedListForReportdtl(Integer taskId, String uploadTime, Integer userId,
                                                    Integer pageIndex) {
        if (taskId == null || uploadTime == null || userId == null || pageIndex == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return retainedListBusiness.selectRetaiedListForReportdtl(taskId, uploadTime, userId, pageIndex);
    }

    //CPI任务列表重置任务状态为正常
    @RequestMapping(value = "/updateLinkState", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse updateLinkState(Byte linkState, Byte type, Integer userId) {
        if (linkState == null || userId == null || null == type) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return taskListBusiness.updateLinkState(linkState, type, userId);
    }

    //CPI任务列表批量修改内容
    @RequestMapping(value = "/updateTaskListCPI", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse updateTaskListCPI(TaskList taskList, String ids) {
        if (ids == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        if ((taskList.getCrMax() == null || taskList.getCrMin() == null) && taskList.getWaitingForNum() == null && (taskList.getPlayTimeMax() == null || taskList.getPlayTimeMin() == null) && taskList.getStatus() == null && taskList.getTargetNum() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return taskListBusiness.updateTaskListCPI(taskList, ids);
    }

    //首页
    @RequestMapping(value = "/homePage", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse homePage(Integer userId) {
        if (null == userId) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return taskListBusiness.homePage(userId);
    }

    //留存历史报表
    @RequestMapping(value = "/retainedHistoryReport", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retainedHistoryReport(TaskRequest taskRequest) {
        if (taskRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return retainedListBusiness.selectRetainedRecordByCondition(taskRequest);
    }

    //查看留存路径
    @RequestMapping(value = "/selectUploadPath", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse selectUploadPath(String subId) {
        if (null == subId) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return retainedListBusiness.selectUploadPath(subId);
    }

}
