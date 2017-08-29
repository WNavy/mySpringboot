package com.whj.mapper;

import com.whj.domain.City;
import org.apache.ibatis.annotations.Param;
/**
 * Created by wuhaijun on 2017/8/8.
 */

public interface CityMapper {

    City findById(@Param("id") int id);

    void modify(City city);

    void delete(@Param("id")int id);
}
