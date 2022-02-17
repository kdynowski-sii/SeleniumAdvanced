package pages.authentication.checkout;

import base.BasePage;
import enums.PolUsa;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddressPage extends BasePage {
    @FindBy(xpath = "//input[@name='firstname']")
    private List<WebElement> firstnameInput;
    @FindBy(xpath = "//input[@name='lastname']")
    private List<WebElement> lastnameInput;
    @FindBy(css = "#delivery-address input[name='address1']")
    private WebElement addressInput;
    @FindBy(css = "#delivery-address input[name='city']")
    private WebElement cityInput;
    @FindBy(css = "#delivery-address input[name='postcode']")
    private WebElement postcodeInput;
    @FindBy(css = "#delivery-address select[name='id_country']")
    private WebElement countrySelect;
    @FindBy(css = "#delivery-address button[type='submit']")
    private WebElement continueButton;

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public AddressPage fillAddress(String address) {
        addressInput.sendKeys(address);
        return this;
    }

    public AddressPage fillCity(String city) {
        cityInput.sendKeys(city);
        return this;
    }

    public AddressPage fillZipCode(String zipCode) {
        postcodeInput.sendKeys(zipCode);
        return this;
    }

    public AddressPage selectCountry(PolUsa country) {
        new Select(countrySelect).selectByValue(String.valueOf(country.getNumVal())); // Enum has numerical values
        // corresponding to select values
        return this;
    }

    public void clickContinue() {
        continueButton.click();
    }

    public AddressPage fillFirstname(String firstName) {
        firstnameInput.get(1).clear();
        firstnameInput.get(1).sendKeys(firstName);
        return this;
    }

    public AddressPage fillLastname(String lastName) {
        lastnameInput.get(1).clear();
        lastnameInput.get(1).sendKeys(lastName);
        return this;
    }
}
