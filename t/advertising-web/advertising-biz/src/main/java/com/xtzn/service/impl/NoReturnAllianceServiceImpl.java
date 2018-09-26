package com.xtzn.service.impl;

import com.xtzn.mapper.INoReturnAllianceMapper;
import com.xtzn.mapper.entity.NoReturnAlliance;
import com.xtzn.service.INoReturnAllianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月23日]
 */
@Service
public class NoReturnAllianceServiceImpl implements INoReturnAllianceService {

    @Autowired
    private INoReturnAllianceMapper noReturnAllianceDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月23日]
     */
    @Override
    public List<NoReturnAlliance> selectNoReturnAllianceByPage(Integer userId, Integer skips, Integer pageSize) {

        return noReturnAllianceDao.selectNoReturnAllianceByPage(userId, skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月23日]
     */
    @Override
    public Integer selectCount(Integer userId) {

        return noReturnAllianceDao.selectCount(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月23日]
     */
    @Override
    public int deleteBatchById(List<Integer> list) {

        return noReturnAllianceDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月23日]
     */
    @Override
    public int insertNoReturnAlliance(List<String> list, Integer userId) {

        return noReturnAllianceDao.insertNoReturnAlliance(list, userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月25日]
     */
    @Override
    public String selectNoReturnAllianceName(Integer userId, String affiliateAccountName) {

        return noReturnAllianceDao.selectNoReturnAllianceName(userId, affiliateAccountName);
    }

}
