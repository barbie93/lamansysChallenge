package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

public class EbayPage extends BasePage {

    public EbayPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private static final String URL = "ebay";

    // Page Locators:
    protected static final By searchBar = By.name("_nkw");
    protected static final By searchButton = By.cssSelector("input[type='submit']");

    // Page actions:
    public void openPage(){
        goToUrl(PropertyReader.readItem(URL));
    }

    public void searchItem(String itemName) {
        waitForElementToAppear(searchBar);
        writeText(searchBar, itemName);
        waitForElementToAppear(searchButton);
        click(searchButton);
    }
}
