package com.jeremy.tech.controller;

import com.jeremy.tech.dao.RefTestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeremysong on 8/24/2017.
 */
@RestController
@RequestMapping("/dbref/test")
public class DbRefTestController {

    @Autowired
    private RefTestDao testDao;

    public Map<String, Object> doTest() {
        Map<String, Object> rtnMap = new HashMap<>();
        testDao.test();
        return rtnMap;
    }

}
