package com.whj.service.impl;

import com.whj.dao.UserJpaDao;
import com.whj.domain.User;
import com.whj.service.UserJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by wuhaijun on 2017/8/22.
 */
@Service("userJpaService")
public class UserJpaServiceImpl implements UserJpaService {

    @Autowired
    private UserJpaDao userJpaDao;

    private static final int pageSize = 2;

    @Override
    public List<User> findAll() {
        return userJpaDao.findAll();
    }

    @Override
    public User findByIdAndName(int id, String name) {
        return userJpaDao.findByIdAndName(id,name);
    }

    @Override
    public Page<User> findForPage(int page) {
        Sort sort = new Sort(Sort.Direction.DESC,"age");
        Pageable pageable = new PageRequest(page,pageSize,sort);
        return userJpaDao.findAll(pageable);
    }

    @Override
    public User findTopByOrderByAgeDesc() {
        return userJpaDao.findTopByOrderByAgeDesc();
    }

    @Override
    public List<User> findTop3ByOrderByAgeDesc() {
        return userJpaDao.findTop3ByOrderByAgeDesc();
    }

    @Override
    public User findByName(String name) {
        return userJpaDao.findByName(name);
    }

    @Override
    public User findByAge(int age) {
        return userJpaDao.findByAge(age);
    }

    @Override
    public void save(User user) {
        userJpaDao. save(user);
    }

}
