package com.xtzn.service;

import com.xtzn.mapper.entity.PersonType;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月16日]
 */
public interface IPersonTypeService {

    public List<PersonType> selectPersonTypeByPageIndex(Integer userId, Integer skips, Integer pageSize);

    public List<PersonType> selectAllPersonType(Integer userId);

    public PersonType selectPersonTypeById(Integer id);

    public int insertPersonType(PersonType personType);

    public int updatePersonTypeName(PersonType personType);

    public int deleteBatchById(List<Integer> list);

    public int deleteById(Integer id);

    public Integer selectCount(Integer userId);
}
