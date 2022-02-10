import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    private WebDriver driver;
    public WebDriver getDriver(Browser browser){
        switch (browser){
            case IE:
                return setUpIE();
            case EDGE:
                return setUpEdge();
            case CHROME:
                return setUpChrome();
            case FIREFOX:
                return setUpFirefox();
        }
        return null;
    }

    private WebDriver setUpFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }

    private WebDriver setUpChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    private WebDriver setUpEdge() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        return driver;
    }

    private WebDriver setUpIE() {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        return driver;
    }
}
