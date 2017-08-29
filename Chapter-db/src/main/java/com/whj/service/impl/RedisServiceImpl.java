package com.whj.service.impl;

import com.whj.dao.RedisDao;
import com.whj.domain.Customer;
import com.whj.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuhaijun on 2017/8/24.
 */
@Service("redisService")
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisDao redisDao;

    @Override
    public void insert(Customer customer) {
        redisDao.insert(customer);
    }

    @Override
    public Customer findById(String id) {
        return redisDao.findById(id);
    }

    @Override
    public void delete(String key) {
        redisDao.delete(key);
    }
}
