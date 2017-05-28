package com.jeremy.tech.dao;

import com.jeremy.tech.component.MyMongoTemplate;
import com.jeremy.tech.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by jeremysong on 5/29/2017.
 */
@Service
public class CityDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MyMongoTemplate template;

    @Autowired
    private MongoDbFactory mongoDbFactory;

    @Autowired
    private MongoDbFactory factory;

    public void insertCity(City city) {
        mongoTemplate.insert(city);
    }

    /**
     * 使用自定义的MongoTemplate进行MongoDB操作
     *
     * @param city
     * @see com.jeremy.tech.component.MyMongoTemplate#MyMongoTemplate(MongoTemplate)  了解如何自定义MongoTemplate
     */
    public void insertTemplate(City city) {
        template.getMongoTemplate().insert(city);
    }

}
