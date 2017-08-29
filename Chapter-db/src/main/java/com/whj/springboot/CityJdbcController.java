package com.whj.springboot;

import com.whj.domain.City;
import com.whj.service.CityJdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by wuhaijun on 2017/8/21.
 */
@RestController
@RequestMapping(value = "/jdbc")
public class CityJdbcController {

    @Autowired
    private CityJdbcService cityJdbcService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<City> findAll(){
        return cityJdbcService.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public City findById(@PathVariable("id") int id){
        return cityJdbcService.findById(id);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public int update(@RequestParam(value = "id",required = true) int id, @RequestParam(value = "name",required = true) String name){
        City city = new City();
        city.setId(id);
        city.setCityName(name);
        return cityJdbcService.update(city);
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insert(@RequestParam(value = "provinceId") int provinceId,@RequestParam(value = "cityName") String cityName){
        City city = new City();
        city.setProvinceId(provinceId);
        city.setCityName(cityName);
        return cityJdbcService.insert(city);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public int delete(@RequestParam(value = "id") int id){
        return cityJdbcService.delete(id);
    }

}
