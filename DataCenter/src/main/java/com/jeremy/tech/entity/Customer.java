package com.jeremy.tech.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jeremysong on 5/29/2017.
 */
@Document(collection = "customer")
public class Customer {

    /**
     * ID字段定义为String类型时，Mongo使用自己控制的自增ID，类型为int时，ID完全由用户维护
     *
     * @see org.springframework.data.mongodb.core.MongoTemplate#insert(Object)
     */
    private String id;

    private String firstName;

    private String firstNameCN;

    private String middleName;

    private String lastName;

    private String lastNameCN;

    @Indexed(unique = true)
    private String email;

    private String address;

    private int age;

    private int sex;

    private int level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstNameCN() {
        return firstNameCN;
    }

    public void setFirstNameCN(String firstNameCN) {
        this.firstNameCN = firstNameCN;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastNameCN() {
        return lastNameCN;
    }

    public void setLastNameCN(String lastNameCN) {
        this.lastNameCN = lastNameCN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
