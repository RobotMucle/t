package com.xtzn.service.impl;

import com.xtzn.mapper.IIphoneModelMapper;
import com.xtzn.mapper.entity.IphoneModel;
import com.xtzn.service.IIphoneModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月14日]
 */
@Service
public class IphoneModelServiceImpl implements IIphoneModelService {

    @Autowired
    private IIphoneModelMapper iphoneModelDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public IphoneModel selectIphoneModelById(Integer id) {

        return iphoneModelDao.selectIphoneModelById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public List<IphoneModel> selectIphoneModelByPage(Integer skips, Integer pageSize) {

        return iphoneModelDao.selectIphoneModelByPage(skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public int insertIphoneModel(IphoneModel iphoneModel) {

        return iphoneModelDao.insertIphoneModel(iphoneModel);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月14日]
     */
    @Override
    public int updateIphoneModel(IphoneModel iphoneModel) {

        return iphoneModelDao.updateIphoneModel(iphoneModel);
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

        return iphoneModelDao.deleteById(id);
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

        return iphoneModelDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public List<IphoneModel> selectAllIphoneModelByPage(Integer skips, Integer pageSize) {

        return iphoneModelDao.selectAllIphoneModelByPage(skips, pageSize);
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

        return iphoneModelDao.selectCount();
    }

}
