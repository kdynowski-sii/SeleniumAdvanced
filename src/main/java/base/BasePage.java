package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected Actions actionMaker;
    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver = driver;
        actionMaker = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(this.driver, this);
    }
}
