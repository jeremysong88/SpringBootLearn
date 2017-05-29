package com.jeremy.tech.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jeremysong on 5/28/2017.
 */
@Document(collection = "city")
public class City {

    /**
     * ID字段定义为String类型时，Mongo使用自己控制的自增ID，类型为int时，ID完全由用户维护
     *
     * @see org.springframework.data.mongodb.core.MongoTemplate#insert(Object)
     */
    @Id
    private int id;
    private String county;
    private String province;
    private long population;
    private String city;
    private String postcode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
