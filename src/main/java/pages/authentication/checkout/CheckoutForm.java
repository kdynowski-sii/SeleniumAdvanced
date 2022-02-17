package pages.authentication.checkout;

import base.BasePage;
import models.User;
import org.openqa.selenium.WebDriver;

public class CheckoutForm extends BasePage {
    private User user;

    public CheckoutForm(WebDriver driver, User user) {
        super(driver);
        this.user = user;
    }

    public void fillForm(){
        new PersonalInformationPage(driver)
                .pickSocialTitle(user.getSocialTitle())
                .fillFirstName(user.getFirstName())
                .fillLastName(user.getLastName())
                .fillEmail(user.getEmail())
                .checkPrivacy()
                .checkOwu()
                .clickContinue();
        new AddressPage(driver)
                .fillFirstname(user.getFirstName())
                .fillLastname(user.getLastName())
                .fillAddress(user.getAddress())
                .fillCity(user.getCity())
                .fillZipCode(user.getZipCode())
                .selectCountry(user.getCountry())
                .clickContinue();
        new ShippingMethodPage(driver)
                .chooseTesterSiiShippingMethod()
                .clickContinue();
        new PaymentPage(driver)
                .selectPayByCheck()
                .agreeToTerms()
                .placeOrder();
    }

}
