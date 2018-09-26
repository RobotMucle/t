package com.xtzn.business.impl;

import com.xtzn.business.IPersonInfoBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.common.Constant;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.PersonInfo;
import com.xtzn.service.IPersonInfoService;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月16日]
 */
@Component
public class PersonInfoBusinessImpl implements IPersonInfoBusiness {

    private static final Logger log = LoggerFactory.getLogger(PersonInfoBusinessImpl.class);

    @Autowired
    private IPersonInfoService personInfoService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月16日]
     */
    @Override
    public CSResponse retrievePersonInfoByPageIndex(DataRequest dataRequest) {
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
        if ("".equals(dataRequest.getIsSuccess())) {
            dataRequest.setIsSuccess(null);
        }
        dataRequest.setPageSize(Constant.pageSize);
        dataRequest.setSkips((dataRequest.getPageIndex() - 1) * dataRequest.getPageSize());
        List<Map<String, Object>> list = personInfoService.selectPersonInfoByPageIndex(dataRequest);
        if (!list.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer count = personInfoService.selectCount(dataRequest);
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
     * @version [版本号, 2018年4月16日]
     */
    @Override
    public CSResponse retrievePersonInfoById(Integer id) {
        PersonInfo personInfo = personInfoService.selectPersonInfoById(id);
        if (null != personInfo) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), (Serializable) personInfo);
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
    public CSResponse createPersonInfo(PersonInfo personInfo) {
        int i = personInfoService.insertPersonInfo(personInfo);
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
    public CSResponse deleteSinglePersonInfo(Integer id) {
        int i = personInfoService.deleteById(id);
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
    public CSResponse deleteBatchPersonInfo(List<Integer> list) {
        int i = personInfoService.deleteBatchById(list);
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
    public CSResponse modifyPersonInfoContent(PersonInfo personInfo) {
        int i = personInfoService.updatePersonInfoContent(personInfo);
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
        int i = personInfoService.deleteBatchByCondition(dataRequest);
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
     * @version [版本号, 2018年5月13日]
     */
    @Override
    public CSResponse uploadPersonInfo(HttpServletRequest request, MultipartFile file) {
        Long name = new Date().getTime();
        String originalFileName = file.getOriginalFilename();
        String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
        if (".xls".equals(suffix) || ".xlsx".equals(suffix)) {
            String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/personInfo/" + name + suffix;
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
                List<PersonInfo> list = ReadExcelUtil.readExcel(workbook, userId, typeId);
                if (!list.isEmpty() && null != list) {
                    personInfoService.insertBatchPersonInfo(list);
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
