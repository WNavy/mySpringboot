package com.whj.service.impl;

import com.whj.dao.CityJdbcDao;
import com.whj.domain.City;
import com.whj.service.CityJdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuhaijun on 2017/8/21.
 */
@Service("cityJdbcService")
public class CityJdbcServiceImpl implements CityJdbcService {

    @Autowired
    private CityJdbcDao cityJdbcDao;

    @Override
    public List<City> findAll() {
        return cityJdbcDao.findAll();
    }

    @Override
    public City findById(int id) {
        return cityJdbcDao.findById(id);
    }

    @Override
    public int update(City city) {
        return cityJdbcDao.update(city);
    }

    @Override
    public int insert(City city) {
        return cityJdbcDao.insert(city);
    }

    @Override
    public int delete(int id) {
        return cityJdbcDao.delete(id);
    }
}
