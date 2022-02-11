package pages.authentication;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AuthenticationPage extends BasePage {
    @FindBy(css = "input.form-control")
    private List<WebElement> authenticationInputs;

    @FindBy(css = "#submit-login")
    private WebElement submitButton;

    @FindBy(css = "div.no-account a")
    private WebElement registerLink;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public AuthenticationPage fillInputs(String firstName, String lastName){
        authenticationInputs.get(0).sendKeys(firstName);
        authenticationInputs.get(1).sendKeys(lastName);
        return this;
    }


    public void submit() {
        submitButton.click();
    }

    public void goToRegisterPage() {
        registerLink.click();
    }
}
