package com.solvd.test.web.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ShopSubcategoryPage extends AbstractPage {
    @FindBy(xpath = "//span[contains(text(), '%s')]/../preceding-sibling::*")
    private ExtendedWebElement shopSubcategories;

    @FindBy(xpath = "//header[@class='shop-categories__header']")
    private ExtendedWebElement shopSubcategoryPageTitle;

    public ShopSubcategoryPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(shopSubcategoryPageTitle);
    }

    public SearchPage clickShopSubcategoryItemByName(String title) {
        shopSubcategories.format(title).click();
        return new SearchPage(getDriver());
    }
}