package com.xtzn.service.impl;

import com.xtzn.mapper.IIdfaMapper;
import com.xtzn.service.IIdfaService;
import com.xtzn.vo.DataRequest;
import com.xtzn.vo.LuaReuqest;
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
public class IdfaServiceImpl implements IIdfaService {

    @Autowired
    private IIdfaMapper idfaDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月25日]
     */
    @Override
    public Integer selectAccessibleIdfaCount(DataRequest dataRequest) {

        return idfaDao.selectAccessibleIdfaCount(dataRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月25日]
     */
    @Override
    public int insertIdfa(List<String> list, String thirdParty, Integer userId) {

        return idfaDao.insertIdfa(list, thirdParty, userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月27日]
     */
    @Override
    public Map<String, Object> selectAccessibleIdfaForLua(LuaReuqest luaReuqest) {

        return idfaDao.selectAccessibleIdfaForLua(luaReuqest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月27日]
     */
    @Override
    public int insertIdfaByLua(LuaReuqest luaReuqest) {

        return idfaDao.insertIdfaByLua(luaReuqest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月2日]
     */
    @Override
    public int updateIdfaByLua(String bundleName, String originalBundleName, Integer id) {

        return idfaDao.updateIdfaByLua(bundleName, originalBundleName, id);
    }


}
