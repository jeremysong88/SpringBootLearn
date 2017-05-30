package com.jeremy.tech.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

/**
 * Created by jeremysong on 5/30/2017.
 */
public class NameCreator {
    private static NameCreator ourInstance = new NameCreator();

    public static NameCreator getInstance() {
        return ourInstance;
    }

    private NameCreator() {
    }

    private static Properties propertiesZHCNLastName = new Properties();
    private static Properties propertiesZHCHFirstName = new Properties();
    private static Properties propertiesZHHKFullName = new Properties();
    private static Properties propertiesEN_US = new Properties();

    private Random random = new Random();

    private static void initProperties(String file, Properties properties) {
        if (properties != null && properties != null) {
            try (FileInputStream in = new FileInputStream(file)) {
                properties.load(in);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static void initZHCN() {
        String firstNameFile = "name/zh_cn/firstName.dict";
        initProperties(firstNameFile, propertiesZHCHFirstName);
        String lastNameFile = "name/zh_cn/lastName.dict";
        initProperties(lastNameFile, propertiesZHCNLastName);
    }

    private static void initZHHK() {
        String fullNameFile = "name/zh_hk/fullName.dict";
        initProperties(fullNameFile, propertiesZHHKFullName);
    }

    private static void initENUS() {

    }

    static {
        initZHCN();
        initZHHK();
        initENUS();
    }

    public synchronized String getLastNameByZHCN() {
        int randomIndex = random.nextInt(propertiesZHCNLastName.size());
        return propertiesZHCNLastName.getProperty(String.valueOf(randomIndex));
    }

    public synchronized String getFirstNameByZHCN() {
        int randomIndex = random.nextInt(propertiesZHCHFirstName.size());
        return propertiesZHCHFirstName.getProperty(String.valueOf(randomIndex));
    }

    public synchronized String getFullNameByZHCN() {
        return getLastNameByZHCN() + getFirstNameByZHCN();
    }

    public synchronized String getFullNameByZHHK() {
        int randomIndex = random.nextInt(propertiesZHHKFullName.size());
        return propertiesZHHKFullName.getProperty(String.valueOf(randomIndex));
    }
}
