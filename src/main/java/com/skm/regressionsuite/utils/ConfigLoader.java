package com.skm.regressionsuite.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private static Properties properties;

    // Static block to load properties when class is accessed
    static {
        try {
            String configFilePath = "src/test/resources/config.properties";
            FileInputStream fis = new FileInputStream(configFilePath);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file");
        }
    }

    // Method to get property values
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Overloaded method to return property values with default
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
