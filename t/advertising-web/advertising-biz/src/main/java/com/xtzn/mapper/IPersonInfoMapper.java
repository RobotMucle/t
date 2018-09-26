package com.xtzn.mapper;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月16日]
 */

import com.xtzn.mapper.entity.PersonInfo;
import com.xtzn.vo.DataRequest;
import com.xtzn.vo.LuaReuqest;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IPersonInfoMapper {

    public List<Map<String, Object>> selectPersonInfoByPageIndex(DataRequest dataRequest);

    public PersonInfo selectPersonInfoById(@Param("id") Integer id);

    public int deleteById(@Param("id") Integer id);

    public int deleteBatchById(@Param("list") List<Integer> list);

    public int insertPersonInfo(PersonInfo personInfo);

    public int updatePersonInfoContent(PersonInfo personInfo);

    public Integer selectCount(DataRequest dataRequest);

    public int deleteBatchByCondition(DataRequest dataRequest);

    public List<PersonInfo> selectPersonInfoByLua(LuaReuqest luaReuqest);

    public List<PersonInfo> selectPersonInfoByFileName(@Param("fileName") String fileName, @Param("userId") Integer userId);

    public int insertBatchPersonInfo(@Param("list") List<PersonInfo> list);

}
