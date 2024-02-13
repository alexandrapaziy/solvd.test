package com.solvd.test.web.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ShopCategoryPage extends AbstractPage {
    @FindBy(xpath = "//a[contains(@class, 'shop-category__title') and contains(text(), '%s')]")
    private ExtendedWebElement shopCategory;

    @FindBy(xpath = "//header[@class='shop-categories__header']")
    private ExtendedWebElement shopCategoryPageTitle;


    public ShopCategoryPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(shopCategoryPageTitle);
    }

    public ShopSubcategoryPage clickShopCategoryItemByName(String title) {
        shopCategory.format(title).click();
        return new ShopSubcategoryPage(getDriver());
    }
}