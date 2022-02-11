package pages.shopping;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(css = "input#quantity_wanted")
    private WebElement quantityInput;

    @FindBy(css = "button.add-to-cart")
    private WebElement addToCartButton;

    @FindBy(css = "div.current-price span:first-of-type")
    private WebElement priceTag;

    @FindBy(css = "h1.h1")
    private WebElement itemName;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage setQuantity(int newQuantity){
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(newQuantity));
        return this;
    }

    public void addToBasket(){
        addToCartButton.click();
    }

    public double getPrice(){
        return Double.parseDouble(priceTag.getAttribute("content"));
    }

    public String getName(){
        return itemName.getText();
    }
}
