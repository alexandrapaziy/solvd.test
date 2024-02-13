package com.solvd.test.web.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MakePurchasePage extends AbstractPage {
    @FindBy(xpath = "//div[@data-price]")
    private ExtendedWebElement toPayField;

    public MakePurchasePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(toPayField);
    }

    public int getToPayPriceInt() {
        return Integer.parseInt(toPayField.getText().replaceAll("\\D", ""));
    }
}