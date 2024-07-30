package org.example;

import jdk.jfr.Timespan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverInit.createWebDriver();
        driver.get("https://www.nytimes.com/international/");
    }

    @Test
    public void test1(){
        driver.findElement(By.xpath("//a/span[text()='Log in']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterMethod
    public void teatDown(){
        driver.quit();
    }
}
