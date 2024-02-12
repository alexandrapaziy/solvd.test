package com.solvd.test.web.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopSubcategoryPage extends AbstractPage {
    @FindBy(xpath = "//li[contains(@class, 'shop-categories__block')]")
    private List<ExtendedWebElement> shopSubcategories;

    public ShopSubcategoryPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(shopSubcategories.get(0));
    }

    public SearchPage clickShopSubcategoryItemByName(String name) {
        for (ExtendedWebElement shopSubcategory : shopSubcategories) {
            if (shopSubcategory.getText().toLowerCase().trim().equals(name.toLowerCase())) {
                shopSubcategory.click();
                return new SearchPage(getDriver());
            }
        }
        return null;
    }
}