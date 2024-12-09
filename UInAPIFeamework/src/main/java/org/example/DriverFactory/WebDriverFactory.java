package org.example.DriverFactory;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory{

    Browser getWebDriver(String browserType)
    {
        switch (browserType.trim().toLowerCase())
        {
            case "chrome" :
                return new ChromeBrowser();
            case "firefox":
                return new FirefoxBrowser();
            case "edge":
                return new EdgeBrowser();
            default:
                throw new IllegalArgumentException(" Invalid browser type:" + browserType);
        }
    }
}
