package com.whj.dao;

import com.whj.domain.Customer;

/**
 * Created by wuhaijun on 2017/8/24.
 */
public interface RedisDao {

    void insert(Customer customer);

    Customer findById(String id);

    void delete(String key);
}
