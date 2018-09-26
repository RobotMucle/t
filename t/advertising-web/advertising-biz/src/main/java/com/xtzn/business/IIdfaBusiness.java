package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.Idfa;
import com.xtzn.vo.DataRequest;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月25日]
 */
public interface IIdfaBusiness {

    public CSResponse selectAccessibleIdfaCount(DataRequest dataRequest);

    public CSResponse createIdfa(Idfa idfa);
}
