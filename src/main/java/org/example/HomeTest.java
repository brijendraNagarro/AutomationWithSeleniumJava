package org.example;

import org.example.POM.HomepagePOM;
import org.example.POM.SearchPagePOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeTest extends BaseTest {

    @Test
    public void NavigationTest(){
        HomepagePOM homepage = new HomepagePOM(driver);

        utils.waitForVisibilityOfElement(homepage.logoElement);
        homepage.MouseOverMainMenuAndClickOnFirstSubMenu();
        String navigationPageTitle = homepage.getNavigationPageTitle();
        Assert.assertEquals(navigationPageTitle,"U.S. NEWS");
    }

    @Test
    public void SearchFunctionalityTest(){
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

    @Test
    public void MastHeadMenuAvailablity(){
        HomepagePOM homepagePOM = new HomepagePOM(driver);
        int mastHeadMenuCount = homepagePOM.getMastHeadMenuCount();
        Assert.assertEquals(5,mastHeadMenuCount);
    }

}
