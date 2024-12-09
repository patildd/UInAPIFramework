package org.example.DriverFactory;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser implements Browser {

    @Override
    public WebDriver getDriver() {
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--headless");
        options.addArguments("--start-maximized");
        return(new ChromeDriver(options));
    }
}
