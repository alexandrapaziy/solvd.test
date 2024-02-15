package com.solvd.test.mobile;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends AbstractPage {
    @FindBy(xpath = "//android.widget.Button[@content-desc='Add New Box']")
    private ExtendedWebElement addNewBoxButton;

    @FindBy(xpath = "//android.widget.Button[not(@content-desc)]")
    private ExtendedWebElement settingsButton;

    @FindBy(xpath = "//android.view.View[@content-desc='Hi, %s!']")
    private ExtendedWebElement hiTitle;

    @FindBy(xpath = "//android.view.View[contains(@content-desc, '%s')]")
    private ExtendedWebElement boxElement;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isWelcomePageOpened() {
        return addNewBoxButton.isElementPresent();
    }

    public AddBoxPage clickOnAddNewBoxButton() {
        addNewBoxButton.click();
        return new AddBoxPage(getDriver());
    }

    public SettingsPage clickOnSettingsButton() {
        settingsButton.click();
        return new SettingsPage(getDriver());
    }

    public String getTitleText(String title) {
        return hiTitle.format(title).getAttribute("content-desc");
    }

    public boolean isBoxWithThisNamePresent(String name) {
        return boxElement.format(name).isElementPresent();
    }

    public BoxPage clickOnBoxByName(String name) {
        boxElement.format(name).click();
        return new BoxPage(getDriver());
    }
}