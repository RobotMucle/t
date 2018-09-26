package com.xtzn.core.service.impl;

import com.xtzn.core.mapper.IIphoneRuleMapper;
import com.xtzn.core.service.IIphoneRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月25日]
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
     * @version [版本号, 2018年4月25日]
     */
    @Override
    public List<Map<String, Object>> selectUrl(Integer userId) {

        return iphoneRuleDao.selectUrl(userId);
    }

}
