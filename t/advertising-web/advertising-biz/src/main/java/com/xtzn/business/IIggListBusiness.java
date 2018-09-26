package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.IggList;
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
public interface IIggListBusiness {

    public CSResponse selectIggListByPage(DataRequest dataRequest);

    public CSResponse selectIggListById(Integer id);

    public CSResponse deleteById(Integer id);

    public CSResponse selectUsingCount(Integer userId);

    public CSResponse deleteBatchById(List<Integer> list);

    public CSResponse insertBatchIggList(CSRequest csRequest);

    public CSResponse updateIggList(IggList iggList);

    public CSResponse updateIggListForOtherUse(List<Integer> list, String reason);
}
