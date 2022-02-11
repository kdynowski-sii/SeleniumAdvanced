package Base;

import enums.Browser;
import models.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    @BeforeMethod
    public void setUp(){
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getDriver(Browser.EDGE); // TODO get it from file
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
