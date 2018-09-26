package com.xtzn.service.impl;

import com.xtzn.mapper.IIphoneRuleMapper;
import com.xtzn.mapper.entity.IphoneRule;
import com.xtzn.service.IIphoneRuleService;
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
public class IphoneRuleServiceImpl implements IIphoneRuleService {

    @Autowired
    private IIphoneRuleMapper iphoneRuleDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public List<IphoneRule> selectIphoneRuleByPageIndex(Integer userId, Integer skips, Integer pageSize) {

        return iphoneRuleDao.selectIphoneRuleByPageIndex(userId, skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public IphoneRule selectIphoneRuleById(Integer id) {

        return iphoneRuleDao.selectIphoneRuleById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateIphoneRuleContent(IphoneRule iphoneRule) {

        return iphoneRuleDao.updateIphoneRuleContent(iphoneRule);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateIphoneRuleStatus(Integer id, Byte status) {

        return iphoneRuleDao.updateIphoneRuleStatus(id, status);
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

        return iphoneRuleDao.deleteById(id);
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

        return iphoneRuleDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int insertIphoneRule(IphoneRule iphoneRule) {

        return iphoneRuleDao.insertIphoneRule(iphoneRule);
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

        return iphoneRuleDao.selectCount(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public Map<String, Object> selectIphoneRuleForLua(Integer userId) {

        return iphoneRuleDao.selectIphoneRuleForLua(userId);
    }


}
