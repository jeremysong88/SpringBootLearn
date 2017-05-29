package com.jeremy.tech.dao;

import com.jeremy.tech.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

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
}
