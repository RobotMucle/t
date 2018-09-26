package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.ThirdParty;
import com.xtzn.vo.CSRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月19日]
 */
public interface IThirdPartyBusiness {

    public CSResponse selectThirdPartyByPage(CSRequest csRequest);

    public CSResponse selectThirdPartyById(ThirdParty thirdParty);

    public CSResponse deleteById(ThirdParty thirdParty);

    public CSResponse deleteBatchById(List<Integer> list);

    public CSResponse insertThirdParty(ThirdParty thirdParty);

    public CSResponse updateThirdParty(ThirdParty thirdParty);

    public CSResponse selectAllThirdParty();

    public CSResponse selectNameByCondition(ThirdParty thirdParty);
}
