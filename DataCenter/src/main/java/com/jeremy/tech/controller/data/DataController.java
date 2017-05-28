package com.jeremy.tech.controller.data;

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

    @RequestMapping("/getData")
    @ResponseBody
    public Map<String, Object> getTestData() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("name", "Spring Boot");
        resultMap.put("function", "returns a json data");
        resultMap.put("data", new Date());
        return resultMap;
    }
}
