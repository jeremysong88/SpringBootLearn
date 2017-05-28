package com.jeremy.tech.service.weather.forecast;

import com.alibaba.fastjson.JSONObject;
import com.jeremy.tech.utils.RequestMethodConstructor;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
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
    @Value("${weather.service.query.area-to-id}")
    private String queryAreaToId;
    @Value("${weather.service.query.spot-to-weather}")
    private String queryBySpotUri;
    @Value("${weather.service.query.ip-to-weather}")
    private String queryByIpUri;
    @Value("${weather.service.query.day15}")
    private String query15DayUri;
    @Value("${weather.service.query.area-to-weather}")
    private String query7DayByAreaUri;
    @Value("${weather.service.query.hour24}")
    private String query24HourUri;
    @Value("${weather.service.query.gps}")
    private String queryByGpsUri;

    @Override
    public JSONObject queryAreaIdByAreaName(String area) {
        try {
            RequestMethodConstructor rmc = new RequestMethodConstructor();
            rmc.createGetMethod(queryAreaToId);
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("area", area));
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
    public JSONObject queryWeatherByScenicSpotName(String area, String need3HourForecast,
                                                   String needAlarm, String needHourData, String needIndex, String needMoreDay) {
        try {
            RequestMethodConstructor rmc = new RequestMethodConstructor();
            rmc.createGetMethod(queryBySpotUri);
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("area", area));
            pairs.add(new BasicNameValuePair("need3HourForcast", need3HourForecast));
            pairs.add(new BasicNameValuePair("needAlarm", needAlarm));
            pairs.add(new BasicNameValuePair("needHourData", needHourData));
            pairs.add(new BasicNameValuePair("needIndex", needIndex));
            pairs.add(new BasicNameValuePair("needMoreDay", needMoreDay));
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
    public JSONObject query7DaysWeatherByIP(String ip, String need3HourForecast, String needAlarm,
                                            String needHourData, String needIndex, String needMoreDay) {
        try {
            RequestMethodConstructor rmc = new RequestMethodConstructor();
            rmc.createGetMethod(queryByIpUri);
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("ip", ip));
            pairs.add(new BasicNameValuePair("need3HourForcast", need3HourForecast));
            pairs.add(new BasicNameValuePair("needAlarm", needAlarm));
            pairs.add(new BasicNameValuePair("needHourData", needHourData));
            pairs.add(new BasicNameValuePair("needIndex", needIndex));
            pairs.add(new BasicNameValuePair("needMoreDay", needMoreDay));
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
    public JSONObject query15DaysWeatherByAreaName(String area) {
            try {
                RequestMethodConstructor rmc = new RequestMethodConstructor();
                rmc.createGetMethod(query15DayUri);
                List<NameValuePair> pairs = new ArrayList<>();
                pairs.add(new BasicNameValuePair("area", area));
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
    public JSONObject query15DaysWeatherByAreaId(String areaid) {
        try {
            RequestMethodConstructor rmc = new RequestMethodConstructor();
            rmc.createGetMethod(query15DayUri);
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("areaid", areaid));
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
    public JSONObject query7DaysWeatherByAreaName(String area, String need3HourForecast,
                                                  String needAlarm, String needHourData, String needIndex, String needMoreDay) {
        try {
            RequestMethodConstructor rmc = new RequestMethodConstructor();
            rmc.createGetMethod(query7DayByAreaUri);
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("area", area));
            pairs.add(new BasicNameValuePair("need3HourForcast", need3HourForecast));
            pairs.add(new BasicNameValuePair("needAlarm", needAlarm));
            pairs.add(new BasicNameValuePair("needHourData", needHourData));
            pairs.add(new BasicNameValuePair("needIndex", needIndex));
            pairs.add(new BasicNameValuePair("needMoreDay", needMoreDay));
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
    public JSONObject query7DaysWeatherByAreaId(String areaid, String need3HourForecast, String needAlarm,
                                                String needHourData, String needIndex, String needMoreDay) {
        try {
            RequestMethodConstructor rmc = new RequestMethodConstructor();
            rmc.createGetMethod(query7DayByAreaUri);
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("areaid", areaid));
            pairs.add(new BasicNameValuePair("need3HourForcast", need3HourForecast));
            pairs.add(new BasicNameValuePair("needAlarm", needAlarm));
            pairs.add(new BasicNameValuePair("needHourData", needHourData));
            pairs.add(new BasicNameValuePair("needIndex", needIndex));
            pairs.add(new BasicNameValuePair("needMoreDay", needMoreDay));
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
    public JSONObject query24HoursWeatherByAreaName(String area) {
        try {
            RequestMethodConstructor rmc = new RequestMethodConstructor();
            rmc.createGetMethod(query24HourUri);
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("area", area));
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
    public JSONObject query24HoursWeatherByAreaId(String areaid) {
        try {
            RequestMethodConstructor rmc = new RequestMethodConstructor();
            rmc.createGetMethod(query24HourUri);
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("areaid", areaid));
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


    private void addAuthorization(RequestMethodConstructor rmc) {
        rmc.setHeader("Authorization", appCode);
    }
}
