package com.whj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by wuhaijun on 2017/7/29.
 */
@SpringBootApplication
@EnableScheduling //启用调度任务
public class Application {


    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
