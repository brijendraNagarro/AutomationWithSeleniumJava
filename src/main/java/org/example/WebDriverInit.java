package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverInit {
    public static WebDriver createWebDriver() {
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
