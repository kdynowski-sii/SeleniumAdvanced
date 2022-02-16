package pages.authentication.checkout;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PersonalInformationPage extends BasePage {
    @FindBy(css = "span.custom-radio")
    private List<WebElement> radios;
    @FindBy(xpath = "//input[@name='firstname']")
    private List<WebElement> firstnameInput;
    @FindBy(xpath = "//input[@name='lastname']")
    private List<WebElement> lastnameInput;
    @FindBy(xpath = "//input[@name='email']")
    private List<WebElement> emailInput;
    @FindBy(xpath = "//input[@name='customer_privacy']")
    private WebElement privacyCheckbox;
    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement owuCheckbox;
    @FindBy(css = "#customer-form button.continue")
    private WebElement continueButton;

    public PersonalInformationPage(WebDriver driver) {
        super(driver);
    }

    public PersonalInformationPage pickSocialTitle(String socialTitle) {
        if ("Mr".equals(socialTitle)) {
            radios.get(0).click();
            return this;
        }
        radios.get(1).click();
        return this;
    }

    public PersonalInformationPage fillFirstName(String firstName) {
        firstnameInput.get(0).clear();
        firstnameInput.get(0).sendKeys(firstName);
        return this;
    }

    public PersonalInformationPage fillLastName(String lastname) {
        lastnameInput.get(0).clear();
        lastnameInput.get(0).sendKeys(lastname);
        return this;
    }

    public PersonalInformationPage fillEmail(String email) {
        emailInput.get(0).clear();
        emailInput.get(0).sendKeys(email);
        return this;
    }

    public PersonalInformationPage checkPrivacy() {
        privacyCheckbox.click();
        return this;
    }

    public PersonalInformationPage checkOwu() {
        owuCheckbox.click();
        return this;
    }

    public void clickContinue() {
        continueButton.click();
    }
}
