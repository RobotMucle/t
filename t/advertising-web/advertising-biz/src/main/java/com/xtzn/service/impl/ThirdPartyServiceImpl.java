package com.xtzn.service.impl;

import com.xtzn.mapper.IThirdPartyMapper;
import com.xtzn.mapper.entity.ThirdParty;
import com.xtzn.service.IThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月19日]
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
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public List<ThirdParty> selectThirdPartyByPage(Integer skips, Integer pageSize) {

        return thirdPartyDao.selectThirdPartyByPage(skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public ThirdParty selectThirdPartyById(Integer id) {

        return thirdPartyDao.selectThirdPartyById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public int deleteById(Integer id) {

        return thirdPartyDao.deleteById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public int deleteBatchById(List<Integer> list) {

        return thirdPartyDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public int insertThirdParty(ThirdParty thirdParty) {

        return thirdPartyDao.insertThirdParty(thirdParty);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public int updateThirdParty(ThirdParty thirdParty) {

        return thirdPartyDao.updateThirdParty(thirdParty);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public Integer selectCount() {

        return thirdPartyDao.selectCount();
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public List<ThirdParty> selectAllThirdParty() {

        return thirdPartyDao.selectAllThirdParty();
    }

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

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月17日]
     */
    @Override
    public List<ThirdParty> selectNameByCondition(ThirdParty thirdParty) {

        return thirdPartyDao.selectNameByCondition(thirdParty);
    }

}
