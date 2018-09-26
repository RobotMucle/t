package com.xtzn.service.impl;

import com.xtzn.mapper.IPersonInfoMapper;
import com.xtzn.mapper.entity.PersonInfo;
import com.xtzn.service.IPersonInfoService;
import com.xtzn.vo.DataRequest;
import com.xtzn.vo.LuaReuqest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月16日]
 */
@Service
public class PersonInfoServiceImpl implements IPersonInfoService {

    @Autowired
    private IPersonInfoMapper personInfoDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月16日]
     */
    @Override
    public List<Map<String, Object>> selectPersonInfoByPageIndex(DataRequest dataRequest) {
        if ("".equals(dataRequest.getStatus())) {
            dataRequest.setStatus(null);
        }
        return personInfoDao.selectPersonInfoByPageIndex(dataRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月16日]
     */
    @Override
    public PersonInfo selectPersonInfoById(Integer id) {

        return personInfoDao.selectPersonInfoById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月16日]
     */
    @Override
    public int deleteById(Integer id) {

        return personInfoDao.deleteById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月16日]
     */
    @Override
    public int deleteBatchById(List<Integer> list) {

        return personInfoDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月16日]
     */
    @Override
    public int insertPersonInfo(PersonInfo personInfo) {

        return personInfoDao.insertPersonInfo(personInfo);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月16日]
     */
    @Override
    public int updatePersonInfoContent(PersonInfo personInfo) {
        if ("".equals(personInfo.getStatus())) {
            personInfo.setStatus(null);
        }
        return personInfoDao.updatePersonInfoContent(personInfo);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public Integer selectCount(DataRequest dataRequest) {
        if ("".equals(dataRequest.getStatus())) {
            dataRequest.setStatus(null);
        }
        return personInfoDao.selectCount(dataRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月23日]
     */
    @Override
    public int deleteBatchByCondition(DataRequest dataRequest) {
        if ("".equals(dataRequest.getStatus())) {
            dataRequest.setStatus(null);
        }
        return personInfoDao.deleteBatchByCondition(dataRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月27日]
     */
    @Override
    public List<PersonInfo> selectPersonInfoByLua(LuaReuqest luaReuqest) {
        if ("".equals(luaReuqest.getStatus())) {
            luaReuqest.setStatus(null);
        }
        return personInfoDao.selectPersonInfoByLua(luaReuqest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public List<PersonInfo> selectPersonInfoByFileName(String fileName, Integer userId) {

        return personInfoDao.selectPersonInfoByFileName(fileName, userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月13日]
     */
    @Override
    public int insertBatchPersonInfo(List<PersonInfo> list) {

        return personInfoDao.insertBatchPersonInfo(list);
    }

}
