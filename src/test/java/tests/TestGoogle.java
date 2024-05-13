package tests;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleDashboardPage;
import pages.GoogleLoginPage;
import utils.PropertyReader;

public class TestGoogle extends BaseTest {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String userInformation = "Google Account\nLamansysChallenge TestAccount\nlamansyschallenget@gmail.com";
    private static final String ERROR_MSG = "User is not correctly logged";

    @Description("Log in Successful test case")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void userLoginSuccess(){
        String userName = PropertyReader.readItem(USERNAME);
        String password = PropertyReader.readItem(PASSWORD);
        GoogleLoginPage googleLoginPage = new GoogleLoginPage(driver);
        googleLoginPage.openPage();
        googleLoginPage.login(userName, password);
        GoogleDashboardPage googleDashboardPage = new GoogleDashboardPage(driver);
        Assert.assertTrue(googleDashboardPage.isUserLogged(userInformation), ERROR_MSG);
    }

    @Description("Log in Wrong Password test case")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void userLoginFailed(){
        String userName = PropertyReader.readItem(USERNAME);
        String password = "123";
        GoogleLoginPage googleLoginPage = new GoogleLoginPage(driver);
        googleLoginPage.openPage();
        googleLoginPage.login(userName, password);
        Assert.assertTrue(googleLoginPage.isPasswordIncorrect(), ERROR_MSG);
    }

    @Description("Log in Wrong user information test case")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void userLoginWrongInformation(){
        String userName = PropertyReader.readItem(USERNAME);
        String password = PropertyReader.readItem(PASSWORD);
        String userInfo = "lamansyschallenget@gmail.com";
        GoogleLoginPage googleLoginPage = new GoogleLoginPage(driver);
        googleLoginPage.openPage();
        googleLoginPage.login(userName, password);
        GoogleDashboardPage googleDashboardPage = new GoogleDashboardPage(driver);
        Assert.assertFalse(googleDashboardPage.isUserLogged(userInfo), ERROR_MSG);
    }
}