package com.whj.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuhaijun on 2017/7/29.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String sayHello(){
        return "Hello World";
    }
}
