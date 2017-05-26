package com.jeremy.tech.controller.data;

import com.alibaba.fastjson.JSONObject;
import com.jeremy.tech.service.weather.forecast.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jeremysong on 5/25/2017.
 */
@RestController
@RequestMapping("/weatherForecast")
public class WeatherForecastController {

    @Autowired
    private IWeatherService weatherService;

    @RequestMapping("/15daysByAreaName")
    public JSONObject query15DaysWeatherByAreaName(@RequestParam("area") String areaName) {
        return weatherService.query15DaysWeatherByAreaName(areaName);
    }

    @RequestMapping("/queryAreaId")
    public JSONObject queryAreaIdByAreaName(@RequestParam("area") String areaName) {
        return weatherService.queryAreaIdByAreaName(areaName);
    }
}
