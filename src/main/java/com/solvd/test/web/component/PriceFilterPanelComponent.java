package com.solvd.test.web.component;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PriceFilterPanelComponent extends AbstractUIObject {

    @FindBy(xpath = "(//div[text()='Ціна']/following-sibling::*//input)[2]")
    private ExtendedWebElement upperPriceLimit;

    public PriceFilterPanelComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getUpperPriceLimit() {
        return upperPriceLimit;
    }

    public void typeUpperPriceLimit(String data) {
        type(upperPriceLimit, data);
    }

    public static void type(ExtendedWebElement element, String string) {
        element.assertElementPresent(5);
        String text = element.getAttribute("value");
        if (text != null && !text.isEmpty()) {
            while (!element.getAttribute("value").isEmpty()) {
                element.getElement().sendKeys("");
                element.getElement().sendKeys(Keys.BACK_SPACE);
            }
        }
        element.type(string);
    }
}