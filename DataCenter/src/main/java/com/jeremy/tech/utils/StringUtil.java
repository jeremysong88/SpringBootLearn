package com.jeremy.tech.utils;

import java.util.Random;

/**
 * Created by jeremysong on 5/29/2017.
 */
public class StringUtil {

    public static String generateRandomEmail(String firstName, String lastName) {
        StringBuffer sb = new StringBuffer();
        sb.append(firstName).append(lastName);
        sb.append(generateRandomNumberString(6));
        sb.append("@jeremy.tech.com");
        return sb.toString();
    }

    public static String generateRandomNumberString(int length, long seed) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random(seed);
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String generateRandomNumberString(int length) {
        long seed = System.currentTimeMillis();
        return generateRandomNumberString(length, seed);
    }
}
