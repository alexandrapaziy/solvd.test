package com.solvd.test.web.component;

import com.solvd.test.web.page.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ShopSubcategoryItemComponent extends AbstractUIObject {
    @FindBy(xpath = ".//span")
    private ExtendedWebElement shopSubcategoryItemName;

    @FindBy(xpath = ".//a")
    private ExtendedWebElement shopSubcategoryItem;

    public ShopSubcategoryItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getShopSubcategoryItemNameText() {
        return shopSubcategoryItemName.getText().trim();
    }

    public SearchPage clickShopSubcategoryItem() {
        shopSubcategoryItem.click();
        return new SearchPage(getDriver());
    }
}