import enums.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract class TestBase {
    protected WebDriver driver;
    @BeforeMethod
    public void setUp(){
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getDriver(Browser.CHROME); // TODO get it from file
        
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
