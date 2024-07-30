package org.example;

import org.example.POM.HomepagePOM;
import org.example.POM.SearchPagePOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<String> expectedValues = Arrays.asList("U.S.", "INTERNATIONAL", "CANADA", "ESPAÑOL","中文");

        List<WebElement> _list = homepagePOM.getMastHeadMenu();
        int mastHeadMenuCount = _list.size();
        Assert.assertEquals(5,mastHeadMenuCount);

        List<String> actualValues = new ArrayList<>();
        for (WebElement element : _list) {
            actualValues.add(element.getText().trim());
        }


        Assert.assertEquals(actualValues, expectedValues, "The actual values do not match the expected values.");



    }

}
