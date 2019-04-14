import org.openqa.selenium.By;

/**
 * Created by Yujing on 4/12/2019.
 */
public class PageElements {

    //Google site
    static By googleSearchButtonBy = By.name("btnK");
    static By googleSearchInputBy = By.name("q");
    static By googleSearchResultsBy = By.className("srg");
    static By googleSearchResultsFirstLinkBy = By.xpath("//div[@class='srg']/div[1]//a");

    //Auction site
    static By arrowDownButtonBy = By.id("adv-toggle-down");
    static By makeTextboxBy = By.id("adv-make");
    static By minYearBy = By.id("adv-year-min");
    static By maxYearBy = By.id("adv-year-max");
    static By searchButtonBy = By.id("adv-submit-button");
    static By searchResultsBy = By.xpath("//main//p[contains(@id, \"_details\")]");
    static By industryComboBy = By.xpath("//li[@id=\"adv-industry\"]//input");
    static By industryComboDropdownBy = By.xpath("//li[@id=\"adv-industry\"]//div[contains(@class, \"Select-menu-outer\")]");
    static By categoryComboBy = By.xpath("//li[@id=\"adv-category\"]//input");
    static By categoryComboDropdownBy = By.xpath("//li[@id=\"adv-category\"]//div[contains(@class, \"Select-menu-outer\")]");
}


//div[@id="searchResultsList"]//p[contains(@id, "_details")]");