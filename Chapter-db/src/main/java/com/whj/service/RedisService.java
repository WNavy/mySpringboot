package com.whj.service;

import com.whj.domain.Customer;

/**
 * Created by wuhaijun on 2017/8/24.
 */
public interface RedisService {

    void insert(Customer customer);

    Customer findById(String id);

    void delete(String key);
}
