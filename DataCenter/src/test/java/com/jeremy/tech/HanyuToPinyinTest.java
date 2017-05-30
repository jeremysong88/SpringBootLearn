package com.jeremy.tech;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;

/**
 * Created by jeremysong on 5/30/2017.
 */
public class HanyuToPinyinTest {
    @Test
    public void TestOne() throws BadHanyuPinyinOutputFormatCombination {
        String[] pinyin = PinyinHelper.toHanyuPinyinStringArray('宋');
        StringBuffer sb = new StringBuffer();
        for (String str : pinyin) {
            sb.append(str);
        }
        System.out.println(sb.toString());

        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
        format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);

        sb.setLength(0);
        pinyin = PinyinHelper.toHanyuPinyinStringArray('宋', format);
        for (String str : pinyin) {
            sb.append(str);
        }
        System.out.println(sb.toString());
    }
}
