package com.xtzn.mapper;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月18日]
 */

import com.xtzn.mapper.entity.IggList;
import com.xtzn.vo.DataRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IIggListMapper {

    public List<IggList> selectIggListByPage(DataRequest dataRequest);

    public IggList selectIggListById(@Param("id") Integer id);

    public int deleteById(@Param("id") Integer id);

    public int deleteBatchById(@Param("list") List<Integer> list);

    public int insertBatchIggList(@Param("list") List<String> list, @Param("userId") Integer userId);

    public int updateIggList(IggList iggList);

    public int updateIggListForOtherUse(@Param("list") List<Integer> list, @Param("reason") String reason);

    public Integer selectCount(DataRequest dataRequest);

    public Integer selectUsingCount(@Param("userId") Integer userId);

    public List<IggList> selectIggByLua(@Param("userId") Integer userId);

    public int updateIggResetByLua(IggList iggList);
}
