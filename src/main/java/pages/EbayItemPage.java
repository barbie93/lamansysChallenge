package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayItemPage extends BasePage {

    public EbayItemPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    // Page Locators:
    protected static final By price = By.className("x-price-primary");

    // Page actions:
    public String getItemPrice() {
        waitForElementToAppear(price);
        WebElement itemPrice = getElement(price);
        return itemPrice.getText();
    }
}
