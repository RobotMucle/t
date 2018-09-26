package com.xtzn.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtzn.business.IIosSystemVersionBusiness;
import com.xtzn.business.IIphoneModelBusiness;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.IosSystemVersion;
import com.xtzn.mapper.entity.IphoneModel;
import com.xtzn.utils.ListUtil;
import com.xtzn.vo.CSRequest;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月14日]
 */
@Controller
@RequestMapping("/mobileVersionManage")
public class MobileVersionManageController {

    @Autowired
    private IIphoneModelBusiness iphoneModelBusiness;

    @Autowired
    private IIosSystemVersionBusiness iosSystemVersionBusiness;

    /**
     * 功能描述: <br>
     * 添加ios版本
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @RequestMapping(value = "/addIosSystemVersion", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse addIosSystemVersion(IosSystemVersion iosSystemVersion) {
        String iosSystem = iosSystemVersion.getIosSystem();
        String versionNumber = iosSystemVersion.getVersionNumber();
        if (null == iosSystem || null == versionNumber) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iosSystemVersionBusiness.createIosSystemVersion(iosSystemVersion);
    }

    /**
     * 功能描述: <br>
     * 删除单个ios版本
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @RequestMapping(value = "/deleteSingleIosSystemVersion", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteSingleIosSystemVersion(IosSystemVersion iosSystemVersion) {
        Integer id = iosSystemVersion.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iosSystemVersionBusiness.deleteById(id);
    }

    /**
     * 功能描述: <br>
     * 批量删除ios版本
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @RequestMapping(value = "/deleteBatchIosSystemVersion", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchIosSystemVersion(String ids) {
        if (null == ids) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return iosSystemVersionBusiness.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * 根据ID查询单个ios版本
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @RequestMapping(value = "/retrieveIosSystemVersion", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveIosSystemVersion(IosSystemVersion iosSystemVersion) {
        Integer id = iosSystemVersion.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iosSystemVersionBusiness.retrieveIosSystemVersionById(id);
    }

    /**
     * 功能描述: <br>
     * 添加手机型号时需要的经过处理后的ios版本信息
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @RequestMapping(value = "/retrieveIosSystemVersionByGroup", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveIosSystemVersionByGroup(IosSystemVersion iosSystemVersion) {

        return iosSystemVersionBusiness.retrieveIosSystemVersionByGroup(iosSystemVersion);
    }

    /**
     * 功能描述: <br>
     * 根据页码查询ios版本
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @RequestMapping(value = "/retrieveIosSystemVersions", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveIosSystemVersions(CSRequest csRequest) {
        if (csRequest.getPageIndex() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iosSystemVersionBusiness.retrieveIosSystemVersionByPage(csRequest);
    }

    /**
     * 功能描述: <br>
     * 修改ios版本
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @RequestMapping(value = "/modifyIosSystemVersion", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyIosSystemVersion(IosSystemVersion iosSystemVersion) {
        Integer id = iosSystemVersion.getId();
        String iosSystem = iosSystemVersion.getIosSystem();
        String versionNumber = iosSystemVersion.getVersionNumber();
        if (null == id || null == iosSystem || null == versionNumber) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iosSystemVersionBusiness.updateIosSystemVersion(iosSystemVersion);
    }

    /**
     * 功能描述: <br>
     * 添加手机型号
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @RequestMapping(value = "/addIphoneModel", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse addIphoneModel(IphoneModel iphoneModel) {
        String model = iphoneModel.getModel();
        String systemVersion = iphoneModel.getSystemVersion();
        if (null == model || null == systemVersion) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iphoneModelBusiness.createIphoneModel(iphoneModel);
    }

    /**
     * 功能描述: <br>
     * 删除单个手机型号
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @RequestMapping(value = "/deleteSingleIphoneModel", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteSingleIphoneModel(IphoneModel iphoneModel) {
        Integer id = iphoneModel.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iphoneModelBusiness.deleteById(id);
    }

    /**
     * 功能描述: <br>
     * 批量删除手机型号
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @RequestMapping(value = "/deleteBatchIphoneModel", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse deleteBatchIphoneModel(String ids) {
        if (null == ids) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        List<Integer> list = ListUtil.dataList(ids);
        return iphoneModelBusiness.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * 根据ID查询单个手机型号
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @RequestMapping(value = "/retrieveIphoneModel", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveIphoneModel(IphoneModel iphoneModel) {
        Integer id = iphoneModel.getId();
        if (null == id) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iphoneModelBusiness.retrieveIphoneModelById(id);
    }

    /**
     * 功能描述: <br>
     * 根据页码查询单个手机型号
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @RequestMapping(value = "/retrieveIphoneModels", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse retrieveIphoneModels(CSRequest csRequest) {
        if (csRequest.getPageIndex() == null) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iphoneModelBusiness.retrieveIphoneModelByPage(csRequest);
    }

    /**
     * 功能描述: <br>
     * 修改手机型号内容
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @RequestMapping(value = "/modifyIphoneModel", method = {RequestMethod.POST})
    @ResponseBody
    public CSResponse modifyIphoneModel(IphoneModel iphoneModel) {
        Integer id = iphoneModel.getId();
        String model = iphoneModel.getModel();
        String systemVersion = iphoneModel.getSystemVersion();
        if (null == id || null == model || null == systemVersion) {
            return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
        }
        return iphoneModelBusiness.updateIphoneModel(iphoneModel);
    }
}
