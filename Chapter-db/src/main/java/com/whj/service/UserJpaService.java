package com.whj.service;

import com.whj.domain.User;
import org.springframework.data.domain.Page;
import java.util.List;

/**
 * Created by wuhaijun on 2017/8/22.
 */
public interface UserJpaService {

    List<User> findAll();

    User findByIdAndName(int id,String name);

    Page<User> findForPage(int page);

    User findTopByOrderByAgeDesc();

    List<User> findTop3ByOrderByAgeDesc();

    User findByName(String name);

    User findByAge(int age);

    void save(User user);
}
