package com.xtzn.service.impl;

import com.xtzn.mapper.IIggListMapper;
import com.xtzn.mapper.entity.IggList;
import com.xtzn.service.IIggListService;
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
public class IggListServiceImpl implements IIggListService {

    @Autowired
    private IIggListMapper iggListDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public List<IggList> selectIggListByPage(DataRequest dataRequest) {
        if ("".equals(dataRequest.getStatus())) {
            dataRequest.setStatus(null);
        }
        return iggListDao.selectIggListByPage(dataRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public IggList selectIggListById(Integer id) {

        return iggListDao.selectIggListById(id);
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

        return iggListDao.deleteById(id);
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

        return iggListDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public int insertBatchIggList(List<String> list, Integer userId) {

        return iggListDao.insertBatchIggList(list, userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public int updateIggList(IggList iggList) {
        if ("".equals(iggList.getStatus())) {
            iggList.setStatus(null);
        }
        return iggListDao.updateIggList(iggList);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月18日]
     */
    @Override
    public int updateIggListForOtherUse(List<Integer> list, String reason) {

        return iggListDao.updateIggListForOtherUse(list, reason);
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
        return iggListDao.selectCount(dataRequest);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月20日]
     */
    @Override
    public Integer selectUsingCount(Integer userId) {

        return iggListDao.selectUsingCount(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public List<IggList> selectIggByLua(Integer userId) {

        return iggListDao.selectIggByLua(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月4日]
     */
    @Override
    public int updateIggResetByLua(IggList iggList) {

        return iggListDao.updateIggResetByLua(iggList);
    }

}
