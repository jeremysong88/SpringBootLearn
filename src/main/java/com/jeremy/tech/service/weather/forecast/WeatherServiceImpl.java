package com.jeremy.tech.service.weather.forecast;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by jeremysong on 5/24/2017.
 */
@Service
public class WeatherServiceImpl implements IWeatherService {

    @Value("${weather.service.appcode}")
    private String appCode;

    @Override
    public JSONObject queryAreaIdByAreaName(String areaName) {


        return null;
    }

    @Override
    public JSONObject queryWeatherByScenicSpotName(String ScenicSpotName, String need3HourForcast, String needAlarm, String needHourData, String needIndex, String needMoreDay) {
        return null;
    }

    @Override
    public JSONObject query7DaysWeatherByIP(String ip, String need3HourForcast, String needAlarm, String needHourData, String needIndex, String needMoreDay) {
        return null;
    }

    @Override
    public JSONObject query15DaysWeatherByAreaName(String areaName) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("http://saweather.market.alicloudapi.com/day15?area=" + areaName);
            httpGet.setHeader("Authorization", appCode);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            String resp = EntityUtils.toString(response.getEntity());
            EntityUtils.consume(response.getEntity());
            return JSONObject.parseObject(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JSONObject query15DaysWeatherByAreaId(String areaId) {
        return null;
    }

    @Override
    public JSONObject query7DaysWeatherByAreaName(String areaName, String need3HourForcast, String needAlarm, String needHourData, String needIndex, String needMoreDay) {
        return null;
    }

    @Override
    public JSONObject query7DaysWeatherByAreaId(String areaId, String need3HourForcast, String needAlarm, String needHourData, String needIndex, String needMoreDay) {
        return null;
    }

    @Override
    public JSONObject query24HoursWeatherByAreaName(String areaName) {
        return null;
    }

    @Override
    public JSONObject query24HoursWeatherByAreaId(String areaId) {
        return null;
    }
}
