package org.example.Utils;

import org.openqa.selenium.devtools.v85.browser.model.WindowID;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.util.Properties;

public class Hooks {
    public static Properties properties;
   @BeforeSuite
    public void initProperties()
    {
        properties= new Properties();

        try {
            properties.load(new FileInputStream("src/test/java/Configurations/config.properties"));

        } catch (IOException e) {
            System.out.println("Exception while reading config file"+e.getMessage());
            e.printStackTrace();

        }
    }
}
