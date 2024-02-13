package com.solvd.test.web.component;

import com.solvd.test.web.page.ShopCategoryPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CatalogComponent extends AbstractUIObject {
    @FindBy(xpath = ".//li[@class='catalog-menu__level-1']//a[@class='menu-link' and @title='%s']")
    private ExtendedWebElement catalogItem;

    public CatalogComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ShopCategoryPage clickCatalogItemByName(String title) {
        catalogItem.format(title).click();
        return new ShopCategoryPage(getDriver());
    }
}