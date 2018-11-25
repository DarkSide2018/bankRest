package com.bankrest.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {
    private static Properties properties = new Properties();

    static {
        String configFileName = System.getProperty("application.properties");

        if (configFileName == null) {
            configFileName = "application.properties";
        }
        loadConfig(configFileName);
    }

    public static void loadConfig(String fileName) {
        if (fileName == null) {

        } else {
            try {
                final InputStream fis = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
                properties.load(fis);

            } catch (IOException ioe) {

            }
        }

    }

    public static String getStringProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            value = System.getProperty(key);
        }
        return value;
    }

    public static int getIntegerProperty(String key, int defaultVal) {
        String valueStr = getStringProperty(key);
        if (valueStr == null) {
            return defaultVal;
        } else {
            try {
                return Integer.parseInt(valueStr);

            } catch (Exception e) {

                return defaultVal;
            }
        }
    }
}
