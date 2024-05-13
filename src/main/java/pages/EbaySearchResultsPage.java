package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbaySearchResultsPage extends BasePage {

    public EbaySearchResultsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    // Page Locators:
    protected static final By resultList = By.cssSelector("[class='srp-results srp-list clearfix'] li[class='s-item s-item__pl-on-bottom'] div div[class='s-item__image-section']");

    // Page actions:
    public void clickFirstResultsElement() {
        WebElement firstResult = getElements(resultList).get(0);
        firstResult.click();
        changeTab();
    }
}
