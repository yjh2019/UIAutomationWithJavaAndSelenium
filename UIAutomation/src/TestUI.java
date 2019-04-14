import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

@Test()
public class TestUI {
    ChromeDriver driver;
    String url = "";

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", ConstantsHelper.chromeDriverLocation);
        driver=new ChromeDriver();
    }

    @Test
    public void testGooglePageLoad(){
        String url = ConstantsHelper.googleUrl;
        driver.get(url);

        Helper.waitUntilPageLoad(driver);
        WebElement searchButton = Helper.findElement(driver, PageElements.googleSearchButtonBy);
        Assert.assertNotEquals(searchButton, null, "page is not loaded that search button is not found");
    }

    @Test
    public void testGoogleSearch(){
        String searchStr = "mobile integration workgroup";
        String expectedLink = "https://miwtech.com/";
        url = ConstantsHelper.googleUrl;
        driver.get(url);

        Helper.waitUntilPageLoad(driver);
        Helper.enterSearchText(driver, PageElements.googleSearchInputBy, searchStr);
        Helper.clickElement(driver, PageElements.googleSearchButtonBy);
        Helper.waitUntilPageLoad(driver);
        String link = Helper.getFirstLinkOfGoogleResults(driver);
        Assert.assertEquals(link, expectedLink,"url link is not correct");
    }

    @Test
    public void testRbauctionSearch(){
        String makeStr = "CATERPILLAR";
        int thisYear = Helper.getCurrentYear();
        int threeYearsAgo = thisYear - 3;
        url = ConstantsHelper.rbauctionUrl;
        driver.get(url);

        Helper.waitUntilPageLoad(driver);
        Helper.waitAndClickElement(driver, PageElements.arrowDownButtonBy);
        Helper.selectDropdownForIndustry(driver, "Construction");
        Helper.selectDropdownForCategory(driver, "Excavator");
        Helper.enterSearchText(driver, PageElements.makeTextboxBy, makeStr);
        Helper.enterSearchText(driver, PageElements.minYearBy, String.valueOf(threeYearsAgo));
        Helper.enterSearchText(driver, PageElements.maxYearBy, String.valueOf(thisYear));
        Helper.clickElement(driver, PageElements.searchButtonBy);
        Helper.waitUntilPageLoad(driver);

        String detail = Helper.getFirstDetailOfAuction(driver);
        System.out.println(detail);
    }

    @AfterTest
    public void clean(){
        driver.close();
    }


}