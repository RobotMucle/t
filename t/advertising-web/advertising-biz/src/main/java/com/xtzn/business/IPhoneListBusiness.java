package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.PhoneList;
import com.xtzn.vo.CSRequest;
import com.xtzn.vo.DataRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月18日]
 */
public interface IPhoneListBusiness {

    public CSResponse retrievePhoneListByPage(DataRequest dataRequest);

    public CSResponse retrievePhoneListById(Integer id);

    public CSResponse deleteById(Integer id);

    public CSResponse deleteBatchById(List<Integer> list);

    public CSResponse insertBatchPhoneList(CSRequest csRequest);

    public CSResponse updatePhoneList(PhoneList phoneList);
}
