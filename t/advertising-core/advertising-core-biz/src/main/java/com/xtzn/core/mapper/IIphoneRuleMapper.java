package com.xtzn.core.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月25日]
 */
public interface IIphoneRuleMapper {

    public List<Map<String, Object>> selectUrl(@Param("userId") Integer userId);
}
