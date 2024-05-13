package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverManager;
import utils.PropertyReader;
import java.util.Locale;

public class BaseTest extends DriverManager {
    protected static final String BROWSER = "browser";
    protected static final String CHROME_PROPERTY = "webdriver.chrome.driver";
    protected static final String FIREFOX_PROPERTY = "webdriver.gecko.driver";
    protected static final String EDGE_PROPERTY = "webdriver.edge.driver";
    protected static final String USER_DIR = "user.dir";
    protected static final String ROOT_FOLDER = System.getProperty(USER_DIR);
    protected static final String DRIVERS_FOLDER = "\\src\\main\\resources\\Drivers\\";
    protected static final String chromeDriverFolder = ROOT_FOLDER + DRIVERS_FOLDER + "Chrome\\chromedriver.exe";
    protected static final String firefoxDriverFolder = ROOT_FOLDER + DRIVERS_FOLDER + "Firefox\\firefoxdriver.exe";
    protected static final String edgeDriverFolder = ROOT_FOLDER + DRIVERS_FOLDER + "Edge\\msedgedriver.exe";
    protected static final String BROWSER_NOT_SUPPORTED_ERROR = "Browser is not supported";
    protected static final String NOT_COMPATIBLE_ERROR = "No compatible browser found ";
    protected static final String BROWSER_ERROR = "Browser launch error ";
    protected PropertyReader pr = new PropertyReader();

    public BaseTest(){
        this.driver = super.getDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        try {
            switch (pr.readItem(BROWSER).toLowerCase(Locale.ROOT)) {
                case "chrome":
                    System.setProperty(CHROME_PROPERTY, chromeDriverFolder);
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    System.setProperty(FIREFOX_PROPERTY, firefoxDriverFolder);
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                case "edge" :
                    System.setProperty(EDGE_PROPERTY, edgeDriverFolder);
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    break;
                default:
                    try {
                        throw new Exception(BROWSER_NOT_SUPPORTED_ERROR);
                    }
                    catch (Exception e) {
                        System.out.println(NOT_COMPATIBLE_ERROR + e.getMessage());
                    }
            }
        } catch (Exception e){
            System.out.println(BROWSER_ERROR + e.getMessage());
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
