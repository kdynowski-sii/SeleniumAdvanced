package basketCheckoutTests;

import Base.TestBase;
import models.Product;
import models.ProductList;
import org.testng.annotations.Test;
import pages.HeaderUnsignedPage;
import pages.ProductAddedPopPupPage;
import pages.ProductPage;
import pages.ProductsRowPage;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class basketCheckoutTest extends TestBase {
    @Test
    public void basketCheckoutTest01() {
        driver.get("http://146.59.32.4/index.php");//TODO get link from file
        ProductPage productPage;
        ProductList list = new ProductList();
        String name;
        int quantity, cumulativeQuantity = 0;
        double price, totalCost;
        for (int i = 0; i < 5; i++) {
            new ProductsRowPage(driver).selectRandomProduct();//Calling every time to avoid null pointer exception
            productPage = new ProductPage(driver);
            name = productPage.getName();
            price = productPage.getPrice();
            quantity = new Random().nextInt(5) + 1;
            cumulativeQuantity += quantity;
            totalCost = price * quantity;
            Product product = new Product().setName(name)
                    .setPrice(price)
                    .setTotalCost(totalCost)
                    .setQuantity(quantity);
            if(list.productAlreadyIn(product)){
                list.increaseQuantity(product);
            } else{
                list.addProduct(product);
            }
            productPage.setQuantity(quantity)
                    .addToBasket();
            ProductAddedPopPupPage popup = new ProductAddedPopPupPage(driver, wait);
            System.out.println(popup.getCount());
            assertThat(popup.getCount()).isEqualTo(String.valueOf(cumulativeQuantity));
            popup.continueShopping();
            new HeaderUnsignedPage(driver).gotoMainPage();
        }
        new HeaderUnsignedPage(driver).gotoBasket();
        for (Product prod: list.getAddedProducts()) {
            System.out.println(prod);
        }

        //TODO Check if list of items has correct list of products and especially:
        // (name, price, quantity, total cost)
        // Assert total price
    }
}
