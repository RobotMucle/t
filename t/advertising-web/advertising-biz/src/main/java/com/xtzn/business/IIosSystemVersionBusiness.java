package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.IosSystemVersion;
import com.xtzn.vo.CSRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月14日]
 */
public interface IIosSystemVersionBusiness {

    public CSResponse retrieveIosSystemVersionById(Integer id);

    public CSResponse retrieveIosSystemVersionByPage(CSRequest csRequest);

    public CSResponse createIosSystemVersion(IosSystemVersion iosSystemVersion);

    public CSResponse updateIosSystemVersion(IosSystemVersion iosSystemVersion);

    public CSResponse deleteById(Integer id);

    public CSResponse deleteBatchById(List<Integer> list);

    public CSResponse retrieveIosSystemVersionByGroup(IosSystemVersion iosSystemVersion);
}
