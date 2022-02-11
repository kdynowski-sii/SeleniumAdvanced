package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductsRowPage extends BasePage {
    @FindBy(css = "article.product-miniature > div > a")
    List<WebElement> productImageLinks;

    public ProductsRowPage(WebDriver driver) {
        super(driver);
    }

    public void selectRandomProduct() {
        assertThat(productImageLinks).isNotNull();
        assertThat(productImageLinks.get(0)).isNotNull();
        productImageLinks.get(Math.abs(new Random().nextInt() % productImageLinks.size())).click();
    }
}
