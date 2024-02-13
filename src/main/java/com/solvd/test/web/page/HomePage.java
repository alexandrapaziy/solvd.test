package com.solvd.test.web.page;

import com.solvd.test.web.component.*;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(xpath = "//header[@class='header']")
    private HeaderComponent header;

    @FindBy(xpath = "//ul[@class='catalog-menu']")
    private CatalogComponent catalog;

    @FindBy(xpath = "//main")
    private BannerComponent regionalBanner;

    @FindBy(xpath = "//a[@class='banner-link']")
    private ExtendedWebElement banner;

    @FindBy(xpath = "//h3[contains(text(), '%s')]/../..")
    private ExtendedWebElement showcaseItem;

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

    public ShopCategoryPage clickShowcaseItemName(String title) {
        showcaseItem.format(title).click();
        return new ShopCategoryPage(getDriver());
    }
}