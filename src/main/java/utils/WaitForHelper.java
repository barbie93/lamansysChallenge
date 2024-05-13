package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitForHelper {

    public WebDriver driver;

    public WaitForHelper(WebDriver driver){
        this.driver = driver;
    }

    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebElement isPresentElement(final By elementLocation){
        return new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement elementToBeClickeable(final By elementIdentifier){
        return new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(elementIdentifier));
    }
}
