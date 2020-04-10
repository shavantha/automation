package SpecBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class GlobalVariables {

    public static String getGlobalVariables(String key) throws java.io.IOException {
        Properties properties =new Properties();
        FileInputStream fileInputStream=new FileInputStream("/Users/shavanthaweerasinghe/projects/training/training/src/test/resources/resource.properties");
        properties.load(fileInputStream);
        return properties.getProperty(key);

    }
}
