package pages.common;

import base.BasePage;
import enums.Categories;
import enums.Subcategory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HeaderUnsignedPage extends BasePage {
    @FindBy(css = "div.user-info a")
    private WebElement signInLink;

    @FindBy(css = "#_desktop_logo a")
    private WebElement mainPageLink;

    @FindBy(css = "div.header a")
    private WebElement basketLink;

    @FindBy(css = "#top-menu > li > a")
    private List<WebElement> categoryLinks;

    @FindAll({
            @FindBy(id = "category-4"),
            @FindBy(id = "category-5"),
            @FindBy(id = "category-7"),
            @FindBy(id = "category-8")
    })
    private List<WebElement> subCategories;

    public HeaderUnsignedPage(WebDriver driver) {
        super(driver);
    }

    public void gotoBasket() {
        basketLink.click();
    }

    public void gotoMainPage() {
        mainPageLink.click();
    }

    public void goToSubCategory(Subcategory sub) {
        switch (sub) {
            case MEN:
                waitAndClickSub(0, 0);
                break;
            case WOMEN:
                waitAndClickSub(0, 1);
                break;
            case STATIONERY:
                waitAndClickSub(1, 2);
                break;
            case HOMEACCESSORIES:
                waitAndClickSub(1, 3);
                break;
        }
    }

    private void waitAndClickSub(int catId, int subId) {
        actionMaker.moveToElement(categoryLinks.get(catId));
        actionMaker.perform();
        wait.until(ExpectedConditions.visibilityOf(subCategories.get(subId)));
        subCategories.get(subId).click();
    }

    public void clickSignIn() {
        signInLink.click();
    }

    public void goToCategory(Categories category) {
        switch (category) {
            case CLOTHES:
                categoryLinks.get(0).click();
                break;
            case ACCESSORIES:
                categoryLinks.get(1).click();
                break;
            case ART:
                categoryLinks.get(2).click();
        }
    }
}
