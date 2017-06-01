package com.jeremy.tech.controller.data;

import com.jeremy.tech.service.simulation.CustomerSimulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeremysong on 6/1/2017.
 */
@RestController
@RequestMapping("/simulation")
public class SimulationController {

    @Autowired
    private CustomerSimulator customerSimulator;

    @RequestMapping("/createCustomerInfoZHCN")
    public Map<String, Object> createCustomerInfoZHCN(@RequestParam(value = "count") int count) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            customerSimulator.createCustomerInfoZHCN(count);
            resultMap.put("rtnCode", "000000");
            resultMap.put("rtnMsg", "SUCCESS");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("rtnCode", "999999");
            resultMap.put("rtnMsg", "ERROR");
            resultMap.put("reason", e.getMessage());
        }
        return resultMap;
    }
}
