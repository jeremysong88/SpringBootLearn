package com.jeremy.tech;

import com.jeremy.tech.utils.NameCreator;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

/**
 * Created by jeremysong on 5/30/2017.
 */
public class NameCreatorTest {
    @Test
    public void createName() throws IOException {
        Properties lastNameDict = new Properties();
        lastNameDict.load(new FileInputStream("name/zh_cn/lastName.dict"));
        int lastNameSize = lastNameDict.size();
        Properties firstNameDitc = new Properties();
        firstNameDitc.load(new FileInputStream("name/zh_cn/firstName.dict"));
        int firstNameSize = firstNameDitc.size();

        Random random = new Random();

        String name = lastNameDict.getProperty(String.valueOf(random.nextInt(lastNameSize))) +
                firstNameDitc.getProperty(String.valueOf(random.nextInt(firstNameSize)));
        System.out.println(name);
    }

    @Test
    public void createTest() throws IOException {
//        for (int i = 0; i < 100; i++) {
//            createName();
//        }

        System.out.println(NameCreator.getInstance().getFullNameByZHHK());
    }

}
