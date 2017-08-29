package com.whj.dao.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whj.dao.RedisDao;
import com.whj.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wuhaijun on 2017/8/24.
 */
@Repository("redisDao")
public class RedisDaoImpl implements RedisDao {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String KEY_PREFIX = "customer_";

    @Override
    public void insert(Customer customer) {
        String json = JSON.toJSONString(customer);
        stringRedisTemplate.opsForValue().set(KEY_PREFIX + customer.getId(),json);
    }

    @Override
    public Customer findById(String id) {
        String customerStr = stringRedisTemplate.opsForValue().get(KEY_PREFIX + id);
        JSONObject customerJson = JSONObject.parseObject(customerStr);
        Customer customer = JSONObject.toJavaObject(customerJson,Customer.class);
        return customer;
    }

    @Override
    public void delete(String key) {
        stringRedisTemplate.delete(KEY_PREFIX + key);
    }

}
