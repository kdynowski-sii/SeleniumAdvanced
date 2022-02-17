package pages.authentication.checkout;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmationPage extends BasePage {
    @FindBy(css = "h3.h1")
    private WebElement message;
    public ConfirmationPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(message));
        PageFactory.initElements(driver, this);
    }

    public String getValidationMessage(){
        return message.getText();
    }
}
