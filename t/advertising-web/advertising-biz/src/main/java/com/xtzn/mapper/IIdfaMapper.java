package com.xtzn.mapper;

import com.xtzn.vo.DataRequest;
import com.xtzn.vo.LuaReuqest;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月24日]
 */
public interface IIdfaMapper {

    public Integer selectAccessibleIdfaCount(DataRequest dataRequest);

    public int insertIdfa(@Param("list") List<String> list, @Param("thirdParty") String thirdParty, @Param("userId") Integer userId);

    public Map<String, Object> selectAccessibleIdfaForLua(LuaReuqest luaReuqest);

    public int insertIdfaByLua(LuaReuqest luaReuqest);

    public int updateIdfaByLua(@Param("bundleName") String bundleName, @Param("originalBundleName") String originalBundleName, @Param("id") Integer id);
}
