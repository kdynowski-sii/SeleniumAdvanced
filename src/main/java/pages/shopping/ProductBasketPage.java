package pages.shopping;

import base.BasePage;
import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductBasketPage extends BasePage {
    private final WebElement cartItem;
    @SuppressWarnings("FieldMayBeFinal")
    private Product product;
    public ProductBasketPage(WebDriver driver, WebElement cartItem) {
        super(driver);
        this.cartItem = cartItem;
        product = new Product();
    }

    public Product getProduct(){
        return product.setName(getName())
                .setPrice(getPrice())
                .setQuantity(getQuantity())
                .setTotalCost(getTotalCost());
    }

    private String getTotalCost() {
        return cartItem.findElement(By.cssSelector("span.product-price strong")).getText().substring(1);
    }

    private int getQuantity() {
        return Integer.parseInt(
                cartItem.findElement(By.cssSelector("div.product-line-grid input")).getAttribute("value"));
    }

    private String getPrice() {
        return cartItem.findElement(
                        By.cssSelector("div.product-line-grid span.price"))
                        .getText()
                        .substring(1);
    }

    private String getName() {
        return cartItem.findElement(By.cssSelector("div.product-line-grid a.label")).getText();
    }
}
