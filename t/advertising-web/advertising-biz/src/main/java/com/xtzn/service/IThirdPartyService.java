package com.xtzn.service;

import com.xtzn.mapper.entity.ThirdParty;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月19日]
 */
public interface IThirdPartyService {

    public List<ThirdParty> selectThirdPartyByPage(Integer skips, Integer pageSize);

    public ThirdParty selectThirdPartyById(Integer id);

    public int deleteById(Integer id);

    public int deleteBatchById(List<Integer> list);

    public int insertThirdParty(ThirdParty thirdParty);

    public int updateThirdParty(ThirdParty thirdParty);

    public Integer selectCount();

    public List<ThirdParty> selectAllThirdParty();

    public List<String> selectBatchNameById(List<Integer> list);

    public List<ThirdParty> selectNameByCondition(ThirdParty thirdParty);
}
