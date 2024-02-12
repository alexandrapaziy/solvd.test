package com.solvd.test.web.component;

import com.solvd.test.web.page.LoginPage;
import com.solvd.test.web.page.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbstractUIObject {

    @FindBy(xpath = ".//input[@placeholder='Пошук']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = ".//input/following-sibling::button[2]")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = ".//div[@class='header__menu-opener-button']")
    private ExtendedWebElement catalogOpenButton;

    @FindBy(xpath = "//span[text()='Увійти']")
    private ExtendedWebElement loginButton;

    public HeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeSearchInputData(String data) {
        searchInput.type(data);
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return new SearchPage(getDriver());
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(getDriver());
    }

    public void clickCatalogOpenButton() {
        catalogOpenButton.click();
    }

    public boolean isLoginButtonNotPresent() {
        return loginButton.isElementNotPresent(10);
    }

    public boolean isSearchInputEmpty() {
        return searchInput.getAttribute("value") != "";
    }
}