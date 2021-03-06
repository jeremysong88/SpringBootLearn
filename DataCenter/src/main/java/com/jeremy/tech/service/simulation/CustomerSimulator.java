package com.jeremy.tech.service.simulation;

import com.jeremy.tech.dao.CustomerDao;
import com.jeremy.tech.entity.Customer;
import com.jeremy.tech.utils.NameCreator;
import com.jeremy.tech.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by jeremysong on 6/1/2017.
 */
@Service
public class CustomerSimulator implements ICustomerSimulation {

    @Autowired
    private CustomerDao customerDao;

    private final int timeoutMillis = 5000;

    @Override
    public void createCustomerInfoZHCN(int count) {
        Random random = new Random(System.currentTimeMillis());
        long start = System.currentTimeMillis();
        int added = 0;
        while (added < count) {
            try {
                Customer customer = new Customer();
                String firstName = NameCreator.getInstance().getFirstNameByZHCN();
                String lastName = NameCreator.getInstance().getLastNameByZHCN();
                String firstNamePy = StringUtil.getPinYin(firstName);
                String lastNamePy = StringUtil.getPinYin(lastName);
                customer.setFirstName(firstNamePy);
                customer.setLastName(lastNamePy);
                customer.setFirstNameCN(firstName);
                customer.setLastNameCN(lastName);
                customer.setEmail(StringUtil.generateRandomEmail(firstNamePy, lastNamePy));

//            customer.setAddress("");
                customer.setAge(random.nextInt(60) + 20);
                customer.setSex(random.nextInt(2));
                customer.setLevel(random.nextInt(8) + 1);
                customerDao.insertCustomer(customer);

                long now = System.currentTimeMillis();
                if (now - start >= timeoutMillis) {
                    System.out.println("Insert customer timeout");
                    break;
                } else {
                    added++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}
