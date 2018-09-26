package com.xtzn.core.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年5月14日]
 */
public interface IThirdPartyMapper {

    public List<String> selectBatchNameById(@Param("list") List<Integer> list);
}
