package com.xtzn.service;

import com.xtzn.mapper.entity.IggList;
import com.xtzn.vo.DataRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月18日]
 */
public interface IIggListService {

    public List<IggList> selectIggListByPage(DataRequest dataRequest);

    public IggList selectIggListById(Integer id);

    public int deleteById(Integer id);

    public int deleteBatchById(List<Integer> list);

    public int insertBatchIggList(List<String> list, Integer userId);

    public int updateIggList(IggList iggList);

    public int updateIggListForOtherUse(List<Integer> list, String reason);

    public Integer selectCount(DataRequest dataRequest);

    public Integer selectUsingCount(Integer userId);

    public List<IggList> selectIggByLua(Integer userId);

    public int updateIggResetByLua(IggList iggList);
}
