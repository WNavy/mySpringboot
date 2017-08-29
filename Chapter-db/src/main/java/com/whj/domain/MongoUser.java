package com.whj.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by wuhaijun on 2017/8/28.
 */
@Document
public class MongoUser {

    @Id
    private int id;

    private int age;

    private String name;

    public MongoUser(){}

    public MongoUser(int id,int age,String name){
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
