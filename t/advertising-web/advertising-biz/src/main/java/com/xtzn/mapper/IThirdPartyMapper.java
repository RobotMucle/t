package com.xtzn.mapper;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月19日]
 */

import com.xtzn.mapper.entity.ThirdParty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IThirdPartyMapper {

    public List<ThirdParty> selectThirdPartyByPage(@Param("skips") Integer skips, @Param("pageSize") Integer pageSize);

    public ThirdParty selectThirdPartyById(@Param("id") Integer id);

    public int deleteById(@Param("id") Integer id);

    public int deleteBatchById(@Param("list") List<Integer> list);

    public int insertThirdParty(ThirdParty thirdParty);

    public int updateThirdParty(ThirdParty thirdParty);

    public Integer selectCount();

    public List<ThirdParty> selectAllThirdParty();

    public List<String> selectBatchNameById(@Param("list") List<Integer> list);

    public List<ThirdParty> selectNameByCondition(ThirdParty thirdParty);
}
