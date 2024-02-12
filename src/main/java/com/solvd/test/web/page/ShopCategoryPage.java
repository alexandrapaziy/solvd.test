package com.solvd.test.web.page;

import com.solvd.test.web.component.ShopCategoryItemComponent;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopCategoryPage extends AbstractPage {
    @FindBy(xpath = "//section[@class='shop-category']")
    private List<ShopCategoryItemComponent> shopCategories;

    public ShopCategoryPage(WebDriver driver) {
        super(driver);
    }

    public ShopSubcategoryPage clickShopCategoryItemByName(String name) {
        for (ShopCategoryItemComponent shopCategoryItem : shopCategories) {
            if (shopCategoryItem.getShopCategoryItemText().equals(name)) {
                return shopCategoryItem.clickShopCategoryItem();
            }
        }
        return null;
    }
}