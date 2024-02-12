package com.solvd.test.web.component;

import com.solvd.test.web.page.ShopCategoryPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ShowcaseItemComponent extends AbstractUIObject {
    @FindBy(xpath = ".//h3[@class='vetrina__headline']")
    private ExtendedWebElement showcaseItemName;

    public ShowcaseItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getShowcaseItemNameText() {
        return showcaseItemName.getText().trim();
    }

    public ShopCategoryPage clickShowcaseItemName() {
        showcaseItemName.click();
        return new ShopCategoryPage(getDriver());
    }
}