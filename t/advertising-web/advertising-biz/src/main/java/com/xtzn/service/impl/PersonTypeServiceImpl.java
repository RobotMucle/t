package com.xtzn.service.impl;

import com.xtzn.mapper.IPersonTypeMapper;
import com.xtzn.mapper.entity.PersonType;
import com.xtzn.service.IPersonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月16日]
 */
@Service
public class PersonTypeServiceImpl implements IPersonTypeService {

    @Autowired
    private IPersonTypeMapper personTypeDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月16日]
     */
    @Override
    public List<PersonType> selectPersonTypeByPageIndex(Integer userId, Integer skips, Integer pageSize) {

        return personTypeDao.selectPersonTypeByPageIndex(userId, skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月16日]
     */
    @Override
    public List<PersonType> selectAllPersonType(Integer userId) {

        return personTypeDao.selectAllPersonType(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月16日]
     */
    @Override
    public PersonType selectPersonTypeById(Integer id) {

        return personTypeDao.selectPersonTypeById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月16日]
     */
    @Override
    public int insertPersonType(PersonType personType) {

        return personTypeDao.insertPersonType(personType);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月16日]
     */
    @Override
    public int updatePersonTypeName(PersonType personType) {

        return personTypeDao.updatePersonTypeName(personType);
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

        return personTypeDao.deleteBatchById(list);
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

        return personTypeDao.deleteById(id);
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

        return personTypeDao.selectCount(userId);
    }

}
