package com.xtzn.core.service.impl;

import com.xtzn.core.mapper.IThirdPartyMapper;
import com.xtzn.core.service.IThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年5月14日]
 */
@Service
public class ThirdPartyServiceImpl implements IThirdPartyService {

    @Autowired
    private IThirdPartyMapper thirdPartyDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月14日]
     */
    @Override
    public List<String> selectBatchNameById(List<Integer> list) {

        return thirdPartyDao.selectBatchNameById(list);
    }

}
