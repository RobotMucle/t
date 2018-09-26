package com.xtzn.core.business.impl;

import com.xtzn.core.business.IRetainedBusiness;
import com.xtzn.core.commom.TypeCommon;
import com.xtzn.core.enums.ResponseEnum;
import com.xtzn.core.service.IIphoneRuleService;
import com.xtzn.core.service.IRetainedListService;
import com.xtzn.core.service.IRetainedListenningService;
import com.xtzn.core.service.IThirdPartyService;
import com.xtzn.core.utils.CurrentTimeUtil;
import com.xtzn.core.utils.JedisLockUtil;
import com.xtzn.core.utils.ListUtil;
import com.xtzn.core.utils.RedisUtil;
import com.xtzn.core.vo.CSResponse;
import com.xtzn.core.vo.RetainedResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;

/**
 * 功能描述: <br>
 * 留存业务
 *
 * @author zyw
 * @version [版本号, 2018年4月2日]
 */
@Component("retainedBusiness")
public class RetainedBusinessImpl implements IRetainedBusiness {

    private static final Logger log = LoggerFactory.getLogger(RetainedBusinessImpl.class);
    @Autowired
    private IRetainedListService retainedService;
    @Autowired
    private IRetainedListenningService retainedListenningService;
    @Autowired
    private IIphoneRuleService iphoneRuleService;
    @Autowired
    private IThirdPartyService thirdPartyService;

    /**
     * 功能描述: <br>
     * 获取留存数据
     *
     * @author zyw
     * @version [版本号, 2018年4月2日]
     */
    @Override
    public CSResponse requestRetainedData(Integer userId, Byte uploadType) {
        String upload = null;
        if (uploadType == 0) {
            upload = "%.zip%";
        } else {
            upload = "%.tar.gz%";
        }
        Long now = new Date().getTime();
        JedisLockUtil jedisLock = new JedisLockUtil(String.valueOf(userId), "requestRetainedData", String.valueOf(now));
        //RedisLock jedisLock = new RedisLock(redisTemplate, "requestRetainedData",10000,20000);
        RetainedResponse map = null;
        try {
            if (jedisLock.lock()) {
                map = retainedService.selectRetainedData(userId, upload);
                if (null != map) {
                    Integer retainedId = map.getId();
                    retainedService.updateDistributeRetained(retainedId);
                }
            }
        } catch (Exception e) {
            log.info("redis出错");
            log.error("redis错误。。。。", e);
        } finally {
            RedisUtil.delField(String.valueOf(userId), "requestRetainedData");
        }
        //对留存的一次登陆进行监控
        if (null != map) {
            List<Map<String, Object>> list = iphoneRuleService.selectUrl(userId);
            List<Map<String, Object>> addressList = new ArrayList<Map<String, Object>>();
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> ruleAddress = new HashMap<String, Object>();
                ruleAddress.put((String) list.get(i).get("name"), list.get(i).get("url"));
                addressList.add(ruleAddress);
            }
            map.setRuleAddress(addressList);
            Integer retainedId = map.getId();
            //retainedService.updateDistributeRetained(retainedId);
            map.setDistributeType(TypeCommon.unnormalType);
            map.setCurrentTime(CurrentTimeUtil.currentTime());
            retainedListenningService.updateOverdueRetainedById(retainedId);
            retainedListenningService.insertRetainedListenning(retainedId);
            //第三方名称的id转换成name
            if (!"".equals(map.getThirdPartyName()) && null != map.getThirdPartyName()) {
                List<Integer> tpnList = ListUtil.dataList(map.getThirdPartyName());
                List<String> curList = thirdPartyService.selectBatchNameById(tpnList);
                String curtpn = StringUtils.join(curList, ",");
                map.setThirdPartyName(curtpn);
            }
            return new CSResponse(ResponseEnum.SUCCESS_留存.getCode(), ResponseEnum.SUCCESS_留存.getDesc(), (Serializable) map);
        }


        List<RetainedResponse> retainedlist = retainedService.selectRetainedSecondLoginData(userId, upload);
        //不对留存的二次及多次登陆进行监控
        if (!retainedlist.isEmpty()) {
            RetainedResponse rmap = retainedlist.get((int) (Math.random() * retainedlist.size()));
            List<Map<String, Object>> list = iphoneRuleService.selectUrl(userId);
            List<Map<String, Object>> addressList = new ArrayList<Map<String, Object>>();
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> ruleAddress = new HashMap<String, Object>();
                ruleAddress.put((String) list.get(i).get("name"), list.get(i).get("url"));
                addressList.add(ruleAddress);
            }
            rmap.setRuleAddress(addressList);
            ;
            rmap.setDistributeType(TypeCommon.normalType);
            rmap.setCurrentTime(CurrentTimeUtil.currentTime());
            //第三方名称的id转换成name
            if (!"".equals(rmap.getThirdPartyName()) && null != rmap.getThirdPartyName()) {
                List<Integer> tpnList = ListUtil.dataList(rmap.getThirdPartyName());
                List<String> curList = thirdPartyService.selectBatchNameById(tpnList);
                String curtpn = StringUtils.join(curList, ",");
                rmap.setThirdPartyName(curtpn);
            }
            return new CSResponse(ResponseEnum.SUCCESS_留存.getCode(), ResponseEnum.SUCCESS_留存.getDesc(), (Serializable) rmap);
        }
        return new CSResponse(ResponseEnum.RETAINED_EEROR.getCode(), ResponseEnum.RETAINED_EEROR.getDesc());
    }


}
