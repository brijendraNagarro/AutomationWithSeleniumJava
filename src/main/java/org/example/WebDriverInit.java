package org.example;

import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverInit {
    public static WebDriver createWebDriver() {
        WebDriver driver;
        String browserName = Utilities.getBrowserName("src/test/resource/excelForSelenium.xlsx", "BrowserSettings", 0, 0);
        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }


        return driver;
    }
}
