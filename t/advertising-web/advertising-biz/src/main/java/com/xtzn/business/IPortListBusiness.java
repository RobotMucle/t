package com.xtzn.business;


import com.xtzn.click.vo.CSResponse;
import com.xtzn.vo.DataRequest;
import com.xtzn.vo.PortRequest;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月23日]
 */
public interface IPortListBusiness {

    public CSResponse insertBatchPortList(PortRequest portRequest);

    public CSResponse selectPortListByGroup(DataRequest dataRequest);

    public CSResponse selectPortListInfo(PortRequest portRequest);

    public CSResponse updatePortList(PortRequest portRequest);

    public CSResponse updatePhoneCode(PortRequest portRequest);

    public CSResponse deleteBatchByCondition(PortRequest portRequest);

    public CSResponse selectPortListByServerAddress(PortRequest portRequest);

}
