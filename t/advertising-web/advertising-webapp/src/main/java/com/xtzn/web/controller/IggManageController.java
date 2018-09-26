package com.xtzn.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtzn.business.IIggListBusiness;
import com.xtzn.business.IPhoneListBusiness;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.IggList;
import com.xtzn.mapper.entity.PhoneList;
import com.xtzn.utils.ListUtil;
import com.xtzn.vo.CSRequest;
import com.xtzn.vo.DataRequest;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月18日]
 */
@Controller
@RequestMapping("iggManage")
public class IggManageController {

    @Autowired
    private IIggListBusiness iggListBusiness;

    @Autowired
    private IPhoneListBusiness phoneListBusiness;

    @RequestMapping(value = "/createIggList", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse createIggList(CSRequest csRequest) {
        if (csRequest.getIggCodes() == null || csRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iggListBusiness.insertBatchIggList(csRequest);
    }

    @RequestMapping(value = "/retrieveIggListByPage", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveIggListByPage(DataRequest dataRequest) {
        if (dataRequest.getPageIndex() == null || dataRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iggListBusiness.selectIggListByPage(dataRequest);
    }

    @RequestMapping(value = "/retrieveUsingCount", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveUsingCount(CSRequest csRequest) {
        if (csRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iggListBusiness.selectUsingCount(csRequest.getUserId());
    }

    @RequestMapping(value = "/retrieveIggListById", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveIggListById(IggList iggList) {
        if (null == iggList.getId()) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iggListBusiness.selectIggListById(iggList.getId());
    }

    @RequestMapping(value = "/deleteIggListById", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteIggListById(IggList iggList) {
        if (null == iggList.getId()) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iggListBusiness.deleteById(iggList.getId());
    }

    @RequestMapping(value = "/deleteBatchIggList", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchIggList(String ids) {
        if (null == ids) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return iggListBusiness.deleteBatchById(list);
    }

    @RequestMapping(value = "/modifyIggList", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyIggList(IggList iggList) {
        if (null == iggList.getId()) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iggListBusiness.updateIggList(iggList);
    }

    @RequestMapping(value = "/modifyIggListForOtherUse", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyIggListForOtherUse(String ids, String reason) {
        if (null == ids || null == reason) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return iggListBusiness.updateIggListForOtherUse(list, reason);
    }

    @RequestMapping(value = "/createPhoneList", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse createPhoneList(CSRequest csRequest) {
        if (csRequest.getPhoneCodes() == null || csRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return phoneListBusiness.insertBatchPhoneList(csRequest);
    }

    @RequestMapping(value = "/retrievePhoneListByPage", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrievePhoneListByPage(DataRequest dataRequest) {
        if (dataRequest.getPageIndex() == null || dataRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return phoneListBusiness.retrievePhoneListByPage(dataRequest);
    }

    @RequestMapping(value = "/retrievePhoneListById", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrievePhoneListById(PhoneList phoneList) {
        if (phoneList.getId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return phoneListBusiness.retrievePhoneListById(phoneList.getId());
    }

    @RequestMapping(value = "/deletePhoneListById", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deletePhoneListById(PhoneList phoneList) {
        if (phoneList.getId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return phoneListBusiness.deleteById(phoneList.getId());
    }

    @RequestMapping(value = "/deleteBatchPhoneList", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchPhoneList(String ids) {
        if (ids == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return phoneListBusiness.deleteBatchById(list);
    }

    @RequestMapping(value = "/modifyPhoneList", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyPhoneList(PhoneList phoneList) {
        if (phoneList.getId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return phoneListBusiness.updatePhoneList(phoneList);
    }
}
