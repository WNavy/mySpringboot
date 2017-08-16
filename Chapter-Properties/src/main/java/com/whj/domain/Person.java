package com.whj.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by wuhaijun on 2017/8/8.
 */
@Component
public class Person {

    @Value("${whj.name}")
    private String name;

    @Value("${whj.age}")
    private int age;

    public String toString(){
        return name + ":" + age;
    }
}
