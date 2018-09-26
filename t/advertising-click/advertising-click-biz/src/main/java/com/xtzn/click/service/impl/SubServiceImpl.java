package com.xtzn.click.service.impl;

import com.xtzn.click.mapper.ISubMapper;
import com.xtzn.click.service.ISubService;
import com.xtzn.click.utils.SubIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubServiceImpl implements ISubService {

    @Autowired
    private ISubMapper subDao;

    @Override
    public int insertSub(String subId) {

        return 0;
    }

    @Override
    public String selectSubId(String subId) {

        return null;
    }

    /**
     * 功能描述: <br>
     * 获得唯一subId
     *
     * @param subId 下标
     * @author zyw
     * @version [版本号, 2018年3月16日]
     */
    @Override
    public String getSubId() {

        while (true) {
            String subId = SubIdUtil.getRandomValue();
            if (subDao.selectSubId(subId) == null) {
                subDao.insertSub(subId);
                return subId;
            }
        }

    }

}
