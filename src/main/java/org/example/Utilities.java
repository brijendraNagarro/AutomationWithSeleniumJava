package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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


    public static String getBrowserName(String filePath, String sheetName, int rowNumber, int cellNumber) {
        String browserName = "";
        try (FileInputStream fis = new FileInputStream(new File(filePath))) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNumber);
            browserName = row.getCell(cellNumber).getStringCellValue();
        } catch (IOException e) {
            browserName = "chrome";
            e.printStackTrace();
        }
        return browserName;
    }
}
