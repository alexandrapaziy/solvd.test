package com.solvd.test.web.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class,'cart-popup')]//button[@title='Close']")
    private ExtendedWebElement closeButton;

    @FindBy(xpath = "//button[contains(text(), 'Оформити покупку')]")
    private ExtendedWebElement makePurchaseButton;

    @FindBy(xpath = "//div[@class='form-quantity']//input[@type='number']")
    private ExtendedWebElement quantityInput;

    public CartPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(makePurchaseButton);
    }

    public int getQuantityInputInt() {
        return Integer.parseInt(quantityInput.getAttribute("value"));
    }

    public MakePurchasePage clickOnMakePurchaseButton() {
        makePurchaseButton.click();
        return new MakePurchasePage(getDriver());
    }

    public void clickOnCloseButton() {
        closeButton.click();
    }
}