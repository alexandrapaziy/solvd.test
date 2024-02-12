package com.solvd.test.web.page;

import com.solvd.test.web.component.ShopSubcategoryItemComponent;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopSubcategoryPage extends AbstractPage {
    @FindBy(xpath = "//li[contains(@class, 'shop-categories__block')]")
    private List<ShopSubcategoryItemComponent> shopSubcategories;

    public ShopSubcategoryPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage clickShopSubcategoryItemByName(String name) {
        for (ShopSubcategoryItemComponent shopSubcategoryItem : shopSubcategories) {
            if (shopSubcategoryItem.getShopSubcategoryItemNameText().equals(name)) {
                return shopSubcategoryItem.clickShopSubcategoryItem();
            }
        }
        return null;
    }

}