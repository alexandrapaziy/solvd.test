package com.solvd.test.web.component;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BannerComponent extends AbstractUIObject {
    @FindBy(xpath = ".//div[@data-is='RegionalBanner']//div[@class='_lf1rdL']")
    private ExtendedWebElement closeBannerButton;

    public BannerComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickCloseBannerButton(){
        closeBannerButton.click();
    }
}