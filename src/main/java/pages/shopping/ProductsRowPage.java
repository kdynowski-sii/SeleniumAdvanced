package pages.shopping;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductsRowPage extends BasePage {
    @FindBy(css = "article.product-miniature > div > a")
    private List<WebElement> productImageLinks;

    @FindBy(css = "div.total-products p")
    private WebElement totalProductsParagraph;

    @FindBy(css = "nav.breadcrumb li > span")
    private WebElement categoryName;

    public ProductsRowPage(WebDriver driver) {
        super(driver);
    }

    public void selectRandomProduct() {
        assertThat(productImageLinks).isNotNull();
        assertThat(productImageLinks.get(0)).isNotNull();
        productImageLinks.get(Math.abs(new Random().nextInt() % productImageLinks.size())).click();
    }

    public int getNumberOfProductsFromGrid(){
        return productImageLinks.size();
    }

    public String getCategoryName(){
        return categoryName.getText();
    }

    public int getNumberOfProductsFromParagraph(){
        String howMany;
        if (totalProductsParagraph.getText().contains("is")){
            howMany = totalProductsParagraph.getText().substring(9);

        }
        else {
            howMany = totalProductsParagraph.getText().substring(10);
        }
        howMany = howMany.substring(0, howMany.lastIndexOf(' '));
        return Integer.parseInt(howMany);

    }
}
