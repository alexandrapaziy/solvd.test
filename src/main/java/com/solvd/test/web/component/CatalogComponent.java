package com.solvd.test.web.component;

import com.solvd.test.web.page.ShopCategoryPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogComponent extends AbstractUIObject {
    @FindBy(xpath = ".//li[@class='catalog-menu__level-1']")
    private List<CatalogItemComponent> catalogItems;

    public CatalogComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ShopCategoryPage clickCatalogItemByName(String name) {
        for (CatalogItemComponent catalogItem : catalogItems) {
            if (catalogItem.getCatalogItemTitleText().equals(name)) {
                return catalogItem.clickCatalogItemName();
            }
        }
        return null;
    }
}