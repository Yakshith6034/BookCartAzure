package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

 

public class configreader {

 

    private static Properties properties;

 

    static {

        properties = new Properties();

        try {

            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");

            properties.load(fis);

            fis.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

 

    public static String getProperty(String key) {

        return properties.getProperty(key);

    }

}

