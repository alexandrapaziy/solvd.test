package com.solvd.test.web.component;

import com.solvd.test.web.page.LoginPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbstractUIObject {
    @FindBy(xpath = ".//form[@data-is='Search']")
    private SearchLineComponent searchLineComponent;

    @FindBy(xpath = ".//div[@class='header__menu-opener-button']")
    private ExtendedWebElement catalogOpenButton;

    @FindBy(xpath = "//div[@class='header__login-opener']//span[@class='header__login-opener-text']//span[text()='Увійти']")
    private ExtendedWebElement loginButton;

    public HeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchLineComponent getSearchLineComponent() {
        return searchLineComponent;
    }

    public ExtendedWebElement getLoginButton() {
        return loginButton;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(getDriver());
    }

    public void clickCatalogOpenButton() {
        catalogOpenButton.click();
    }
}