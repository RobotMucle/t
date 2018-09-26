package com.xtzn.service.impl;

import com.xtzn.mapper.IPortListMapper;
import com.xtzn.mapper.entity.PortList;
import com.xtzn.service.IPortListService;
import com.xtzn.vo.DataRequest;
import com.xtzn.vo.PortRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月23日]
 */
@Service
public class PortListServiceImpl implements IPortListService {

    @Autowired
    private IPortListMapper portListDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月23日]
     */
    @Override
    public List<Map<String, Object>> selectPortListByPage(DataRequest dataRequest) {

        return portListDao.selectPortListByPage(dataRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月23日]
     */
    @Override
    public Integer selectCount(DataRequest dataRequest) {

        return portListDao.selectCount(dataRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月23日]
     */
    @Override
    public int insertBatchPortList(List<Map<String, Object>> list) {

        return portListDao.insertBatchPortList(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月24日]
     */
    @Override
    public List<Map<String, Object>> selectPortListInfo(PortRequest portRequest) {

        return portListDao.selectPortListInfo(portRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月24日]
     */
    @Override
    public Integer selectCountForPortListInfo(PortRequest portRequest) {

        return portListDao.selectCountForPortListInfo(portRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月24日]
     */
    @Override
    public int updatePortList(PortRequest portRequest) {

        return portListDao.updatePortList(portRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月24日]
     */
    @Override
    public int deleteBatchByCondition(PortRequest portRequest) {

        return portListDao.deleteBatchByCondition(portRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月24日]
     */
    @Override
    public int updatePhoneCode(PortRequest portRequest) {

        return portListDao.updatePhoneCode(portRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月25日]
     */
    @Override
    public Map<String, Object> selectPortListByServerAddress(PortRequest portRequest) {

        return portListDao.selectPortListByServerAddress(portRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月26日]
     */
    @Override
    public Map<String, Object> selectPortListForLua(PortList portList) {

        return portListDao.selectPortListForLua(portList);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月29日]
     */
    @Override
    public int updatePhoneCodeByLua(String phoneCode, Integer id) {

        return portListDao.updatePhoneCodeByLua(phoneCode, id);
    }

}
