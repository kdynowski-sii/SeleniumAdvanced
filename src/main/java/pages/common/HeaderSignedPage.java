package pages.common;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderSignedPage extends BasePage {
    @FindBy(css = "a.account span.hidden-sm-down")
    private WebElement userNames;
    @FindBy(css = "div.user-info a.logout")
    private WebElement signOutButton;
    public HeaderSignedPage(WebDriver driver) {
        super(driver);
    }

    public String getUserName(){
        return userNames.getText();
    }

    public void signOut(){
        signOutButton.click();
    }
}
