package org.example.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class EdgeBrowser implements Browser{

    private WebDriver driver;
    @Override
    public WebDriver getDriver() {
        FirefoxOptions options  = new FirefoxOptions();
        options.addArguments("--incognito");
        options.addArguments("--headless");
        options.addArguments("--start-maximized");
        return(new FirefoxDriver(options));
    }

}
