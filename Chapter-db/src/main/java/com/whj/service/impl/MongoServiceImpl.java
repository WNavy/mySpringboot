package com.whj.service.impl;

import com.whj.dao.MongoDao;
import com.whj.domain.MongoUser;
import com.whj.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by wuhaijun on 2017/8/28.
 */
@Service("mongoService")
public class MongoServiceImpl implements MongoService {

    @Autowired
    private MongoDao mongoDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<MongoUser> findAll() {
        return mongoDao.findAll();
    }

    @Override
    public void insert(MongoUser mongoUser) {
        mongoDao.insert(mongoUser);
    }

    @Override
    public MongoUser findById(int id) {
        return mongoDao.findById(id);
    }

    @Override
    public void delete(int id) {
        mongoDao.deleteById(id);
    }


}
