package com.xtzn.business.impl;

import com.xtzn.business.IAccountInfoBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.common.Constant;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.AccountInfo;
import com.xtzn.service.IAccountInfoService;
import com.xtzn.utils.ReadExcelUtil;
import com.xtzn.vo.DataRequest;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月11日]
 */
@Component("accountInfoBusiness")
public class AccountInfoBusinessImpl implements IAccountInfoBusiness {

    private static final Logger log = LoggerFactory.getLogger(AccountInfoBusinessImpl.class);

    @Autowired
    private IAccountInfoService accountInfoService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月11日]
     */
    @Override
    public CSResponse retrieveAccountInfoByPage(DataRequest dataRequest) {
        if (dataRequest.getDateRange() != null && !dataRequest.getDateRange().equals("")) {
            String dateRange = dataRequest.getDateRange();
            String[] dateRanges = dateRange.split("~");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date startTime = sdf.parse(dateRanges[0]);
                Date endTime = sdf.parse(dateRanges[1]);
                dataRequest.setStartTime(startTime);
                dataRequest.setEndTime(endTime);

            } catch (ParseException e) {
                log.info("时间错误");
            }
        }
        dataRequest.setPageSize(Constant.pageSize);
        dataRequest.setSkips((dataRequest.getPageIndex() - 1) * dataRequest.getPageSize());
        List<Map<String, Object>> list = accountInfoService.selectAccountInfoByPageIndex(dataRequest);
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = accountInfoService.selectCount(dataRequest);
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
     * @version [版本号, 2018年4月11日]
     */
    @Override
    public CSResponse retrieveSingleAccountInfo(Integer id) {
        Map<String, Object> map = accountInfoService.selectAccountInfoById(id);
        if (null != map) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) map);
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月11日]
     */
    @Override
    public CSResponse updateAccountInfo(AccountInfo accountInfo) {
        int i = accountInfoService.updateAccountInfoContent(accountInfo);
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
     * @version [版本号, 2018年4月11日]
     */
    @Override
    public CSResponse updateAccountInfoByStatus(Byte status, Integer id) {
        int i = accountInfoService.updateAccountInfoStatus(status, id);
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
     * @version [版本号, 2018年4月11日]
     */
    @Override
    public CSResponse deleteSingleAccountInfo(Integer id) {
        int i = accountInfoService.deleteById(id);
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
     * @version [版本号, 2018年4月11日]
     */
    @Override
    public CSResponse deleteBatchAccountInfo(List<Integer> list) {
        int i = accountInfoService.deleteBatchById(list);
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
     * @version [版本号, 2018年4月11日]
     */
    @Override
    public CSResponse createAccountInfo(String user, Integer type, Integer userId) {
        String[] users = user.split("\n");
        List<AccountInfo> list = new ArrayList<AccountInfo>();
        for (int i = 0; i < users.length; i++) {
            String[] every = users[i].split("----");
            if (every.length != 2) {
                return new CSResponse(ResponseEnum.RECEIVE_ERROR.getCode(), ResponseEnum.RECEIVE_ERROR.getDesc());
            }
            AccountInfo ai = new AccountInfo();
            ai.setType(type);
            ai.setUserId(userId);
            ai.setUserName(every[0]);
            ai.setUserPwd(every[1]);
            list.add(ai);
        }
        int i = accountInfoService.insertBatchAccountInfo(list);
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
     * @version [版本号, 2018年4月23日]
     */
    @Override
    public CSResponse deleteBatchByCondition(DataRequest dataRequest) {
        if (dataRequest.getDateRange() != null && !dataRequest.getDateRange().equals("")) {
            String dateRange = dataRequest.getDateRange();
            String[] dateRanges = dateRange.split("~");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date startTime = sdf.parse(dateRanges[0]);
                Date endTime = sdf.parse(dateRanges[1]);
                dataRequest.setStartTime(startTime);
                dataRequest.setEndTime(endTime);

            } catch (ParseException e) {
                log.info("时间错误");
            }
        }
        int i = accountInfoService.deleteBatchByCondition(dataRequest);
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
     * @version [版本号, 2018年5月14日]
     */
    @Override
    public CSResponse uploadAccountInfo(HttpServletRequest request, MultipartFile file) {
        Long name = new Date().getTime();
        String originalFileName = file.getOriginalFilename();
        String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
        if (".xls".equals(suffix) || ".xlsx".equals(suffix)) {
            String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/accountInfo/" + name + suffix;
            try {
                file.transferTo(new File(filePath));
                FileInputStream fis = new FileInputStream(filePath);
                Workbook workbook = null;
                if (".xls".equals(suffix)) {
                    workbook = new HSSFWorkbook(fis);
                } else {
                    workbook = new XSSFWorkbook(fis);
                }
                Integer userId = Integer.parseInt(request.getParameter("userId"));
                Integer typeId = Integer.parseInt(request.getParameter("typeId"));
                List<AccountInfo> list = ReadExcelUtil.readAccountExcel(workbook, userId, typeId);
                if (!list.isEmpty() && null != list) {
                    accountInfoService.insertBatchAccountInfo(list);
                    return new CSResponse();
                }
            } catch (IllegalStateException e) {
                log.debug("上传出错");
            } catch (IOException e) {
                log.debug("上传出错");
            }
            return new CSResponse(ResponseEnum.UPLOAD_EXCEL_ERROR.getCode(), ResponseEnum.UPLOAD_EXCEL_ERROR.getDesc());
        }
        return new CSResponse(ResponseEnum.UPLOAD_EXCEL_ERROR.getCode(), ResponseEnum.UPLOAD_EXCEL_ERROR.getDesc());
    }


}
