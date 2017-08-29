package com.whj.dao;

import com.whj.domain.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by wuhaijun on 2017/8/28.
 */
public interface MongoDao extends MongoRepository<MongoUser,String> {

    MongoUser findById(int id);

    void deleteById(int id);
}
