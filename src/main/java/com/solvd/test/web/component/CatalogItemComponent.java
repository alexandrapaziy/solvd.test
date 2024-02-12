package com.solvd.test.web.component;

import com.solvd.test.web.page.ShopCategoryPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CatalogItemComponent extends AbstractUIObject {
    @FindBy(xpath = ".//div[@class='catalog-menu__level-1-link']//a[@title]")
    private ExtendedWebElement catalogItemName;

    public CatalogItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getCatalogItemTitleText() {
        return catalogItemName.getAttribute("title").trim();
    }

    public ShopCategoryPage clickCatalogItemName() {
        catalogItemName.click();
        return new ShopCategoryPage(getDriver());
    }
}
