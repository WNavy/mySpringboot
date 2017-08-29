package com.whj.springboot;

import com.whj.domain.Customer;
import com.whj.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wuhaijun on 2017/8/24.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public void insert(@RequestParam("id") int id,@RequestParam("firstName") String firstName,
                       @RequestParam("lastName") String lastName){
        Customer customer = new Customer(id,firstName,lastName);
        redisService.insert(customer);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Customer findByKey(@PathVariable("id") String id){
        Customer customer = redisService.findById(id);
        return customer;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id){
        redisService.delete(id);
    }

}
