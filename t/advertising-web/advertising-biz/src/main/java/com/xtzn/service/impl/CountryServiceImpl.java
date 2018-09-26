package com.xtzn.service.impl;

import com.xtzn.mapper.ICountryMapper;
import com.xtzn.mapper.entity.Country;
import com.xtzn.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月12日]
 */
@Service
public class CountryServiceImpl implements ICountryService {

    @Autowired
    private ICountryMapper countryDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public List<Country> selectCountryByPageIndex(Integer skips, Integer pageSize) {

        return countryDao.selectCountryByPageIndex(skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public Country selectCountryById(Integer id) {

        return countryDao.selectCountryById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateCountryContent(String name, Integer id) {

        return countryDao.updateCountryContent(name, id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int updateCountryStatus(Byte status, Integer id) {

        return countryDao.updateCountryStatus(status, id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int deleteById(Integer id) {

        return countryDao.deleteById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int deleteBatchById(List<Integer> list) {

        return countryDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月12日]
     */
    @Override
    public int insertCountry(Country country) {

        return countryDao.insertCountry(country);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月13日]
     */
    @Override
    public List<Country> selectUsingCountry() {

        return countryDao.selectUsingCountry();
    }


    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public Integer selectCount() {

        return countryDao.selectCount();
    }

}
