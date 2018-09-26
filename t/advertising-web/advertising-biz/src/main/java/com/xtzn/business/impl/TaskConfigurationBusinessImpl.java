package com.xtzn.business.impl;

import com.xtzn.business.ITaskConfigurationBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.common.Constant;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.TaskConfiguration;
import com.xtzn.service.ITaskConfigurationService;
import com.xtzn.service.IThirdPartyService;
import com.xtzn.utils.ListUtil;
import com.xtzn.vo.CSRequest;
import org.apache.commons.lang.StringUtils;
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
 * @version [版本号, 2018年4月19日]
 */
@Component
public class TaskConfigurationBusinessImpl implements ITaskConfigurationBusiness {

    @Autowired
    private ITaskConfigurationService taskConfigurationService;
    @Autowired
    private IThirdPartyService thirdPartyService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public CSResponse selectTaskConfigurationByPage(CSRequest csRequest) {
        //不启用分页,启用时请在mapper里面添加limit
        Integer pageSize = Constant.pageSize;
        Integer skips = (csRequest.getPageIndex() - 1) * pageSize;
        List<Map<String, Object>> list = taskConfigurationService.selectTaskConfigurationByPage(skips, pageSize);
        if (!list.isEmpty() && null != list) {
            for (int i = 0; i < list.size(); i++) {
                String tpn = (String) list.get(i).get("thirdPartyName");
                if (!("").equals(tpn) && null != tpn) {
                    List<Integer> tpnList = ListUtil.dataList(tpn);
                    List<String> curList = thirdPartyService.selectBatchNameById(tpnList);
                    String curtpn = StringUtils.join(curList, ",");
                    list.get(i).put("thirdPartyName", curtpn);
                }
            }
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = taskConfigurationService.selectCount();
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
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public CSResponse selectAllTaskConfiguration(Integer userId) {
        List<Map<String, Object>> list = taskConfigurationService.selectAllTaskConfiguration(userId);
        if (!list.isEmpty()) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) list);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public CSResponse selectTaskConfigurationById(Integer id) {
        Map<String, Object> map = taskConfigurationService.selectTaskConfigurationById(id);
        if (null != map) {
            String thirdPartyName = (String) map.get("thirdPartyName");
            String[] thirdPartyNames = thirdPartyName.split(",");
            map.put("thirdPartyName", thirdPartyNames);
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) map);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public CSResponse deleteById(Integer id) {
        int i = taskConfigurationService.deleteById(id);
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
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public CSResponse deleteBatchById(List<Integer> list) {
        int i = taskConfigurationService.deleteBatchById(list);
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
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public CSResponse insertTaskConfiguration(TaskConfiguration taskConfiguration, String users) {
        String[] user = users.split(",");
        if (user.length > 0) {
            for (int i = 0; i < user.length; i++) {
                Integer userId = Integer.valueOf(user[i]);
                taskConfiguration.setUserId(userId);
                taskConfigurationService.insertTaskConfiguration(taskConfiguration);
            }
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public CSResponse updateTaskConfiguration(TaskConfiguration taskConfiguration) {
        int i = taskConfigurationService.updateTaskConfiguration(taskConfiguration);
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
     * @version [版本号, 2018年4月25日]
     */
    @Override
    public CSResponse selectConfigurationName(String configurationName, Integer userId) {
        String cName = taskConfigurationService.selectConfigurationName(configurationName, userId);
        if (null != cName) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月25日]
     */
    @Override
    public CSResponse selectTaskConfigurationByUser(CSRequest csRequest) {
        //不启用分页,启用时请在mapper里面添加limit
        Integer pageSize = Constant.pageSize;
        Integer skips = (csRequest.getPageIndex() - 1) * pageSize;
        List<Map<String, Object>> list = taskConfigurationService.selectTaskConfigurationByUser(csRequest.getUserId(), skips, pageSize);
        if (!list.isEmpty() && null != list) {
            for (int i = 0; i < list.size(); i++) {
                String tpn = (String) list.get(i).get("thirdPartyName");
                if (!("").equals(tpn) && null != tpn) {
                    List<Integer> tpnList = ListUtil.dataList(tpn);
                    List<String> curList = thirdPartyService.selectBatchNameById(tpnList);
                    String curtpn = StringUtils.join(curList, ",");
                    list.get(i).put("thirdPartyName", curtpn);
                }
            }
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = taskConfigurationService.selectCountByUser(csRequest.getUserId());
            map.put("data", list);
            map.put("count", count);
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) map);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

}
