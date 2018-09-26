package com.xtzn.service;

import com.xtzn.vo.DataRequest;
import com.xtzn.vo.LuaReuqest;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月25日]
 */
public interface IIdfaService {

    public Integer selectAccessibleIdfaCount(DataRequest dataRequest);

    public int insertIdfa(List<String> list, String thirdParty, Integer userId);

    public Map<String, Object> selectAccessibleIdfaForLua(LuaReuqest luaReuqest);

    public int insertIdfaByLua(LuaReuqest luaReuqest);

    public int updateIdfaByLua(String bundleName, String originalBundleName, Integer id);


}
