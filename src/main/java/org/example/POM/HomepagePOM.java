package org.example.POM;

import org.example.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

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
    private String MainMenuUSDropdownXpath = "//nav[@data-testid='desktop-nested-nav']//button[@aria-label='open U.S. submenu']";

    private By MainMenuUSDropdown = By.xpath(MainMenuUSDropdownXpath);

    private String MainMenuDropdownItemXpath = "//div[@aria-label='U.S. submenu' and @aria-hidden='false']//a[text()='U.S.']";

    private By MainMenuDropdownItem = By.xpath(MainMenuDropdownItemXpath);
    private String logoElementXpath = "//div[@data-testid='masthead-desktop-logo']";
    public By logoElement = By.xpath(logoElementXpath);

    private String NavigationPageTitleXpath = "//div[@id='masthead-section-label']";
    private By NavigationPageTitle = By.xpath(NavigationPageTitleXpath);

    private String MastHeadMenuXpath = "//ul[@data-testid='masthead-edition-menu']//li";
    private By MastHeadMenu = By.xpath(MastHeadMenuXpath);

    public List<WebElement> getMastHeadMenu(){
        return driver.findElements(MastHeadMenu);
    }


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

    public void MouseOverMainMenuAndClickOnFirstSubMenu(){
        Utilities utils = new Utilities(driver, Duration.ofSeconds(5));
        driver.findElement(MainMenuUSDropdown).click();
        Actions action = new Actions(driver);
//        action.moveToElement(driver.findElement(MainMenuUSDropdown)).perform();
        utils.waitForVisibilityOfElement(MainMenuDropdownItem);
        action.moveToElement(driver.findElement(MainMenuDropdownItem)).click().perform();

    }

    public String getNavigationPageTitle(){
        return driver.findElement(NavigationPageTitle).getText().toString();
    }
}
