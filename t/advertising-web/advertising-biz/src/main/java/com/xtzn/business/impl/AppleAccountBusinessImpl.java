package com.xtzn.business.impl;

import com.xtzn.business.IAppleAccountBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.common.Constant;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.AppleAccount;
import com.xtzn.service.IAppleAccountService;
import com.xtzn.vo.DataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
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
@Component("appleAccountBusiness")
public class AppleAccountBusinessImpl implements IAppleAccountBusiness {

    @Autowired
    private IAppleAccountService appleAccountService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    @Override
    public CSResponse retrieveAppleAccountByPage(DataRequest dataRequest) {
        dataRequest.setPageSize(Constant.pageSize);
        dataRequest.setSkips((dataRequest.getPageIndex() - 1) * dataRequest.getPageSize());
        if ("".equals(dataRequest.getUserName())) {
            dataRequest.setCountry(null);
        }
        if ("".equals(dataRequest.getStatus())) {
            dataRequest.setStatus(null);
        }
        if ("".equals(dataRequest.getCountry())) {
            dataRequest.setCountry(null);
        }
        List<AppleAccount> list = appleAccountService.selectAppleAccountByPageIndex(dataRequest);
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = appleAccountService.selectCount(dataRequest);
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
    public CSResponse retrieveSingleAppleAccount(Integer id) {
        AppleAccount appleAccount = appleAccountService.selectAppleAccountById(id);
        if (null != appleAccount) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) appleAccount);
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
    public CSResponse updateAppleAccount(AppleAccount appleAccount) {
        int i = appleAccountService.updateAppleAccountContent(appleAccount);
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
    public CSResponse updateAppleAccountByStatus(AppleAccount appleAccount) {
        int i = appleAccountService.updateAppleAccountStatus();
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
    public CSResponse deleteSingleAppleAccount(Integer id) {
        int i = appleAccountService.deleteById(id);
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
    public CSResponse deleteBatchAppleAccount(List<Integer> list) {
        int i = appleAccountService.deleteBatchById(list);
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
    public CSResponse createAppleAccount(AppleAccount appleAccount) {
        int i = appleAccountService.insertAppleAccount(appleAccount);
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
     * @version [版本号, 2018年4月16日]
     */
    @Override
    public CSResponse retrieveUsingAppleAccount(AppleAccount appleAccount) {
        List<AppleAccount> list = appleAccountService.selectUsingAppleAccount();
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
     * @version [版本号, 2018年5月24日]
     */
    @Override
    public CSResponse createBatchAppleAccount(String account, String country) {
        List<AppleAccount> list = new ArrayList<AppleAccount>();
        String[] accounts = account.split("\n");
        for (int i = 0; i < accounts.length; i++) {
            String[] ac = accounts[i].split("----");
            AppleAccount apple = new AppleAccount();
            apple.setUserName(ac[0]);
            apple.setPassword(ac[1]);
            apple.setCountry(country);
            list.add(apple);
        }
        int i = appleAccountService.insertBatchAppleAccount(list);
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
     * @version [版本号, 2018年6月27日]
     */
    @Override
    public CSResponse selectLockedAppleAccount() {
        List<AppleAccount> list = appleAccountService.selectNeedUnlockAppleAccount();
        if (null == list || list.isEmpty()) {
            return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
        }
        return new CSResponse((Serializable) list);
    }

}
