package com.xtzn.service.impl;

import com.xtzn.mapper.IAllianceMapper;
import com.xtzn.mapper.entity.Alliance;
import com.xtzn.service.IAllianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月12日]
 */
@Service
public class AllianceServiceImpl implements IAllianceService {

    @Autowired
    private IAllianceMapper allianceDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public List<Alliance> selectAllianceByPageIndex(Integer userId, Integer skips, Integer pageSize) {

        return allianceDao.selectAllianceByPageIndex(userId, skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public Alliance selectAllianceById(Integer id) {

        return allianceDao.selectAllianceById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateAllianceContent(Alliance alliance) {

        return allianceDao.updateAllianceContent(alliance);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateAllianceStatus(Byte status, Integer id) {

        return allianceDao.updateAllianceStatus(status, id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int deleteById(Integer id) {

        return allianceDao.deleteById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int deleteBatchById(List<Integer> list) {

        return allianceDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int insertAlliance(Alliance alliance) {

        return allianceDao.insertAlliance(alliance);
    }


    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public List<String> selectUsingAllianceName(Integer userId) {

        return allianceDao.selectUsingAllianceName(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public List<Alliance> selectAllianceByName(Integer userId, String affiliateAccountName) {

        return allianceDao.selectAllianceByName(userId, affiliateAccountName);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public List<Alliance> selectUsingAlliance(Integer userId) {

        return allianceDao.selectUsingAlliance(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月17日]
     */
    @Override
    public List<Map<String, Object>> selectAllAllianceByPageIndex(Integer skips, Integer pageSize) {

        return allianceDao.selectAllAllianceByPageIndex(skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public Integer selectCount(Integer userId) {

        return allianceDao.selectCount(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月25日]
     */
    @Override
    public Integer selectAllCount() {

        return allianceDao.selectAllCount();
    }

}
