package com.xtzn.service;

import com.xtzn.mapper.entity.PhoneList;
import com.xtzn.vo.DataRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月18日]
 */
public interface IPhoneListService {

    public List<PhoneList> selectPhoneListByPage(DataRequest dataRequest);

    public PhoneList selectPhoneListById(Integer id);

    public int deleteById(Integer id);

    public int deleteBatchById(List<Integer> list);

    public int insertBatchPhoneList(List<String> list, Integer userId);

    public int updatePhoneList(PhoneList phoneList);

    public Integer selectCount(DataRequest dataRequest);

    public List<String> selectPhoneCode(PhoneList phoneList);

    public int insertPhoneListByLua(PhoneList phoneList);

    public int updatePhoneListByLua(PhoneList phoneList);
}
