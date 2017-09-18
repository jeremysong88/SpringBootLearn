package com.jeremy.tech.dao;

import com.jeremy.tech.entity.City;
import com.jeremy.tech.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by jeremysong on 8/24/2017.
 */
@Service
public class RefTestDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void test() {
        Person person = new Person();
        person.setName("A");
        person.setAge("18");
        person.setSex("M");
        City city = new City();
        city.setCity("HangZhou");
        city.setCounty("China");
        person.setCity(new City());


        mongoTemplate.save(person);
    }
}
