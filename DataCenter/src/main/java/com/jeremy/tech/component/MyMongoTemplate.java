package com.jeremy.tech.component;

import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * 自定义MongoTemplate的用法
 * Created by jeremysong on 5/28/2017.
 */
@Component
public class MyMongoTemplate {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public MyMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
        // 下面对mongoTemplate的设置可以略过
        this.mongoTemplate.setWriteConcern(WriteConcern.MAJORITY);
        this.mongoTemplate.setReadPreference(ReadPreference.primary());
    }

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }
}
