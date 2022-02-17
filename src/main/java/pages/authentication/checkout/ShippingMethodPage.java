package pages.authentication.checkout;

import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShippingMethodPage extends BasePage {
    @FindBy(css = "#delivery_option_1")
    private WebElement testerSiiRadio;
    @FindBy(css = "#js-delivery button")
    private WebElement continueButton;
    public ShippingMethodPage(WebDriver driver) {
        super(driver);
    }

    public ShippingMethodPage chooseTesterSiiShippingMethod(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('delivery_option_1').click();");
//        testerSiiRadio.click();
        return this;
    }
    public void clickContinue() {
        wait.until(ExpectedConditions.visibilityOf(continueButton));
        continueButton.click();
    }
}
