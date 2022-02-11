package Base;

import helpers.JsonHelper;
import models.DriverFactory;
import models.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public abstract class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected TestConfig testConfig;

    @BeforeMethod
    public void setUp() throws IOException {
        testConfig = new JsonHelper().deserializeJson("src/config.json", TestConfig.class);
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getDriver(testConfig.getBrowser());
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void tearDownAfterAll() throws IOException {
        testConfig.switchBrowser();
        new JsonHelper().serializeJson("src/config.json", testConfig);
    }

}
