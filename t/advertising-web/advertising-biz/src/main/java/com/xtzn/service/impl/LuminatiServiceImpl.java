package com.xtzn.service.impl;

import com.xtzn.mapper.ILuminatiMapper;
import com.xtzn.mapper.entity.Luminati;
import com.xtzn.service.ILuminatiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月12日]
 */
@Service
public class LuminatiServiceImpl implements ILuminatiService {

    @Autowired
    private ILuminatiMapper luminatiDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public Luminati selectByStatus(Integer userId) {

        return luminatiDao.selectByStatus(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public List<Luminati> selectLuminatiByPageIndex(Integer userId, Integer skips, Integer pageSize) {

        return luminatiDao.selectLuminatiByPageIndex(userId, skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public Luminati selectLuminatiById(Integer id) {

        return luminatiDao.selectLuminatiById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateLuminatiContent(Luminati luminati) {

        return luminatiDao.updateLuminatiContent(luminati);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateLuminatiStatus(Luminati luminati) {

        return luminatiDao.updateLuminatiStatus(luminati);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int deleteById(Integer id) {

        return luminatiDao.deleteById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int deleteBatchById(List<Integer> list) {

        return luminatiDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int insertLuminati(Luminati luminati) {

        return luminatiDao.insertLuminati(luminati);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public Integer selectCount(Integer userId) {

        return luminatiDao.selectCount(userId);
    }

}
