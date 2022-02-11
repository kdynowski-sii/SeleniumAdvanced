package basketCheckoutTests;

import Base.TestBase;
import models.Product;
import models.ProductList;
import org.testng.annotations.Test;
import pages.common.HeaderUnsignedPage;
import pages.shopping.ProductAddedPopPupPage;
import pages.shopping.ProductPage;
import pages.shopping.ProductsRowPage;
import pages.shopping.ShoppingCartPage;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestShoppingBasket extends TestBase {
    @Test
    public void basketCheckoutFirstTest() {
        driver.get(testConfig.getUrl());
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
            if (list.productAlreadyIn(product)) {
                list.increaseQuantity(product);
            } else {
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
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        for (int i = 0; i < list.getAddedProducts().size(); i++) {
            // Given the order is the same - which it should be provided that cookies are deleted
            assertThat(
                    shoppingCartPage
                            .getProductsInBasket()
                            .get(i)
                            .toString())
                    .isEqualToIgnoringCase(
                            list.getAddedProducts()
                                    .get(i)
                                    .toString());
        }
    }
}
