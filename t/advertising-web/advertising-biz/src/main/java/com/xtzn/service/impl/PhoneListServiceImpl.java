package com.xtzn.service.impl;

import com.xtzn.mapper.IPhoneListMapper;
import com.xtzn.mapper.entity.PhoneList;
import com.xtzn.service.IPhoneListService;
import com.xtzn.vo.DataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月18日]
 */
@Service
public class PhoneListServiceImpl implements IPhoneListService {

    @Autowired
    private IPhoneListMapper phoneListDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public List<PhoneList> selectPhoneListByPage(DataRequest dataRequest) {

        return phoneListDao.selectPhoneListByPage(dataRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public PhoneList selectPhoneListById(Integer id) {

        return phoneListDao.selectPhoneListById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public int deleteById(Integer id) {

        return phoneListDao.deleteById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public int deleteBatchById(List<Integer> list) {

        return phoneListDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public int insertBatchPhoneList(List<String> list, Integer userId) {

        return phoneListDao.insertBatchPhoneList(list, userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public int updatePhoneList(PhoneList phoneList) {

        return phoneListDao.updatePhoneList(phoneList);
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

        return phoneListDao.selectCount(dataRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public List<String> selectPhoneCode(PhoneList phoneList) {

        return phoneListDao.selectPhoneCode(phoneList);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public int insertPhoneListByLua(PhoneList phoneList) {

        return phoneListDao.insertPhoneListByLua(phoneList);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月4日]
     */
    @Override
    public int updatePhoneListByLua(PhoneList phoneList) {

        return phoneListDao.updatePhoneListByLua(phoneList);
    }

}
