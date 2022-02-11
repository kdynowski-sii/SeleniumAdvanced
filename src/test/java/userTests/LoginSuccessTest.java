package userTests;

import Base.TestBase;
import models.User;
import models.UserFactory;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.HeaderSignedPage;
import pages.HeaderUnsignedPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginSuccessTest extends TestBase {
    @Test
    public void loginWithExistingUser(){
        driver.get("http://146.59.32.4/index.php"); //TODO get from file
        new HeaderUnsignedPage(driver).clickSignIn();

        User existingUser = new UserFactory().getUser(true);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.fillInputs(existingUser.getEmail(), existingUser.getPassword())
                .submit();
        HeaderSignedPage headerSignedPage = new HeaderSignedPage(driver);
        assertThat(headerSignedPage.getUserName()).contains(existingUser.getFirstName())
                .contains(existingUser.getLastName())
                .isEqualToIgnoringWhitespace(existingUser.getFirstName()+existingUser.getLastName());
        headerSignedPage.signOut();
    }

    @Test
    public void UserRegistration(){
        driver.get("http://146.59.32.4/index.php"); //TODO get from file
        new HeaderUnsignedPage(driver).clickSignIn();

        User newUser = new UserFactory().getUser(false);
        new AuthenticationPage(driver).goToRegisterPage();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.selectGenderRadios(newUser.getSocialTitle())
                .fillFirsNameInput(newUser.getFirstName())
                .fillLastNameInput(newUser.getLastName())
                .fillEmailInput(newUser.getEmail())
                .fillPasswordInput(newUser.getPassword())
                .fillBirthdateInput(newUser.getBirthDate())
                // Hardcode all checkboxes as true
                .selectAllCheckboxes()
                .clickSaveButton();
        HeaderSignedPage headerSignedPage = new HeaderSignedPage(driver);
        assertThat(headerSignedPage.getUserName()).contains(newUser.getFirstName())
                .contains(newUser.getLastName())
                .isEqualToIgnoringWhitespace(newUser.getFirstName()+newUser.getLastName());
        headerSignedPage.signOut();
    }
}
