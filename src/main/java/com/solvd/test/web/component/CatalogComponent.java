package com.solvd.test.web.component;

import com.solvd.test.web.page.ShopCategoryPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogComponent extends AbstractUIObject {
    @FindBy(xpath = ".//li[@class='catalog-menu__level-1']//a[@class='menu-link']")
    private List<ExtendedWebElement> catalogItems;

    public CatalogComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ShopCategoryPage clickCatalogItemByName(String name) {
        for (ExtendedWebElement catalogItem : catalogItems) {
            if (catalogItem.getText().toLowerCase().trim().equals(name.toLowerCase())) {
                catalogItem.click();
                return new ShopCategoryPage(getDriver());
            }
        }
        return null;
    }
}