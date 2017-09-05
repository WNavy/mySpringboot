package com.whj.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuhaijun on 2017/9/4.
 */
@RestController
public class LogController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String sayHello(){
        //日志级别从低到高 TRACE<DEBUG<INFO<WARN<ERROR
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info {}","[info测试]");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
        return "Hello";
    }
}
