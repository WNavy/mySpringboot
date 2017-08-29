package com.whj.springboot;

import com.whj.domain.User;
import com.whj.service.UserJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wuhaijun on 2017/8/22.
 */
@RestController
@RequestMapping(value = "/jpa")
public class UserJapController {



    @Autowired
    private UserJpaService userJpaService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<User> findAll(){
        return userJpaService.findAll();
    }

    @RequestMapping(value = "/findByIdAndName",method = RequestMethod.GET)
    public User findByIdAndName(@RequestParam("id") int id,@RequestParam("name")String name){
        return userJpaService.findByIdAndName(id,name);
    }

    @RequestMapping(value = "/findForPage",method = RequestMethod.GET)
    public Page<User> findForPage(@RequestParam("page") int page){
        return userJpaService.findForPage(page);
    }

    @RequestMapping(value = "/top",method = RequestMethod.GET)
    public User findTopByOrderByAgeDesc(){
        return userJpaService.findTopByOrderByAgeDesc();
    }

    @RequestMapping(value = "/top3",method = RequestMethod.GET)
    public List<User> findTop3ByOrderByAgeDesc(){
        return userJpaService.findTop3ByOrderByAgeDesc();
    }

    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public User findName(@PathVariable("name") String name){
        return userJpaService.findByName(name);
    }

    @RequestMapping(value = "/customer/{age}",method = RequestMethod.GET)
    public User findAge(@PathVariable("age") int age){
        return userJpaService.findByAge(age);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public void save(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("age") int age){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        userJpaService.save(user);
    }
}
