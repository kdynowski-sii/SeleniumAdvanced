package filteringShoppingTests;

import Base.TestBase;
import enums.Categories;
import enums.Subcategory;
import helpers.Screenshots;
import models.Product;
import models.User;
import models.UserFactory;
import org.testng.annotations.Test;
import pages.authentication.checkout.CheckoutForm;
import pages.authentication.checkout.ConfirmationPage;
import pages.common.HeaderUnsignedPage;
import pages.shopping.ProductAddedPopPupPage;
import pages.shopping.ProductPage;
import pages.shopping.ProductsRowPage;
import pages.shopping.ShoppingCartPage;

import java.util.Random;

import static helpers.Screenshots.takeScreenshot;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ShoppingCategoriesTest extends TestBase {
    @Test
    public void countInCategories() {
        driver.get(testConfig.getUrl());
        // iterate over categories
        Categories categories[] = Categories.values();

        for (Categories category : categories) {
            new HeaderUnsignedPage(driver).goToCategory(category);
            takeScreenshot(driver, "countInCategories" + category);
            ProductsRowPage page = new ProductsRowPage(driver);
            assertThat(page.getNumberOfProductsFromGrid())
                    .isEqualTo(page.getNumberOfProductsFromParagraph());
            assertThat(page.getCategoryName()).isEqualToIgnoringCase(category.toString());
        }

        for (Subcategory sub : Subcategory.values()) {
            new HeaderUnsignedPage(driver).goToSubCategory(sub);
            takeScreenshot(driver, "countInCategories" + sub);
            ProductsRowPage page = new ProductsRowPage(driver);
            assertThat(page.getNumberOfProductsFromGrid())
                    .isEqualTo(page.getNumberOfProductsFromParagraph());
            assertThat(page.getCategoryName().replace(" ", "")).isEqualToIgnoringCase(sub.toString());
        }
    }

    @Test
    public void buyOne() {
        driver.get(testConfig.getUrl());
        ProductPage productPage;
        String name;
        // no usage of param. constructor, have to use setters, builder style
        Product product = new Product();
        int quantity;  // info needed later to assert correctness
        double price;
        // Selecting a random product on a page
        new ProductsRowPage(driver).selectRandomProduct();

        // Time to handle product page, get its attributes
        productPage = new ProductPage(driver);
        price = productPage.getPrice();
        quantity = new Random().nextInt(5) + 1;
        product.setName(productPage.getName())
                .setPrice(price)
                .setTotalCost(price * quantity)
                .setQuantity(quantity);

        productPage.setQuantity(quantity)
                .addToBasket(); // adding to basket
        ProductAddedPopPupPage popup = new ProductAddedPopPupPage(driver, wait);
        // Going to checkout through a popup
        popup.goToCheckout();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        assertThat(
                shoppingCartPage
                        .getProductsInBasket()
                        .get(0)
                        .toString())
                .isEqualToIgnoringCase(
                        product.toString());

        // Now finish the order, pay and assert that is correct in the history
        shoppingCartPage.proceed();
        User user = new UserFactory().getUser(false);
        CheckoutForm form = new CheckoutForm(driver, user);
        form.fillForm();
        Screenshots.takeScreenshot(driver, "FilledForm!");
        String output = new ConfirmationPage(driver).getValidationMessage();
        assertThat(output).containsIgnoringCase("order is confirmed");
        // TODO assert if products are correct
    }
}
