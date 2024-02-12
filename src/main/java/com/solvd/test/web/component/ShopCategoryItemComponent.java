package com.solvd.test.web.component;

import com.solvd.test.web.page.ShopSubcategoryPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ShopCategoryItemComponent extends AbstractUIObject {
    @FindBy(xpath = ".//a[contains(@class, 'shop-category__title')]")
    private ExtendedWebElement shopCategoryItem;

    public ShopCategoryItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getShopCategoryItemText() {
        return shopCategoryItem.getText().trim();
    }

    public ShopSubcategoryPage clickShopCategoryItem() {
        shopCategoryItem.click();
        return new ShopSubcategoryPage(getDriver());
    }
}
