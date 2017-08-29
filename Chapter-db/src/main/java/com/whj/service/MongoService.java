package com.whj.service;

import com.whj.domain.MongoUser;
import java.util.List;

/**
 * Created by wuhaijun on 2017/8/28.
 */
public interface MongoService {

    List<MongoUser> findAll();

    void insert(MongoUser mongoUser);

    MongoUser findById(int id);

    void delete(int id);
}
