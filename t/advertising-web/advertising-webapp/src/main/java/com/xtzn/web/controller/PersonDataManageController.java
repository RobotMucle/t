package com.xtzn.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xtzn.business.IPersonInfoBusiness;
import com.xtzn.business.IPersonTypeBusiness;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.PersonInfo;
import com.xtzn.mapper.entity.PersonType;
import com.xtzn.utils.ListUtil;
import com.xtzn.vo.CSRequest;
import com.xtzn.vo.DataRequest;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月16日]
 */
@Controller
@RequestMapping("/personDataManage")
public class PersonDataManageController {

    @Autowired
    private IPersonInfoBusiness personInfoBusiness;

    @Autowired
    private IPersonTypeBusiness personTypeBusiness;

    @RequestMapping(value = "/retrievePersonInfoByPage", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrievePersonInfoByPage(DataRequest dataRequest) {
        if (null == dataRequest.getPageIndex() || dataRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return personInfoBusiness.retrievePersonInfoByPageIndex(dataRequest);

    }

    @RequestMapping(value = "/deleteBatchPersonInfoByCondition", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchPersonInfoByCondition(DataRequest dataRequest) {
        if (dataRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        if (dataRequest.getDateRange() == null && dataRequest.getFileName() == null && dataRequest.getIsSuccess() == null && dataRequest.getStatus() == null && dataRequest.getTypeId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return personInfoBusiness.deleteBatchByCondition(dataRequest);

    }

    @RequestMapping(value = "/deleteAllPersonInfo", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteAllPersonInfo(DataRequest dataRequest) {
        if (dataRequest.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return personInfoBusiness.deleteBatchByCondition(dataRequest);

    }

    @RequestMapping(value = "/retrievePersonInfoById", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrievePersonInfoById(PersonInfo personInfo) {
        Integer id = personInfo.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return personInfoBusiness.retrievePersonInfoById(id);
    }

    @RequestMapping(value = "/modifyPersonInfoContent", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyPersonInfoContent(PersonInfo personInfo) {
        if (personInfo.getId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return personInfoBusiness.modifyPersonInfoContent(personInfo);
    }

    @RequestMapping(value = "/deleteSinglePersonInfo", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteSinglePersonInfo(PersonInfo personInfo) {
        Integer id = personInfo.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return personInfoBusiness.deleteSinglePersonInfo(id);
    }

    @RequestMapping(value = "/deleteBatchPersonInfo", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchPersonInfo(String ids) {
        if (null == ids) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return personInfoBusiness.deleteBatchPersonInfo(list);
    }

    @RequestMapping(value = "/createPersonInfo", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse createPersonInfo(PersonInfo personInfo) {
        if (personInfo.getFirstName() == null || personInfo.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return personInfoBusiness.createPersonInfo(personInfo);
    }

    @RequestMapping(value = "/retrievePersonTypeByPage", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrievePersonTypeByPage(CSRequest csRequest) {
        if (null == csRequest.getPageIndex() || null == csRequest.getUserId()) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return personTypeBusiness.retrievePersonTypeByPageIndex(csRequest);
    }

    @RequestMapping(value = "/retrievePersonTypeById", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrievePersonTypeById(PersonType personType) {
        Integer id = personType.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return personTypeBusiness.retrievePersonTypeById(id);
    }

    @RequestMapping(value = "/retrieveAllPersonType", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveAllPersonType(PersonType personType) {
        if (personType.getUserId() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return personTypeBusiness.retrieveAllPersonType(personType);
    }

    @RequestMapping(value = "/deleteSinglePersonType", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteSinglePersonType(PersonType personType) {
        Integer id = personType.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return personTypeBusiness.deleteById(id);
    }

    @RequestMapping(value = "/deleteBatchPersonType", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchPersonType(String ids) {
        if (null == ids) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return personTypeBusiness.deleteBatchById(list);
    }

    @RequestMapping(value = "/modifyPersonTypeContent", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyPersonTypeContent(PersonType personType) {
        if (null == personType.getId() || null == personType.getTypeName()) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return personTypeBusiness.modifyPersonTypeContent(personType);
    }

    @RequestMapping(value = "/createPersonType", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse createPersonType(PersonType personType) {
        if (null == personType.getTypeName() || null == personType.getUserId()) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return personTypeBusiness.createPersonType(personType);
    }

    @RequestMapping(value = "/uploadPersonInfo", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse uploadPersonInfo(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        Integer typeId = Integer.parseInt(request.getParameter("typeId"));
        if (null == file) {
            return new CSResponse(ResponseEnum.UPLOAD_EXCEL_ERROR.getCode(), ResponseEnum.UPLOAD_EXCEL_ERROR.getDesc());
        }
        if (null == userId || null == typeId) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return personInfoBusiness.uploadPersonInfo(request, file);
    }

}
