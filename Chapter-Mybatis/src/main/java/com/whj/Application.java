package com.whj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by wuhaijun on 2017/7/29.
 */
@SpringBootApplication
//mapper接口类扫描包配置
@MapperScan("com.whj.mapper")
public class Application {

    public static void main (String[] args){
        SpringApplication.run(Application.class,args);
    }

}
