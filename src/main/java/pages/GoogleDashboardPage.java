package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleDashboardPage extends BasePage {
    // Page Locators:
    protected static final By userProfileButton = By.cssSelector("[role='banner'] [class='gb_f gb_eb gb_3f gb_K']");
    protected static final By user = By.cssSelector(".gb_Fc");
    protected static final int WAIT_TIME = 3;
    private static WebDriver driver;

    //Constructor
    public GoogleDashboardPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    // Page Actions:
    public boolean isUserLogged(String userInformation) {
        moveToElement(userProfileButton);
        waitSeconds(WAIT_TIME);
        String userInfo = readText(user);
        waitSeconds(WAIT_TIME);
        return userInfo.equals(userInformation);
    }
}
