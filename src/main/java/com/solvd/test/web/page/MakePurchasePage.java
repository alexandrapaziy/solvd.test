package com.solvd.test.web.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MakePurchasePage extends AbstractPage {
    @FindBy(xpath = "//div[@data-price]")
    private ExtendedWebElement toPay;

    public MakePurchasePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(toPay);
    }

    public int getToPayPriceInt() {
        return Integer.parseInt(toPay.getText().replaceAll("\\D", ""));
    }
}