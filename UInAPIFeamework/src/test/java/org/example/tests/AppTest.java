package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.DriverFactory.Browser;
import org.example.DriverFactory.WebDriverFactory;

import org.example.Utils.RetryListner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test(retryAnalyzer = RetryListner.class)
    public void shouldAnswerWithTrue() {


        Browser browser =  WebDriverFactory.getBrowser("edge");
        WebDriver driver =  browser.getDriver();
        driver.get("https://google.com");
        System.out.println("Title"+ driver.getTitle());

        assertEquals(driver.getTitle(),"Google");
        assertTrue(driver.getTitle().compareToIgnoreCase("google")==0);
        driver.close();
    }
}
