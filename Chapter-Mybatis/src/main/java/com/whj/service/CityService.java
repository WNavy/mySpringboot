package com.whj.service;

import com.whj.domain.City;

/**
 * Created by wuhaijun on 2017/8/8.
 */
public interface CityService {

    public City findById(int id);

    public void mofidy(City city);

    public void delete(int id);
}
