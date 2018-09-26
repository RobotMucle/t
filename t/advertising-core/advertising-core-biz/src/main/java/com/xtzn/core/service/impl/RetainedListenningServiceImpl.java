package com.xtzn.core.service.impl;

import com.xtzn.core.mapper.IRetainedListenningMapper;
import com.xtzn.core.service.IRetainedListenningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月4日]
 */
@Service
public class RetainedListenningServiceImpl implements IRetainedListenningService {

    @Autowired
    private IRetainedListenningMapper retainedListenningDao;

    /**
     * 功能描述: <br>
     * 插入监控新数据
     *
     * @author zyw
     * @version [版本号, 2018年4月4日]
     */
    @Override
    public int insertRetainedListenning(Integer retainedId) {

        return retainedListenningDao.insertRetainedListenning(retainedId);
    }

    /**
     * 功能描述: <br>
     * 处理过期数据
     *
     * @author zyw
     * @version [版本号, 2018年4月4日]
     */
    @Override
    public int updateOverdueRetained(List<Map<String, Object>> list) {

        return retainedListenningDao.updateOverdueRetained(list);
    }

    /**
     * 功能描述: <br>
     * 查询过期数据
     *
     * @author zyw
     * @version [版本号, 2018年4月4日]
     */
    @Override
    public List<Map<String, Object>> selectOverdueRetained() {

        return retainedListenningDao.selectOverdueRetained();
    }

    @Override
    public Integer selectCount() {
        return retainedListenningDao.selectCount();
    }


    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年7月3日]
     */
    @Override
    public int updateOverdueRetainedById(Integer retainedId) {

        return retainedListenningDao.updateOverdueRetainedById(retainedId);
    }

}
