package com.xtzn.click.service.impl;

import com.xtzn.click.mapper.IHeaderMapper;
import com.xtzn.click.mapper.entity.Header;
import com.xtzn.click.service.IHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeaderServiceImpl implements IHeaderService {

    @Autowired
    private IHeaderMapper headerDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年3月24日]
     */
    @Override
    public List<Header> selectHeader() {

        return headerDao.selectHeader();
    }


}
