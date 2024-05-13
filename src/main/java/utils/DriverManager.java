package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    protected WebDriver driver;

    public DriverManager(){

    }

    public WebDriver getDriver(){
        return driver;
    }
}
