package com.solvd.test.web.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//input[@name='login']")
    private ExtendedWebElement phoneInput;

    @FindBy(xpath = "//input[@name='password']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//form[@autocomplete]//button[text()='Увійти']")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginButton);
    }

    public ExtendedWebElement getLoginButton() {
        return loginButton;
    }

    public void typeLoginInfo(String phone, String password) {
        phoneInput.type(phone);
        passwordInput.type(password);
    }

    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage(getDriver());
    }

    public boolean isPhoneInputNotEmpty() {
        return phoneInput.getAttribute("value") != "";
    }

    public boolean isPasswordInputNotEmpty() {
        return passwordInput.getAttribute("value") != "";
    }
}
