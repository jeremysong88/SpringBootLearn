package com.jeremy.tech.service.weather.forecast;

import com.alibaba.fastjson.JSONObject;
import com.jeremy.tech.utils.RequestMethodConstructor;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeremysong on 5/24/2017.
 */
@Service
public class WeatherServiceImpl implements IWeatherService {

    @Value("${weather.service.appcode}")
    private String appCode;

    @Value("${weather.service.find.location.code.uri}")
    private String locationUri;

    @Override
    public JSONObject queryAreaIdByAreaName(String areaName) {
        try {
            RequestMethodConstructor rmc = new RequestMethodConstructor();
            rmc.createGetMethod(locationUri);
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("area", areaName));
            rmc.setParameters(pairs);
            addAuthorization(rmc);
            rmc.execute();
            String resp = rmc.getResponseAsString();
            return JSONObject.parseObject(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JSONObject queryWeatherByScenicSpotName(String ScenicSpotName, String need3HourForecast, String needAlarm, String needHourData, String needIndex, String needMoreDay) {
        return null;
    }

    @Override
    public JSONObject query7DaysWeatherByIP(String ip, String need3HourForecast, String needAlarm, String needHourData, String needIndex, String needMoreDay) {
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
    public JSONObject query7DaysWeatherByAreaName(String areaName, String need3HourForecast, String needAlarm, String needHourData, String needIndex, String needMoreDay) {
        return null;
    }

    @Override
    public JSONObject query7DaysWeatherByAreaId(String areaId, String need3HourForecast, String needAlarm, String needHourData, String needIndex, String needMoreDay) {
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


    private void addAuthorization(RequestMethodConstructor rmc) {
        rmc.setHeader("Authorization", appCode);
    }
}
