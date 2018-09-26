package com.xtzn.service;

import com.xtzn.mapper.entity.PortList;
import com.xtzn.vo.DataRequest;
import com.xtzn.vo.PortRequest;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月2日]
 */
public interface IPortListService {

    public List<Map<String, Object>> selectPortListByPage(DataRequest dataRequest);

    public Integer selectCount(DataRequest dataRequest);

    public int insertBatchPortList(List<Map<String, Object>> list);

    public List<Map<String, Object>> selectPortListInfo(PortRequest portRequest);

    public Integer selectCountForPortListInfo(PortRequest portRequest);

    public int updatePortList(PortRequest portRequest);

    public int updatePhoneCode(PortRequest portRequest);

    public int deleteBatchByCondition(PortRequest portRequest);

    public Map<String, Object> selectPortListByServerAddress(PortRequest portRequest);

    public Map<String, Object> selectPortListForLua(PortList portList);

    public int updatePhoneCodeByLua(String phoneCode, Integer id);
}
