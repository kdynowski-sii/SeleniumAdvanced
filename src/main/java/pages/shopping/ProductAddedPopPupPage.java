package pages.shopping;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductAddedPopPupPage extends BasePage {
    @FindBy(css = "p.cart-products-count")
    private WebElement countOfProducts;
    @FindBy(css = "button.btn-secondary")
    private WebElement continueShoppingButton;
    private final WebDriverWait wait;

    public ProductAddedPopPupPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
        this.wait = wait;
    }

    public String getCount(){//There are 3 items in your cart.
        wait.until(ExpectedConditions.visibilityOf(countOfProducts));
        return countOfProducts.getText().substring(9, countOfProducts.getText().length() - 19).trim();
    }

    public void continueShopping(){
        continueShoppingButton.click();
    }
}
