package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderUnsignedPage extends BasePage {
    @FindBy(css = "div.user-info a")
    private WebElement signInLink;

    @FindBy(css = "#_desktop_logo a")
    private WebElement mainPageLink;

    @FindBy(css = "div.header a")
    private WebElement basketLink;

    public void gotoBasket(){
        basketLink.click();
    }

    public void gotoMainPage(){
        mainPageLink.click();
    }


    public HeaderUnsignedPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignIn(){
        signInLink.click();
    }
}
