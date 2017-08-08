package com.whj;

import com.whj.domain.Person;
import com.whj.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by wuhaijun on 2017/7/29.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private Student student;

    @Autowired
    private Person person;

    public static void main (String[] args){
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(student.toString());
        System.out.println(person.toString());
    }
}
