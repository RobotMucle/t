package com.xtzn.service.impl;

import com.xtzn.mapper.IRetainedProgramMapper;
import com.xtzn.mapper.entity.RetainedProgram;
import com.xtzn.service.IRetainedProgramService;
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
public class RetainedProgramServiceImpl implements IRetainedProgramService {

    @Autowired
    private IRetainedProgramMapper retainedProgramDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public List<RetainedProgram> selectRetainedProgramByPageIndex(Integer userId, Integer skips, Integer pageSize) {

        return retainedProgramDao.selectRetainedProgramByPageIndex(userId, skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public RetainedProgram selectRetainedProgramById(Integer id) {

        return retainedProgramDao.selectRetainedProgramById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateRetainedProgramContent(RetainedProgram retainedProgram) {

        return retainedProgramDao.updateRetainedProgramContent(retainedProgram);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateRetainedProgramStatus(Byte status, Integer id) {

        return retainedProgramDao.updateRetainedProgramStatus(status, id);
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

        return retainedProgramDao.deleteById(id);
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

        return retainedProgramDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int insertRetainedProgram(RetainedProgram retainedProgram) {

        return retainedProgramDao.insertRetainedProgram(retainedProgram);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月13日]
     */
    @Override
    public List<RetainedProgram> selectUsingRetainedProgram(Integer userId) {

        return retainedProgramDao.selectUsingRetainedProgram(userId);
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

        return retainedProgramDao.selectCount(userId);
    }

}
