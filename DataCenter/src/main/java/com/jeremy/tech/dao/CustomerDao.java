package com.jeremy.tech.dao;

import com.jeremy.tech.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by jeremysong on 5/29/2017.
 */
@Service
public class CustomerDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public boolean insertCustomer(Customer customer) {
        try {
            mongoTemplate.insert(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Customer findCustomerById(String id) {
        Criteria criteria = new Criteria();
        criteria.where("id").is(id);
        Query query = new Query(criteria);
        return mongoTemplate.findOne(query, Customer.class);
    }

    public Customer findCustomerByEmail(String email) {
        Criteria criteria = new Criteria();
        criteria.where("email").is(email);
        Query query = new Query(criteria);
        return mongoTemplate.findOne(query, Customer.class);
    }

    public List<Customer> findCustomerByConditions(String firstName, String middleName, String lastName,
                                                   String address, int age, int sex, int level) {
        boolean isConditionAllTrue = true;
        Criteria criteria = new Criteria();
        if (null != firstName) {
            criteria.where("firstName").regex(firstName);
            isConditionAllTrue = false;
        }
        if (null != middleName) {
            criteria.where("middleName").regex(middleName);
            isConditionAllTrue = false;
        }
        if (null != lastName) {
            criteria.where("lastName").regex(lastName);
            isConditionAllTrue = false;
        }
        if (null != address) {
            criteria.where("address").regex(address);
            isConditionAllTrue = false;
        }
        if (age >= 0) {
            criteria.where("age").is(age);
            isConditionAllTrue = false;
        }
        if (sex == 0 || sex == 1) {
            criteria.where("sex").is(sex);
            isConditionAllTrue = false;
        }
        if (level >= 0) {
            criteria.where("level").is(level);
            isConditionAllTrue = false;
        }

        Query query = new Query(criteria);
        if (isConditionAllTrue) {
            return Collections.emptyList();
        } else {
            return mongoTemplate.find(query, Customer.class);
        }
    }

    public List<Customer> getCustombyAge(int minAge, int maxAge) {
        Criteria criteria = new Criteria();
        if (minAge >= 0 && maxAge >= 0) {
            if (minAge == maxAge) {
                criteria.where("age").is(minAge);
            } else {
                criteria.where("age").lte(maxAge).gte(minAge);
            }
            Query query = new Query(criteria);
            return mongoTemplate.find(query, Customer.class);
        }
        return Collections.emptyList();
    }
}
