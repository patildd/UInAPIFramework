package org.example.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.DriverFactory.Browser;
import org.example.DriverFactory.WebDriverFactory;

import org.example.Utils.RetryListner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;


/**
 * Unit test for simple App.
 */
public class AppTest {
public static WebDriver driver;
    /**
     * Rigorous Test :-)
     *
     */
    @BeforeTest
    public void setUP()
    {
        Browser browser =  WebDriverFactory.getBrowser("edge");
          driver =  browser.getDriver();
    }
//    @Test(retryAnalyzer = RetryListner.class)
//    public void shouldAnswerWithTrue() {
//
//
//
//        driver.get("https://google.com");
//        System.out.println("Title"+ driver.getTitle());
//
//        assertEquals(driver.getTitle(),"Google");
//        assertTrue(driver.getTitle().compareToIgnoreCase("google1")==0);
//        driver.close();
//    }
    @Test()
    public void  validateSalary()
    {
        driver.get("https://datatables.net/examples/basic_init/multi_col_sort.html");
        // Locate the table
        WebElement salaryTable = driver.findElement(By.xpath("//table[@id='example']"));

// Get headers in one call
        List<WebElement> headers = salaryTable.findElements(By.xpath(".//th"));

// Print headers
        for (WebElement header : headers) {
            System.out.print(header.getText() + "\t");
        }
        System.out.println(); // Move to the next line after headers

// Get all rows in one call
        List<WebElement> rows = salaryTable.findElements(By.xpath(".//tbody//tr"));

// Iterate through rows
        for (WebElement row : rows) {
            // Get all cells in the current row
            List<WebElement> cells = row.findElements(By.xpath(".//td"));

            // Print cell data
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + "\t");
            }
            System.out.println(); // Move to the next line after each row
        }

    }

}
