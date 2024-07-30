# Description
This is a Test Automation Framework for Newyork Times Webapplication

# Folder Structure

### Src>main>Java>Org.example
    -> POM : This Directory contains Page object model classes for different pages.
        ->HomePagePOM -> This Class Contains Locator and method for HomePage.
        ->SearchPagePOM -> This Class Contains Locator and method for Search Result page.
    -> Base Test -> This class contain setup and tear down method, used to open url and quit browser instances with screenshot for failing assertions.
    -> Home Test -> This class contains the test scripts with @test annotation
    -> utilities -> This class contains common methods implementation for Explicit wait and screenshots.
    -> WebDriverInit -> This class initializes the browser

### Src>testResults
    testResults is the directory which stores the screenshots of the 
    application in case of test failure.

### Src>test>resource>testng.xml
    testng file is defined here which contains execution settings

### pom.xml
    contains the dependencies for selenium, testng and apache poi

## Execution
    1. Execution start from testng file and triggers the classes mentioned in 
       in <classes> tag.
    2. Test Classes extends the base class which contain setup method.
       Setup method initialized the webdriver and store driver instance in class variable and pass it on to the test class
    3. Test class access POM classes by pasing driver instances to it.
    4. Test executes the method written in POM classes by accessing element with locator.
    5. Execution stop if there is a failure detected and it take the screenshot.
    6. @aftertest method dstroys the instance and quits the browser.


    