package org.example;

import org.example.POM.HomepagePOM;
import org.example.POM.SearchPagePOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeTest extends BaseTest {


    public void LoginTest(){
        HomepagePOM homepage = new HomepagePOM(driver);
        homepage.clickOnLogin();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        utils.waitForVisibilityOfElement(homepage.logoElement);
        // to be implemented
        // check if navigated to login page
        // assert with login title;
    }

    @Test
    public void searchFunctionalityTest(){
        String data = "election";
        HomepagePOM homepage = new HomepagePOM(driver);
        SearchPagePOM searchpage = new SearchPagePOM(driver,utils);
        homepage.clickOnSearchInput();
        homepage.enterInSearchInput(data);
        homepage.clickOnSearchSubmit();
        Assert.assertEquals(driver.getTitle(),"The New York Times - Search");
        Assert.assertEquals(data,searchpage.getSearchTitle());
        String searchPageHeading = searchpage.getFirstSearchResultHeading();
        searchpage.clickOnFirstSearchArticle();
        searchpage.getArticlePageHeading();
        String articlePageHeading = searchpage.getArticlePageHeading();
        Assert.assertEquals(searchPageHeading,articlePageHeading);
    }

}
