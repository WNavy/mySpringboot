package com.whj.springboot;

import com.whj.domain.MongoUser;
import com.whj.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wuhaijun on 2017/8/28.
 */
@RestController
@RequestMapping(value = "/mongo")
public class MongoController {

    @Autowired
    private MongoService mongoService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public void insert(@RequestParam("id")int id,@RequestParam("age") int age,@RequestParam("name") String name){
        MongoUser mongoUser = new MongoUser(id,age,name);
        mongoService.insert(mongoUser);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<MongoUser> findAll(){
        return mongoService.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public MongoUser findById(@PathVariable("id") int id){
        return mongoService.findById(id);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id){
         mongoService.delete(id);
    }
}
