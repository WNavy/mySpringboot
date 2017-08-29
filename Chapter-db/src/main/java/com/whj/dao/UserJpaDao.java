package com.whj.dao;

import com.whj.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wuhaijun on 2017/8/22.
 */
public interface UserJpaDao extends JpaRepository<User,Integer> {

    User findByIdAndName(int id,String name);

    User findTopByOrderByAgeDesc();

    List<User> findTop3ByOrderByAgeDesc();

    /**
     * 自定义SQL查询
     */
    @Transactional(timeout = 10)
    @Query("select u from User u where name = ?1")
    User findByName(String name);

    @Query("select u from User u where u.age = :age")
    User findByAge(@Param("age") int age);
}
