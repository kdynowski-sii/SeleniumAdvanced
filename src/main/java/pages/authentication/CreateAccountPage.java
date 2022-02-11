package pages.authentication;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateAccountPage extends BasePage {
    @FindBy(css = "input[name=id_gender]")private List<WebElement> genderRadios;
    @FindBy(css = "input[name=firstname]")private WebElement firsNameInput;
    @FindBy(css = "input[name=lastname]")private WebElement lastNameInput;
    @FindBy(css = "input[name=email]")private WebElement emailInput;
    @FindBy(css = "input[name=password]")private WebElement passwordInput;
    @FindBy(css = "input[name=birthday]")private WebElement birthdateInput;
    @FindBy(css = "input[type=checkbox]")private List<WebElement> checkboxes;
    @FindBy(css = "button.btn.btn-primary")private WebElement saveButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage selectGenderRadios(String socialTitle) {
        if (socialTitle.contains("s")) {//Mrs, Ms etc.
            genderRadios.get(1).click();
        } else {
            genderRadios.get(0).click();
        }
        return this;
    }

    public CreateAccountPage fillFirsNameInput(String firstName) {
        firsNameInput.sendKeys(firstName);
        return this;
    }

    public CreateAccountPage fillLastNameInput(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public CreateAccountPage fillEmailInput(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public CreateAccountPage fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public CreateAccountPage fillBirthdateInput(String birthdate) {
        birthdateInput.sendKeys(birthdate);
        return this;
    }

    public CreateAccountPage selectAllCheckboxes() {
        for(WebElement box: checkboxes){
            box.click();
        }
        return this;
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}
