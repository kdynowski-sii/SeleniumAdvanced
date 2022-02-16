package pages.authentication.checkout;

import base.BasePage;
import enums.PolUsa;
import org.openqa.selenium.WebDriver;

public class AddressPage extends BasePage {
    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public AddressPage fillAddress(String address) {
        return this;
    }

    public AddressPage fillCity(String city) {
        return this;
    }

    public AddressPage fillZipCode(String zipCode) {
        return this;
    }

    public AddressPage selectCountry(PolUsa country) {
        switch (country){
            case POLAND:
                break;
            case USA:
                break;
        }
        return this;
    }

    public void clickContinue() {

    }
}
