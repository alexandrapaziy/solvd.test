package com.solvd.test.web.component;

import com.solvd.test.web.page.CartPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductCardComponent extends AbstractUIObject {
    @FindBy(xpath = ".//a[text()]")
    private ExtendedWebElement cardTitle;

    @FindBy(xpath = ".//div[contains(@title, 'ціна:')]")
    private ExtendedWebElement price;

    @FindBy(xpath = ".//span[@class='card__price-sum']")
    private ExtendedWebElement priceWithDiscount;

    @FindBy(xpath = ".//button[@title='Купити']")
    private ExtendedWebElement cartButton;

    public ProductCardComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductCardTitleText() {
        return cardTitle.getText();
    }

    public int getProductCardPriceText() {
        return Integer.parseInt(price.getText().replaceAll("\\D", ""));
    }

    public int getProductCardPriceWithDiscountText() {
        return Integer.parseInt(priceWithDiscount.getText().replaceAll("\\D", ""));
    }

    public CartPage clickAddToCartButton() {
        waitUntil(ExpectedConditions.visibilityOf(cartButton), 10);
        cartButton.click();
        return new CartPage(getDriver());
    }
}
