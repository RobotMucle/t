package com.xtzn.business;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月16日]
 */

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.PersonInfo;
import com.xtzn.vo.DataRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IPersonInfoBusiness {

    public CSResponse retrievePersonInfoByPageIndex(DataRequest dataRequest);

    public CSResponse retrievePersonInfoById(Integer id);

    public CSResponse createPersonInfo(PersonInfo personInfo);

    public CSResponse deleteSinglePersonInfo(Integer id);

    public CSResponse deleteBatchPersonInfo(List<Integer> list);

    public CSResponse modifyPersonInfoContent(PersonInfo personInfo);

    public CSResponse deleteBatchByCondition(DataRequest dataRequest);

    public CSResponse uploadPersonInfo(HttpServletRequest request, MultipartFile file);
}
