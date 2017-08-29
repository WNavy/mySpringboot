package com.whj.controller;

import com.whj.domain.City;
import com.whj.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuhaijun on 2017/8/8.
 */
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public City findById(@RequestParam(value = "id",required = true) int id){
        City city = cityService.findById(id);
        return city;
    }

    @RequestMapping(value = "/modify",method = RequestMethod.PUT)
    public void modifyById(@RequestParam(value = "id",required = true) int id,
                           @RequestParam(value = "cityName",required = false) String cityName,
                           @RequestParam(value = "description",required = false) String description){
        City city = new City();
        city.setId(id);
        city.setCityName(cityName);
        city.setDescription(description);
        cityService.mofidy(city);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public void delete(@RequestParam(value = "id",required = true) int id){
        cityService.delete(id);
    }
}
