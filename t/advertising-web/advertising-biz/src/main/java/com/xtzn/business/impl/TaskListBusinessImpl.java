package com.xtzn.business.impl;

import com.xtzn.business.ITaskListBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.common.Constant;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.AppleAccount;
import com.xtzn.mapper.entity.TaskList;
import com.xtzn.service.*;
import com.xtzn.utils.ListUtil;
import com.xtzn.utils.MinuteUtil;
import com.xtzn.utils.RedisUtil;
import com.xtzn.vo.DataRequest;
import com.xtzn.vo.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月18日]
 */
@Component
public class TaskListBusinessImpl implements ITaskListBusiness {

    //private static final Logger log = LoggerFactory.getLogger(TaskListBusinessImpl.class);
    @Autowired
    private ITaskListService taskListService;
    @Autowired
    private IRetainedRecordService retainedRecordService;
    @Autowired
    private IIggListService iggListService;
    @Autowired
    private IRetainedListService retainedListService;
    @Autowired
    private IAppleAccountService appleAccountService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public CSResponse retrieveTaskListByPage(TaskRequest taskRequest) {
        if ("".equals(taskRequest.getCountry())) {
            taskRequest.setCountry(null);
        }
        if ("".equals(taskRequest.getAffiliateAccount())) {
            taskRequest.setAffiliateAccount(null);
        }
        if(!"".equals(taskRequest.getAffiliateAccount())&&taskRequest.getAffiliateAccount()!=null){
            taskRequest.setAffiliateName(null);
        }
        if("".equals(taskRequest.getAffiliateName())){
            taskRequest.setAffiliateName(null);
        }
        if ("".equals(taskRequest.getTaskName())) {
            taskRequest.setTaskName(null);
        }
        if ("".equals(taskRequest.getStatus())) {
            taskRequest.setStatus(null);
        }
        List<TaskList> list = taskListService.selectTaskListByPage(taskRequest);
        if (!list.isEmpty() && null != list) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = taskListService.selectCount(taskRequest);
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
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public CSResponse retrieveTaskListById(Integer id) {
        TaskList taskList = taskListService.selectTaskListById(id);
        if (null != taskList) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) taskList);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public CSResponse deleteById(Integer id, Byte type) {
        if (type == 0) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(id);
            int i = taskListService.updateTaskListCPI(list, null, null, null, null, null, null, null, Constant.status_3);
            if (i > 0) {
                return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
            }
            return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
        } else {
            taskListService.deleteById(id);
            TaskRequest taskRequest = new TaskRequest();
            taskRequest.setTaskId(id);
            int i = retainedListService.deleteByCondition(taskRequest);
            if (i > 0) {
                return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
            }
            return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
        }

    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public CSResponse deleteBatchById(List<Integer> list) {
        int i = taskListService.deleteBatchById(list);
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
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public CSResponse insertTaskList(TaskList taskList) {
        //根据目标数和时间轴方案计算出具体方案详情
        Integer targetNum = taskList.getTargetNum();
        String timeline = taskList.getTimeline();
        String[] timelines = timeline.split(",");
        String timelinedtl = "";
        double percent = 0;
        int number = 0;
        for (int i = 0; i < timelines.length; i++) {
            percent = Double.parseDouble(timelines[i]);
            number = (int) Math.ceil(percent * targetNum / 100);
            timelinedtl = timelinedtl + MinuteUtil.getMinuteRandomValue(number) + ";";
        }
        timelinedtl = timelinedtl.substring(0, timelinedtl.length() - 1);
        taskList.setTimelinedtl(timelinedtl);
        //计算cr值
        if (taskList.getCrMin() != null && taskList.getCrMax() != null) {
            double crMin = taskList.getCrMin();
            double crMax = taskList.getCrMax();
            double crValue = crMin + Math.random() * (crMax - crMin);
            DecimalFormat df = new DecimalFormat("0.0");
            crValue = Double.parseDouble(df.format(crValue));
            taskList.setCrValue(crValue);
        }
        int i = taskListService.insertTaskList(taskList);
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
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public CSResponse updateTaskList(TaskList taskList) {
        if (taskList.getCrMin() != null && taskList.getCrMax() != null) {
            double crMin = taskList.getCrMin();
            double crMax = taskList.getCrMax();
            double crValue = crMin + Math.random() * (crMax - crMin);
            DecimalFormat df = new DecimalFormat("0.0");
            crValue = Double.parseDouble(df.format(crValue));
            taskList.setCrValue(crValue);
        }
        int i = taskListService.updateTaskList(taskList);
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
     * @version [版本号, 2018年4月26日]
     */
    @Override
    public CSResponse updateBatchById(List<Integer> list) {
        int i = taskListService.updateBatchById(list);
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
     * @version [版本号, 2018年5月10日]
     */
    @Override
    public CSResponse updateLinkState(Byte linkState, Byte type, Integer userId) {
        int i = taskListService.updateLinkState(linkState, type, userId);
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
     * @version [版本号, 2018年5月10日]
     */
    @Override
    public CSResponse updateTaskListCPI(TaskList taskList, String ids) {
        List<Integer> list = ListUtil.dataList(ids);
        if (taskList.getCrMin() != null && taskList.getCrMax() != null) {
            double crMin = taskList.getCrMin();
            double crMax = taskList.getCrMax();
            double crValue = crMin + Math.random() * (crMax - crMin);
            DecimalFormat df = new DecimalFormat("0.0");
            crValue = Double.parseDouble(df.format(crValue));
            taskList.setCrValue(crValue);
        }
        int i = taskListService.updateTaskListCPI(list, taskList.getWaitingForNum(), taskList.getCrMin(),
                taskList.getCrMax(), taskList.getCrValue(), taskList.getPlayTimeMin(), taskList.getPlayTimeMax(), taskList.getTargetNum(), taskList.getStatus());

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
     * @version [版本号, 2018年5月11日]
     */
    @Override
    public CSResponse homePage(Integer userId) {
        Map<String, Object> map = new HashMap<>();
        DataRequest dataRequest = new DataRequest();
        dataRequest.setUserId(userId);
        dataRequest.setStatus(Constant.status_0);
        //igg可用数量
        Integer iggCount = iggListService.selectCount(dataRequest);
        //今日留存包错误数
        Integer retainedFailure = retainedRecordService.selectFailureCount(userId);
        //昨日任务总数
        String yestodayTaskTotal = RedisUtil.hget("taskTargetNum", String.valueOf(userId));
        //昨日任务完成总数
        Integer yestodayFinishNum = retainedListService.selectYestodayDoTaskCount(userId);
        //昨日剩余留存数
        String yestodayUndoRetained = RedisUtil.hget("retained", String.valueOf(userId));
        //昨日完成留存数
        Integer yestodayDoRetained = retainedRecordService.selectYestodayDoRecordCount(userId);
        //今日留存总数
        String todayTotalRetained = RedisUtil.hget("todayRetained", String.valueOf(userId));
        if (null == todayTotalRetained) {
            todayTotalRetained = "0";
        }
        //今日已做留存数
        Integer todayDoRetained = retainedRecordService.selectTodayDoRecordCount(userId);
        //今日剩余留存数
        Integer todayUndoRetained = Integer.parseInt(todayTotalRetained) - todayDoRetained;
        //今日任务总数
        Integer todayTaskTotal = taskListService.selectTargrtNumForHomepage(userId);
        //今日任务完成总数
        Integer todayFinishNum = retainedListService.selectTodayDoTaskCount(userId);
        //需解锁苹果账号
        List<AppleAccount> list = appleAccountService.selectNeedUnlockAppleAccount();
        if (null == yestodayTaskTotal) {
            yestodayTaskTotal = "0";
        }
        if (null == yestodayUndoRetained) {
            yestodayUndoRetained = "0";
        }
        map.put("iggCount", iggCount);
        map.put("retainedFailure", retainedFailure);
        map.put("yestodayTaskTotal", yestodayTaskTotal);
        map.put("yestodayFinishNum", yestodayFinishNum);
        map.put("yestodayUndoRetained", yestodayUndoRetained);
        map.put("yestodayDoRetained", yestodayDoRetained);
        map.put("todayTotalRetained", todayTotalRetained);
        map.put("todayDoRetained", todayDoRetained);
        map.put("todayUndoRetained", todayUndoRetained);
        map.put("todayTaskTotal", todayTaskTotal);
        map.put("todayFinishNum", todayFinishNum);
        map.put("unlockAppleAccount", list);
        return new CSResponse((Serializable) map);
    }

}
