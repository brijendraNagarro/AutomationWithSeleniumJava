package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utilities {

    private WebDriver _driver;
    private WebDriverWait _wait;
    private WebElement _element;

    public Utilities(WebDriver driver, Duration duration){
        this._driver = driver;
        this._wait = new WebDriverWait(_driver,duration);
    }
    public Utilities(WebElement element){
        this._element = element;
    }
    public WebElement waitForVisibilityOfElement(By locator) {
        return _wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for an element to be clickable
    public WebElement waitForClickable(By locator) {
        return _wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void takeScreenshot(WebDriver driver, String testName) {
        // Create a timestamp for the screenshot file name
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testName + "_" + timestamp + ".png";

        // Take the screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("src/testResults/" + fileName); // Path where screenshots will be saved

        try {
            FileHandler.copy(srcFile, destFile);
            System.out.println("Screenshot saved as: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
