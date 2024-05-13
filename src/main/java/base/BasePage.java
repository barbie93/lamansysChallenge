package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.WaitForHelper;

import java.util.List;
import java.util.Set;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void goToUrl(String url){
        driver.get(url);
    }

    public void waitForElementToAppear(By elementLocation){
        new WaitForHelper(driver).isPresentElement(elementLocation);
    }

    public void waitForLoading(){
        new WaitForHelper(driver).implicitWait();
    }

    public void click(By elementLocation){
        driver.findElement(elementLocation).click();
    }

    public void writeText(By elementLocation, String text){
        driver.findElement(elementLocation).clear();
        driver.findElement(elementLocation).sendKeys(text);
    }

    public String readText(By elementLocation){
        return driver.findElement(elementLocation).getText();
    }

    public List<WebElement> getElements(By elementLocation) {
        return driver.findElements(elementLocation);
    }

    public WebElement getElement(By elementLocation) {
        return driver.findElement(elementLocation);
    }

    public void moveToElement(By elementLocation){
        new Actions(driver).moveToElement(driver.findElement(elementLocation)).build().perform();
    }

    public void changeTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        driver.switchTo().window((String) windowHandles.toArray()[windowHandles.size()-1]);
    }

    public void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
