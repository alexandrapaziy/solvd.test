package com.solvd.test.web.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopCategoryPage extends AbstractPage {
    @FindBy(xpath = "//a[contains(@class, 'shop-category__title')]")
    private List<ExtendedWebElement> shopCategories;

    public ShopCategoryPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(shopCategories.get(0));
    }

    public ShopSubcategoryPage clickShopCategoryItemByName(String name) {
        for (ExtendedWebElement shopCategory : shopCategories) {
            if (shopCategory.getText().toLowerCase().trim().equals(name.toLowerCase())) {
                shopCategory.click();
                return new ShopSubcategoryPage(getDriver());
            }
        }
        return null;
    }
}