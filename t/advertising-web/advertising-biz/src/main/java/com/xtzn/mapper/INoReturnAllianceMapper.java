package com.xtzn.mapper;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月23日]
 */

import com.xtzn.mapper.entity.NoReturnAlliance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface INoReturnAllianceMapper {

    public List<NoReturnAlliance> selectNoReturnAllianceByPage(@Param("userId") Integer userId, @Param("skips") Integer skips, @Param("pageSize") Integer pageSize);

    public Integer selectCount(@Param("userId") Integer userId);

    public String selectNoReturnAllianceName(@Param("userId") Integer userId, @Param("affiliateAccountName") String affiliateAccountName);

    public int deleteBatchById(@Param("list") List<Integer> list);

    public int insertNoReturnAlliance(@Param("list") List<String> list, @Param("userId") Integer userId);
}
