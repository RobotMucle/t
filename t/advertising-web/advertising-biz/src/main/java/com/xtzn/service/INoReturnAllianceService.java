package com.xtzn.service;

import com.xtzn.mapper.entity.NoReturnAlliance;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月23日]
 */
public interface INoReturnAllianceService {

    public List<NoReturnAlliance> selectNoReturnAllianceByPage(Integer userId, Integer skips, Integer pageSize);

    public Integer selectCount(Integer userId);

    public String selectNoReturnAllianceName(Integer userId, String affiliateAccountName);

    public int deleteBatchById(List<Integer> list);

    public int insertNoReturnAlliance(List<String> list, Integer userId);
}
