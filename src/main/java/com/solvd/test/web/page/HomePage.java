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
    private List<ShowcaseItemComponent> showcaseItems;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(banner);
    }

    @Override
    public void open() {
        openURL(Configuration.getRequired("web_url"));
    }

    public HeaderComponent getHeader() {
        return header;
    }

    public CatalogComponent getCatalog() {
        return catalog;
    }

    public BannerComponent getRegionalBanner() {
        return regionalBanner;
    }

    public ShopCategoryPage clickShowcaseItemName(String name) {
        for (ShowcaseItemComponent showcaseItem : showcaseItems) {
            if (showcaseItem.getShowcaseItemNameText().trim().equals(name)) {
                return showcaseItem.clickShowcaseItemName();
            }
        }
        return null;
    }
}