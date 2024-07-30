package org.example.POM;

import org.example.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPagePOM {
    private WebDriver driver;
    private Utilities utils;
    public SearchPagePOM(WebDriver _driver, Utilities utils){
        this.driver = _driver;
        this.utils = utils;
    }

    private By searchTermXpath = By.xpath("//input[@data-testid='search-page-text-field']");

    private By firstArticleInSearchResult = By.xpath("//li[@data-testid='search-bodega-result'][1]//a");

    private By firstArticleHeading = By.xpath("//li[@data-testid='search-bodega-result'][1]//a//h4");

    private By articlePageHeading = By.xpath("//h1[@data-testid='headline']");
    public String getSearchTitle(){
        utils.waitForVisibilityOfElement(searchTermXpath);
        return driver.findElement(searchTermXpath).getAttribute("value").toString();
    }
    public void clickOnFirstSearchArticle(){
        driver.findElement(firstArticleInSearchResult).click();
    }

    public String getFirstSearchResultHeading(){
        return driver.findElement(firstArticleHeading).getText();
    }

    public String getArticlePageHeading(){
        return driver.findElement(articlePageHeading).getText().toString();
    }
}
