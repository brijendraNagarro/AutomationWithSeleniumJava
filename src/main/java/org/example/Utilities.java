package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utilities {

    private WebDriver _driver;
    private WebDriverWait _wait;

    public Utilities(WebDriver driver, Duration duration){
        this._driver = driver;
        this._wait = new WebDriverWait(_driver,duration);
    }
    public WebElement waitForVisibilityOfElement(By locator) {
        return _wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for an element to be clickable
    public WebElement waitForClickable(By locator) {
        return _wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
