package com.xtzn.click.service.impl;

import com.xtzn.click.mapper.ILuminatiMapper;
import com.xtzn.click.mapper.entity.Luminati;
import com.xtzn.click.service.ILuminatiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LuminatiServiceImpl implements ILuminatiService {

    @Autowired
    private ILuminatiMapper luminatiDao;

    @Override
    public Luminati selectByStatus(Integer userId) {

        return luminatiDao.selectByStatus(userId);
    }

}
