package com.jeremy.tech.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

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

    public static String getPinYin(String chineseStr) throws BadHanyuPinyinOutputFormatCombination {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        return PinyinHelper.toHanYuPinyinString(chineseStr, format, null, false);
    }
}
