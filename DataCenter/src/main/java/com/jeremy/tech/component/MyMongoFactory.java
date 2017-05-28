package com.jeremy.tech.component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

/**
 * Created by jeremysong on 5/28/2017.
 */
@Component
public class MyMongoFactory {

    private final MongoDbFactory mongoDbFactory;

    @Autowired
    public MyMongoFactory(MongoDbFactory mongo) {
        this.mongoDbFactory = mongo;
    }

    public MongoDbFactory getMongoDbFactory() {
        return mongoDbFactory;
    }
}
