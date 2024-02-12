package com.solvd.test.web.page;

import com.solvd.test.web.component.ProductCardComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='card__info']")
    private List<ProductCardComponent> productCards;

    @FindBy(xpath = "//a[@data-href='aktsii']")
    private ExtendedWebElement discountSortFilter;

    @FindBy(xpath = "(//div[text()='Ціна']/following-sibling::*//input)[2]")
    private ExtendedWebElement upperPriceLimit;

    @FindBy(xpath = "//div[contains(@class,'_Y7IP')]")
    private ExtendedWebElement loading;

    @FindBy(xpath = "//main")
    private ExtendedWebElement main;

    public SearchPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(main);
    }

    public List<ProductCardComponent> getProductCards() {
        return productCards;
    }

    public void clickOnDiscountSortFilter() {
        discountSortFilter.click();
        waitLoading();
    }

    public void typeUpperPriceLimit(String data) {
        type(upperPriceLimit, data);
        waitLoading();
    }

    public boolean isUpperPriceLimitEmpty() {
        return upperPriceLimit.getText() != "";
    }

    public boolean isDiscountSortFilterActive() {
        String classAttribute = discountSortFilter.getAttribute("class");
        return classAttribute != null && classAttribute.contains("active");
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

    public void waitLoading() {
        waitUntil(ExpectedConditions.visibilityOf(loading), 10);
        waitUntil(ExpectedConditions.invisibilityOf(loading), 10);
    }
}