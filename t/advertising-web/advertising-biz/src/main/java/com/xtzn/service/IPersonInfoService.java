package com.xtzn.service;

import com.xtzn.mapper.entity.PersonInfo;
import com.xtzn.vo.DataRequest;
import com.xtzn.vo.LuaReuqest;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月16日]
 */
public interface IPersonInfoService {

    public List<Map<String, Object>> selectPersonInfoByPageIndex(DataRequest dataRequest);

    public PersonInfo selectPersonInfoById(Integer id);

    public int deleteById(Integer id);

    public int deleteBatchById(List<Integer> list);

    public int insertPersonInfo(PersonInfo personInfo);

    public int updatePersonInfoContent(PersonInfo personInfo);

    public Integer selectCount(DataRequest dataRequest);

    public int deleteBatchByCondition(DataRequest dataRequest);

    public List<PersonInfo> selectPersonInfoByLua(LuaReuqest luaReuqest);

    public List<PersonInfo> selectPersonInfoByFileName(String fileName, Integer userId);

    public int insertBatchPersonInfo(List<PersonInfo> list);
}
