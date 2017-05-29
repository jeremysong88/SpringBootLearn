package com.jeremy.tech.controller.data;

import com.jeremy.tech.dao.CustomerDao;
import com.jeremy.tech.entity.Customer;
import com.jeremy.tech.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jeremysong on 5/29/2017.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDao dao;

    @RequestMapping("/insertOne")
    public boolean insertCustomer(@RequestParam(value = "firstName") String firstName,
                                  @RequestParam(value = "middleName", required = false) String middleName,
                                  @RequestParam(value = "lastName") String lastName,
                                  @RequestParam(value = "email", required = false) String email,
                                  @RequestParam(value = "address", required = false) String address,
                                  @RequestParam(value = "age", required = false) int age,
                                  @RequestParam(value = "sex") int sex,
                                  @RequestParam(value = "level", required = false, defaultValue = "0") int level) {

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setMiddleName(middleName);
        customer.setLastName(lastName);
        if (email == null || email.isEmpty()) {
            customer.setEmail(StringUtil.generateRandomEmail(firstName, lastName));
        } else {
            customer.setEmail(email);
        }
        customer.setAddress(address);
        customer.setAge(age);
        customer.setSex(sex);
        customer.setLevel(level);
        return dao.insertCustomer(customer);
    }
}
