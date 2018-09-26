package com.xtzn.mapper;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月16日]
 */

import com.xtzn.mapper.entity.PersonType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPersonTypeMapper {

    public List<PersonType> selectPersonTypeByPageIndex(@Param("userId") Integer userId, @Param("skips") Integer skips, @Param("pageSize") Integer pageSize);

    public List<PersonType> selectAllPersonType(@Param("userId") Integer userId);

    public PersonType selectPersonTypeById(@Param("id") Integer id);

    public int insertPersonType(PersonType personType);

    public int updatePersonTypeName(PersonType personType);

    public int deleteBatchById(@Param("list") List<Integer> list);

    public int deleteById(@Param("id") Integer id);

    public Integer selectCount(@Param("userId") Integer userId);
}
