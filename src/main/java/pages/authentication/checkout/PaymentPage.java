package pages.authentication.checkout;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage selectPayByCheck() {
        return this;
    }

    public PaymentPage agreeToTerms() {
        return this;
    }

    public void placeOrder() {
    }
}
