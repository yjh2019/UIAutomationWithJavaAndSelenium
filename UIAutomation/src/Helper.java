import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Calendar;
import java.util.List;

public class Helper {

    static void waitUntilPageLoad(WebDriver driver){
        new WebDriverWait(driver, ConstantsHelper.pageLoadTimeout).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    static int getCurrentYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static WebElement findElement(WebDriver driver, By by){
        WebElement we = driver.findElement(by);
        return we;
    }

    public static void enterSearchText(WebDriver driver, By by, String searchStr){
        WebElement inputText=driver.findElement(by);
        inputText.sendKeys(searchStr);
    }

    public static void selectDropdownForIndustry(WebDriver driver, String industry){
        WebElement industryWe = driver.findElement(PageElements.industryComboBy);
        industryWe.sendKeys(industry);
        WebElement industryArrow = driver.findElement(PageElements.industryComboDropdownBy);
        industryArrow.click();
    }

    public static void selectDropdownForCategory(WebDriver driver, String category){
        WebElement categoryWe = driver.findElement(PageElements.categoryComboBy);
        categoryWe.sendKeys(category);
        WebElement categoryArrow = driver.findElement(PageElements.categoryComboDropdownBy);
        categoryArrow.click();;
    }


    public static void clickElement(WebDriver driver, By by){
        WebElement we=driver.findElement(by);
        we.click();
    }

    public static void waitAndClickElement(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, ConstantsHelper.pageLoadTimeout);
        WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        we.click();
    }

    public static String getFirstLinkOfGoogleResults(WebDriver driver){
        WebElement div=driver.findElement(PageElements.googleSearchResultsBy);
        WebElement element = driver.findElement(PageElements.googleSearchResultsFirstLinkBy);
        String link = element.getAttribute("href");
        return link;
    }

    public static String getFirstDetailOfAuction(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, ConstantsHelper.pageLoadTimeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PageElements.searchResultsBy));
        List<WebElement> detailElement = driver.findElements(PageElements.searchResultsBy);
        WebElement firstRow = detailElement.get(0);
        String detail = firstRow.getAttribute("innerHTML");
        return detail;
    }
}
