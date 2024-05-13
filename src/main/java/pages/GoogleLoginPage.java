package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertyReader;

public class GoogleLoginPage extends BasePage {
    // Page Locators:
    protected static final By userName = By.id("identifierId");
    protected static final By userNextButton = By.cssSelector("#identifierNext button span");
    protected static final By passwordInput = By.cssSelector("#password input");
    protected static final By pwdNextButton = By.cssSelector("#passwordNext button span");
    protected static final By wrongPassword = By.cssSelector("[class='Ly8vae uSvLId'] span");
    protected static final String wrongPasswordMessage = "La contraseña es incorrecta. Vuelve a intentarlo o haz clic en \"¿Olvidaste la contraseña?\" para restablecerla.";

    private static final String URL = "url";
    private WebDriver driver;

    public GoogleLoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    // Page actions:
    public void openPage(){
        goToUrl(PropertyReader.readItem(URL));
    }

    public void login(String user, String password){
        waitForElementToAppear(userName);
        writeText(userName, user);
        waitForElementToAppear(userNextButton);
        click(userNextButton);
        waitForElementToAppear(passwordInput);
        writeText(passwordInput, password);
        waitForElementToAppear(pwdNextButton);
        waitForLoading();
        click(pwdNextButton);
        waitForLoading();
    }

    public boolean isPasswordIncorrect() {
        waitSeconds(3);
        waitForElementToAppear(wrongPassword);
        WebElement message = getElement(wrongPassword);
        return message.getText().equals(wrongPasswordMessage);
    }
}
