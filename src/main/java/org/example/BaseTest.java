package org.example;

import org.example.POM.HomepagePOM;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;


public class BaseTest {
    public WebDriver driver;
    public Utilities utils;

    @BeforeMethod
    public void setup(){
        driver = WebDriverInit.createWebDriver();
        driver.get("https://www.nytimes.com/international/");
        utils = new Utilities(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void teatDown(ITestResult result){
        if (ITestResult.FAILURE == result.getStatus()) {
            utils.takeScreenshot(driver, result.getMethod().getMethodName());
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
