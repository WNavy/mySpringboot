package com.whj.service.impl;

import com.whj.domain.City;
import com.whj.mapper.CityMapper;
import com.whj.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wuhaijun on 2017/8/8.
 */
@Service("cityService")
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public City findById(int id) {
        City city = cityMapper.findById(id);
        return city;
    }

    @Override
    public void mofidy(City city) {
        cityMapper.modify(city);
    }

    @Override
    public void delete(int id) {
        cityMapper.delete(id);
    }
}
