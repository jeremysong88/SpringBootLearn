package com.jeremy.tech.controller.data;

import com.jeremy.tech.component.MyMongoFactory;
import com.jeremy.tech.component.MyMongoTemplate;
import com.jeremy.tech.dao.CityDao;
import com.jeremy.tech.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeremysong on 5/21/2017.
 */
@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private MyMongoFactory mongoFactory;

    @Autowired
    private CityDao cityDao;

    @RequestMapping("/getData")
    @ResponseBody
    public Map<String, Object> getTestData() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("name", "Spring Boot");
        resultMap.put("function", "returns a json data");
        resultMap.put("data", new Date());
        return resultMap;
    }

    @RequestMapping("/insertCity")
    public String insertCity() {
        City city = new City();
        city.setCity("xian");
        city.setCounty("China");
        city.setProvince("Shaanxi");
        cityDao.insertCity(city);
        return "SUCCESS";
    }

    @RequestMapping("/insertTemplate")
    public String insertTemplate() {
        City city = new City();
        city.setCity("Wuxi");
        city.setCounty("China");
        city.setProvince("Shaanxi");
        city.setId(2);
        cityDao.insertTemplate(city);
        return "SUCCESS";
    }
}
