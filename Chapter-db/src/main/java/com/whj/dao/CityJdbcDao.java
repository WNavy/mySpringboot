package com.whj.dao;

import com.whj.domain.City;

import java.util.List;

/**
 * Created by wuhaijun on 2017/8/21.
 */
public interface CityJdbcDao {

    List<City> findAll();

    City findById(int id);

    int update(City city);

    int insert(City city);

    int delete(int id);
}
