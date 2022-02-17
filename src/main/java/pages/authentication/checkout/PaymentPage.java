package pages.authentication.checkout;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {
    @FindBy(css = "#payment-option-1")
    private WebElement payByCheck;
    @FindBy(css = "#conditions-to-approve input[type='checkbox']")
    private WebElement termsOfService;
    @FindBy(css = "#payment-confirmation button")
    private WebElement confirmationButton;
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage selectPayByCheck() {
        payByCheck.click();
        return this;
    }

    public PaymentPage agreeToTerms() {
        termsOfService.click();
        return this;
    }

    public void placeOrder() {
        confirmationButton.click();
    }
}
