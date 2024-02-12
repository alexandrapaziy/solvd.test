package com.solvd.test.web.page;

import com.solvd.test.web.component.*;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//header[@class='header']")
    private HeaderComponent header;

    @FindBy(xpath = "//ul[@class='catalog-menu']")
    private CatalogComponent catalog;

    @FindBy(xpath = "//main")
    private BannerComponent regionalBanner;

    @FindBy(xpath = "//a[@class='banner-link']")
    private ExtendedWebElement banner;

    @FindBy(xpath = "//a[@class='vetrina__link']")
    private List<ExtendedWebElement> showcaseItems;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(banner);
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("web_url"));
        regionalBanner.clickCloseBannerButton();
    }

    public HeaderComponent getHeader() {
        return header;
    }

    public boolean isCatalogPresent() {
        return catalog.isUIObjectPresent();
    }

    public CatalogComponent getCatalog() {
        return catalog;
    }

    public ShopCategoryPage clickShowcaseItemName(String name) {
        for (ExtendedWebElement showcaseItem : showcaseItems) {
            if (showcaseItem.getText().toLowerCase().trim().equals(name.toLowerCase())) {
                showcaseItem.click();
                return new ShopCategoryPage(getDriver());
            }
        }
        return null;
    }
}