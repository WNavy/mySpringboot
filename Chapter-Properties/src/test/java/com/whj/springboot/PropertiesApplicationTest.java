package com.whj.springboot;

import com.whj.Application;
import com.whj.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wuhaijun on 2017/8/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class PropertiesApplicationTest {

    @Autowired
    private Student user;

    @Test
    public void getUserInfo(){
        System.out.println(user);
    }
}
