package pages.shopping;

import base.BasePage;
import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage extends BasePage {
    @FindBy(css = "li.cart-item")
    private List<WebElement> cartItems;

    public List<Product> getProductsInBasket() {
        return productsInBasket;
    }

    private final List<Product> productsInBasket;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        productsInBasket = new ArrayList<>();
        for (WebElement cartItem: cartItems) {
            productsInBasket.add(new ProductBasketPage(driver, cartItem).getProduct());
        }
    }
}
