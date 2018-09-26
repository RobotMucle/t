package com.xtzn.mapper;

import com.xtzn.mapper.entity.PhoneList;
import com.xtzn.vo.DataRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月18日]
 */
public interface IPhoneListMapper {

    public List<PhoneList> selectPhoneListByPage(DataRequest dataRequest);

    public PhoneList selectPhoneListById(@Param("id") Integer id);

    public int deleteById(@Param("id") Integer id);

    public int deleteBatchById(@Param("list") List<Integer> list);

    public int insertBatchPhoneList(@Param("list") List<String> list, @Param("userId") Integer userId);

    public int updatePhoneList(PhoneList phoneList);

    public Integer selectCount(DataRequest dataRequest);

    public List<String> selectPhoneCode(PhoneList phoneList);

    public int insertPhoneListByLua(PhoneList phoneList);

    public int updatePhoneListByLua(PhoneList phoneList);
}
