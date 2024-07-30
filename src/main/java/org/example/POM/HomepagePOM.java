package org.example.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomepagePOM {
    private WebDriver driver;
    public HomepagePOM(WebDriver _driver){
        this.driver = _driver;
    }

    private String loginBtnXpath = "//a/span[text()='Log in']";
    private By loginBtn = By.xpath(loginBtnXpath);
    private String searchBtnXpath = "//button[@data-testid='search-button']";
    private By searchBtn = By.xpath(searchBtnXpath);
    private String searchInputXpath = "//input[@data-testid='search-input']";
    private By searchInputBox = By.xpath(searchInputXpath);
    private String searchSubmitBtnXpath = "//button[@data-testid='search-submit']";
    private By searchSubmitBtn = By.xpath(searchSubmitBtnXpath);

    private String logoElementXpath = "//div[@data-testid='masthead-desktop-logo']";
    public By logoElement = By.xpath(logoElementXpath);

    public void clickOnLogin(){
        driver.findElement(loginBtn).click();
    }
    public void clickOnSearchInput(){
        driver.findElement(searchBtn).click();
    }
    public void enterInSearchInput(String _data){
        driver.findElement(searchInputBox).sendKeys(_data);
    }

    public void clickOnSearchSubmit(){
        driver.findElement(searchSubmitBtn).click();
    }

}
