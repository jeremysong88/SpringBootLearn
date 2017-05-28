package com.jeremy.tech.entity;

//import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jeremysong on 5/28/2017.
 */
//@Document(collection = "city")
public class City {
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
