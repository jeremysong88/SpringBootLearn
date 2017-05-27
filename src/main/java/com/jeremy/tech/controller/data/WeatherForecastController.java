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

    /**
     * 根据地区名称查询未来15天的天气详情
     *
     * @param area 地区名，必选
     * @return
     * @see com.jeremy.tech.service.weather.forecast.WeatherServiceImpl#query15DaysWeatherByAreaName(String)
     */
    @RequestMapping("/15daysByAreaName")
    public JSONObject query15DaysWeatherByAreaName(@RequestParam("area") String area) {
        return weatherService.query15DaysWeatherByAreaName(area);
    }

    /**
     * 根据地区名称查询未来15天的天气详情
     *
     * @param areaid 地区名ID，必选
     * @return
     * @see com.jeremy.tech.service.weather.forecast.WeatherServiceImpl#query15DaysWeatherByAreaId(String)
     */
    @RequestMapping("/15daysByAreaId")
    public JSONObject query15DaysWeatherByAreaId(@RequestParam("areaid") String areaid) {
        return weatherService.query15DaysWeatherByAreaId(areaid);
    }

    /**
     * 根据地区名称查询地区ID
     *
     * @param area 地区名，必选
     * @return
     * @see com.jeremy.tech.service.weather.forecast.WeatherServiceImpl#queryAreaIdByAreaName(String)
     */
    @RequestMapping("/queryAreaId")
    public JSONObject queryAreaIdByAreaName(@RequestParam("area") String area) {
        return weatherService.queryAreaIdByAreaName(area);
    }

    /**
     * 根据景区名称查询天气详情
     * @param area 景区名称，必选
     * @param need3HourForcast 是否需要当天每3/6小时一次的天气预报列表， 可选
     * @param needAlarm 是否需要天气预警，可选
     * @param needHourData 是否需要每小时数据的累积数组，可选
     * @param needIndex 是否需要返回指数数据， 可选
     * @param needMoreDay 是否需要返回7天数据中的后4天，可选
     * @return
     */
    @RequestMapping("/queryBySpot")
    public JSONObject queryWeatherByScenicSpotName(@RequestParam("area") String area,
         @RequestParam(value = "need3HourForcast", required = false, defaultValue = "1") String need3HourForcast,
         @RequestParam(value = "needAlarm", required = false, defaultValue = "1") String needAlarm,
         @RequestParam(value = "needHourData", required = false, defaultValue = "1") String needHourData,
         @RequestParam(value = "needIndex", required = false, defaultValue = "1") String needIndex,
         @RequestParam(value = "needMoreDay", required = false, defaultValue = "1") String needMoreDay) {
        return weatherService.queryWeatherByScenicSpotName(area, need3HourForcast, needAlarm,
                needHourData, needIndex, needMoreDay);
    }

    /**
     *  根据IP查询天气详情
     *
     * @param ip 指定IP，必选
     * @param need3HourForcast 是否需要当天每3/6小时一次的天气预报列表， 可选
     * @param needAlarm 是否需要天气预警，可选
     * @param needHourData 是否需要每小时数据的累积数组，可选
     * @param needIndex 是否需要返回指数数据， 可选
     * @param needMoreDay 是否需要返回7天数据中的后4天，可选
     * @return
     * @see com.jeremy.tech.service.weather.forecast.WeatherServiceImpl#query7DaysWeatherByIP(String, String, String, String, String, String)
     */
    @RequestMapping("/day7ByIp")
    public JSONObject query7DaysWeatherByIP(@RequestParam("ip") String ip,
         @RequestParam(value = "need3HourForcast", required = false, defaultValue = "1") String need3HourForcast,
         @RequestParam(value = "needAlarm", required = false, defaultValue = "1") String needAlarm,
         @RequestParam(value = "needHourData", required = false, defaultValue = "1") String needHourData,
         @RequestParam(value = "needIndex", required = false, defaultValue = "1") String needIndex,
         @RequestParam(value = "needMoreDay", required = false, defaultValue = "1") String needMoreDay) {
        return weatherService.query7DaysWeatherByIP(ip, need3HourForcast, needAlarm, needHourData, needIndex,
                needMoreDay);
    }

    /**
     * 根据地区名称查询未来7天的天气详情
     *
     * @param area 地区名称，必选
     * @param need3HourForcast 是否需要当天每3/6小时一次的天气预报列表， 可选
     * @param needAlarm 是否需要天气预警，可选
     * @param needHourData 是否需要每小时数据的累积数组，可选
     * @param needIndex 是否需要返回指数数据， 可选
     * @param needMoreDay 是否需要返回7天数据中的后4天，可选
     * @return
     * @see com.jeremy.tech.service.weather.forecast.WeatherServiceImpl#query7DaysWeatherByAreaName(String, String, String, String, String, String)
     */
    @RequestMapping("/day7ByArea")
    public JSONObject query7DaysWeatherByAreaName(@RequestParam("area") String area,
             @RequestParam(value = "need3HourForcast", required = false, defaultValue = "1") String need3HourForcast,
             @RequestParam(value = "needAlarm", required = false, defaultValue = "1") String needAlarm,
             @RequestParam(value = "needHourData", required = false, defaultValue = "1") String needHourData,
             @RequestParam(value = "needIndex", required = false, defaultValue = "1") String needIndex,
             @RequestParam(value = "needMoreDay", required = false, defaultValue = "1") String needMoreDay) {
        return weatherService.query7DaysWeatherByAreaName(area, need3HourForcast, needAlarm, needHourData, needIndex, needMoreDay);
    }

    /**
     * 根据地区ID查询未来7天的天气详情
     *
     * @param areaid 地区ID，必选
     * @param need3HourForcast 是否需要当天每3/6小时一次的天气预报列表， 可选
     * @param needAlarm 是否需要天气预警，可选
     * @param needHourData 是否需要每小时数据的累积数组，可选
     * @param needIndex 是否需要返回指数数据， 可选
     * @param needMoreDay 是否需要返回7天数据中的后4天，可选
     * @return
     * @see com.jeremy.tech.service.weather.forecast.WeatherServiceImpl#query7DaysWeatherByAreaId(String, String, String, String, String, String)
     */
    @RequestMapping("/day7ByAreaId")
    public JSONObject query7DaysWeatherByAreaId(@RequestParam("areaid") String areaid,
           @RequestParam(value = "need3HourForcast", required = false, defaultValue = "1") String need3HourForcast,
           @RequestParam(value = "needAlarm", required = false, defaultValue = "1") String needAlarm,
           @RequestParam(value = "needHourData", required = false, defaultValue = "1") String needHourData,
           @RequestParam(value = "needIndex", required = false, defaultValue = "1") String needIndex,
           @RequestParam(value = "needMoreDay", required = false, defaultValue = "1") String needMoreDay) {
        return weatherService.query7DaysWeatherByAreaId(areaid, need3HourForcast, needAlarm, needHourData, needIndex, needMoreDay);
    }

    /**
     * 根据地区名称查询未来24小时天气详情
     *
     * @param area 地区名称，必选
     * @return
     */
    @RequestMapping("/hour24ByArea")
    public JSONObject query24HoursWeatherByAreaName(@RequestParam("area") String area) {
        return weatherService.query24HoursWeatherByAreaName(area);
    }

    /**
     * 根据地区ID查询未来24小时天气详情
     *
     * @param areaid 地区ID，必选
     * @return
     */
    @RequestMapping("/hour24ByAreaId")
    public JSONObject query24HoursWeatherByAreaId(@RequestParam("areaid") String areaid) {
        return weatherService.query24HoursWeatherByAreaId(areaid);
    }
}
