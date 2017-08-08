package com.whj.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by wuhaijun on 2017/8/7.
 */

@ConfigurationProperties(prefix = "student")
@Component
public class Student {

    private String name;

    private int age;

    private String sex;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String toString(){
        return name + "-" + age + "-" + sex;
    }
}
