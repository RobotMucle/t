package com.xtzn.service.impl;

import com.xtzn.mapper.IIosSystemVersionMapper;
import com.xtzn.mapper.entity.IosSystemVersion;
import com.xtzn.service.IIosSystemVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月14日]
 */
@Service
public class IosSystemVersionServiceImpl implements IIosSystemVersionService {

    @Autowired
    private IIosSystemVersionMapper iosSystemVersionDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public IosSystemVersion selectIosSystemVersionById(Integer id) {

        return iosSystemVersionDao.selectIosSystemVersionById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public List<IosSystemVersion> selectIosSystemVersionByPage(Integer skips, Integer pageSize) {

        return iosSystemVersionDao.selectIosSystemVersionByPage(skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public int insertIosSystemVersion(IosSystemVersion iosSystemVersion) {

        return iosSystemVersionDao.insertIosSystemVersion(iosSystemVersion);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public int updateIosSystemVersion(IosSystemVersion iosSystemVersion) {

        return iosSystemVersionDao.updateIosSystemVersion(iosSystemVersion);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public int deleteById(Integer id) {

        return iosSystemVersionDao.deleteById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public int deleteBatchById(List<Integer> list) {

        return iosSystemVersionDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public List<Map<String, Object>> selectIosSystemVersionByGroup() {

        return iosSystemVersionDao.selectIosSystemVersionByGroup();
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public List<IosSystemVersion> selectAllIosSystemVersionByPage(Integer skips, Integer pageSize) {

        return iosSystemVersionDao.selectAllIosSystemVersionByPage(skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public Integer selectCount() {

        return iosSystemVersionDao.selectCount();
    }

}
