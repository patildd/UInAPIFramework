package org.example.Utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import javax.tools.Diagnostic;
import java.lang.module.Configuration;
import java.sql.Struct;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WaitUtils {
    WebDriver driver;
    Wait<WebDriver> wait;

    public WaitUtils(WebDriver driver)
    {
        this.driver = driver;

        wait = new FluentWait<WebDriver>(driver)
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofSeconds(2L))
                .withTimeout(Duration.ofSeconds(10L));
    }

    public void setImplicitWait(int secs)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
    }
    public void waitforVisibility(WebElement webElement , int waitforsecs)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitforsecs));
            wait.until(ExpectedConditions.visibilityOf(webElement));
        }catch (TimeoutException e)
        {
            System.out.printf("Timed out while waiting "+ e.getMessage());
        }
    }
    public void waitfluentlyforVisibility(long secs, WebElement webElement)
    {
        Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
                .pollingEvery(Duration.ofSeconds(secs))
                .withTimeout(Duration.ofSeconds(30L))
                .ignoring(NoSuchElementException.class);
        wait1.until(ExpectedConditions.visibilityOf(webElement));


    }
    public  void waitandClick(long time,WebElement element)
    {

        (wait.until(ExpectedConditions.elementToBeClickable(element))).click();

    }

    public List<String> getallOptionValues(WebElement element)
    {
        Select dropdown = new Select(element);
        wait.until(ExpectedConditions.visibilityOf(element));
        List<WebElement>  optionElements =  dropdown.getOptions();
        List<String> values = new ArrayList<>();
             for (WebElement optionElement : optionElements) {
                 values.add(optionElement.getText());
             }

          return values;
    }

    public List<String> getallSelectedValues(WebElement element)
    {
        Select dropdown = new Select(element);
        wait.until(ExpectedConditions.visibilityOf(element));
        List<WebElement>  optionElements =  dropdown.getAllSelectedOptions();
        List<String> values = new ArrayList<>();
        for (WebElement optionElement : optionElements) {
            values.add(optionElement.getText());
        }

        return values;
    }
    public String getSelectedValuefromDropdown(WebElement element)
    {
        Select select = new Select(element);
        return  select.getOptions().get(0).getText();
    }
    public String gettext(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        return  element.getText();
    }
    public void sendtext(WebElement element, String value)
    {
        if(element.isEnabled())
            element.sendKeys(value);
    }


}
