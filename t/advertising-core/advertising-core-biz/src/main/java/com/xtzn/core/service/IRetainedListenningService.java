package com.xtzn.core.service;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月4日]
 */
public interface IRetainedListenningService {

    /**
     * 功能描述: <br>
     * 插入监控新数据
     *
     * @param retainedId 留存id
     * @author zyw
     * @version [版本号, 2018年4月3日]
     */
    public int insertRetainedListenning(Integer retainedId);

    /**
     * 功能描述: <br>
     * 处理过期数据
     *
     * @author zyw
     * @version [版本号, 2018年4月3日]
     */
    public int updateOverdueRetained(List<Map<String, Object>>list);

    /**
     * 功能描述: <br>
     * 查询过期数据
     *
     * @author zyw
     * @version [版本号, 2018年4月3日]
     */
    public List<Map<String, Object>> selectOverdueRetained();
    public Integer selectCount();

    public int updateOverdueRetainedById(Integer retainedId);
}
