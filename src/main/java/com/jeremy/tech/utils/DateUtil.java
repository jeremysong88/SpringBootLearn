package com.jeremy.tech.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jeremysong on 5/21/2017.
 */
public class DateUtil {

    private static DateUtil ourInstance = new DateUtil();

    public static DateUtil getInstance() {
        return ourInstance;
    }

    private DateUtil() {
    }

    public static final String DATE_FORMAT_1 = "YYYY-MM-DD HH:mm:SS";

    /**
     * * 适配*.ftl文件中的${time:datetime}, ${time:date} 类型
     */
    public static final String DATE_FORMAT_DATA_TIME = "MMM d, yyyy h:mm:ss a";
    /**
     * 适配*.ftl文件中的${time:time} 类型
     */
    public static final String DATE_FORMAT_TIME = "h:mm:ss a";

    public String getNowFullString() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_1);
        return sdf.format(new Date());
    }

    public static String getDataString(String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(new Date());
        } catch (Exception e) {
            return "";
        }
    }
}
