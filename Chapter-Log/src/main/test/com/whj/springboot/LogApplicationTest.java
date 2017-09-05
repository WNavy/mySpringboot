package com.whj.springboot;

import com.whj.springboot.controller.LogController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wuhaijun on 2017/9/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LogController.class)
public class LogApplicationTest {

    @Autowired
    private LogController logController;

    @Test
    public void getLog(){
        String data = logController.sayHello();
        System.out.println(data);
    }
}
