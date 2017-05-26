package com.jeremy.tech.service.weather.forecast;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by jeremysong on 5/24/2017.
 */
public interface IWeatherService {

    /**
     * 根据地区名称查询地区ID
     *
     * @param areaName 地区名称
     * @return
     */
    JSONObject queryAreaIdByAreaName(String areaName);

    /**
     * 根据景点名称获取天气预报
     *
     * @param ScenicSpotName 景点名称
     * @param need3HourForcast 是否需要当天每3/6小时一次的天气预报列表。1为需要，0为不需要。
     * @param needAlarm 是否需要天气预警。1为需要，0为不需要。
     * @param needHourData 是否需要每小时数据的累积数组。由于本系统是半小时刷一次实时状态，因此实时数组最大长度为48。每天0点长度初始化为0. 1为需要 0为不
     * @param needIndex 是否需要返回指数数据，比如穿衣指数、紫外线指数等。1为返回，0为不返回。
     * @param needMoreDay 是否需要返回7天数据中的后4天。1为返回，0为不返回。
     * @return
     */
    JSONObject queryWeatherByScenicSpotName(String ScenicSpotName, String need3HourForcast, String needAlarm, String needHourData, String needIndex, String needMoreDay);

    /**
     * 根据用户IP查询天气预报
     *
     * @param ip 用户ip
     * @param need3HourForcast 是否需要每小时数据的累积数组。由于本系统是半小时刷一次实时状态，因此实时数组最大长度为48。每天0点长度初始化为0. 1为需要 0为不
     * @param needAlarm 是否需要天气预警。1为需要，0为不需要。
     * @param needHourData 是否需要每小时数据的累积数组。由于本系统是半小时刷一次实时状态，因此实时数组最大长度为48。每天0点长度初始化为0.
     * @param needIndex 是否需要返回指数数据，比如穿衣指数、紫外线指数等。1为返回，0为不返回。
     * @param needMoreDay 是否需要返回7天数据中的后4天。1为返回，0为不返回。
     * @return
     */
    JSONObject query7DaysWeatherByIP(String ip, String need3HourForcast, String needAlarm, String needHourData, String needIndex, String needMoreDay);

    /**
     * 根据地名查询未来15天预报
     *
     * @param areaName
     * @return
     */
    JSONObject query15DaysWeatherByAreaName(String areaName);

    /**
     * 根据地区ID查询未来15天预报
     *
     * @param areaId
     * @return
     */
    JSONObject query15DaysWeatherByAreaId(String areaId);

    /**
     * 根据地名查询未来7天预报
     *
     * @param areaName 地区名称
     * @param need3HourForcast 是否需要每小时数据的累积数组。由于本系统是半小时刷一次实时状态，因此实时数组最大长度为48。每天0点长度初始化为0. 1为需要 0为不
     * @param needAlarm 是否需要天气预警。1为需要，0为不需要。
     * @param needHourData 是否需要每小时数据的累积数组。由于本系统是半小时刷一次实时状态，因此实时数组最大长度为48。每天0点长度初始化为0.
     * @param needIndex 是否需要返回指数数据，比如穿衣指数、紫外线指数等。1为返回，0为不返回。
     * @param needMoreDay 是否需要返回7天数据中的后4天。1为返回，0为不返回。
     * @return
     */
    JSONObject query7DaysWeatherByAreaName(String areaName, String need3HourForcast, String needAlarm, String needHourData, String needIndex, String needMoreDay);

    /**
     * 根据地区ID查询未来7天预报
     *
     * @param areaId 地区ID
     * @param need3HourForcast 是否需要每小时数据的累积数组。由于本系统是半小时刷一次实时状态，因此实时数组最大长度为48。每天0点长度初始化为0. 1为需要 0为不
     * @param needAlarm 是否需要天气预警。1为需要，0为不需要。
     * @param needHourData 是否需要每小时数据的累积数组。由于本系统是半小时刷一次实时状态，因此实时数组最大长度为48。每天0点长度初始化为0.
     * @param needIndex 是否需要返回指数数据，比如穿衣指数、紫外线指数等。1为返回，0为不返回。
     * @param needMoreDay 是否需要返回7天数据中的后4天。1为返回，0为不返回。
     * @return
     */
    JSONObject query7DaysWeatherByAreaId(String areaId, String need3HourForcast, String needAlarm, String needHourData, String needIndex, String needMoreDay);

    /**
     * 根据地名查询未来24小时天气预报
     *
     * @param areaName
     * @return
     */
    JSONObject query24HoursWeatherByAreaName(String areaName);

    /**
     * 根据地区ID查询未来24小时天气预报
     *
     * @param areaId
     * @return
     */
    JSONObject query24HoursWeatherByAreaId(String areaId);

}
