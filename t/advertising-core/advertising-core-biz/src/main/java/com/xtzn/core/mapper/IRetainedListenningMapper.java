package com.xtzn.core.mapper;

import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月3日]
 */
public interface IRetainedListenningMapper {

    /**
     * 功能描述: <br>
     * 插入监控新数据
     *
     * @param retainedId     留存id
     * @param distributeType 派发类型
     * @author zyw
     * @version [版本号, 2018年4月3日]
     */
    public int insertRetainedListenning(@Param("retainedId") Integer retainedId);

    /**
     * 功能描述: <br>
     * 处理过期数据
     *
     * @author zyw
     * @version [版本号, 2018年4月3日]
     */
    public int updateOverdueRetained(@Param("list") List<Map<String, Object>> list);

    /**
     * 功能描述: <br>
     * 查询过期数据
     *
     * @author zyw
     * @version [版本号, 2018年4月3日]
     */
    public List<Map<String, Object>> selectOverdueRetained();

    public Integer selectCount();


    public int updateOverdueRetainedById(@Param("retainedId") Integer retainedId);

}
