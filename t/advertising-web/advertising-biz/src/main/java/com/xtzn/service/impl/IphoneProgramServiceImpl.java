package com.xtzn.service.impl;

import com.xtzn.mapper.IIphoneProgramMapper;
import com.xtzn.mapper.entity.IphoneProgram;
import com.xtzn.service.IIphoneProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月12日]
 */
@Service
public class IphoneProgramServiceImpl implements IIphoneProgramService {

    @Autowired
    private IIphoneProgramMapper iphoneProgramDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public List<Map<String, Object>> selectIphoneProgramByPageIndex(Integer userId, Integer skips, Integer pageSize) {

        return iphoneProgramDao.selectIphoneProgramByPageIndex(userId, skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public IphoneProgram selectIphoneProgramById(Integer id) {

        return iphoneProgramDao.selectIphoneProgramById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateIphoneProgramContent(IphoneProgram iphoneProgram) {

        return iphoneProgramDao.updateIphoneProgramContent(iphoneProgram);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateIphoneProgramStatus(IphoneProgram iphoneProgram) {

        return iphoneProgramDao.updateIphoneProgramStatus(iphoneProgram);
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

        return iphoneProgramDao.deleteById(id);
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

        return iphoneProgramDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int insertIphoneProgram(IphoneProgram iphoneProgram) {

        return iphoneProgramDao.insertIphoneProgram(iphoneProgram);
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

        return iphoneProgramDao.selectCount(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public Map<String, Object> selectIphoneProgramForLua(Integer userId) {

        return iphoneProgramDao.selectIphoneProgramForLua(userId);
    }

}
