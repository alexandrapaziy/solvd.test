package com.solvd.test.mobile;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BoxPage extends AbstractPage {
    @FindBy(xpath = "//android.widget.Button[@content-desc='Add Card']")
    private ExtendedWebElement addCardButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc='%s']")
    private ExtendedWebElement cardElement;

    @FindBy(xpath = "//android.widget.Button[@content-desc='%s']")
    private ExtendedWebElement editCardButton;

    @FindBy(xpath = "//android.view.View[@content-desc='NewBox']/following-sibling::*[1]")
    private ExtendedWebElement settingsButton;

    @FindBy(xpath = "//android.widget.Button[contains(@content-desc, 'Delete')]")
    private ExtendedWebElement deleteButton;

    public BoxPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBoxPageOpen() {
        return addCardButton.isElementPresent();
    }

    public AddCardPage clickOnAddCardButton() {
        addCardButton.click();
        return new AddCardPage(getDriver());
    }

    public boolean isCardWithThisNamePresent(String name) {
        return cardElement.format(name).isElementPresent();
    }

    public EditCardPage clickOnEditCardButtonWithThisName(String name) {
        editCardButton.format(name).click();
        return new EditCardPage(getDriver());
    }

    public void clickOnSettingsButton() {
        settingsButton.click();
    }

    public boolean isDeleteButtonPresent() {
        return deleteButton.isElementPresent();
    }

    public WelcomePage clickOnDeleteButton() {
        deleteButton.click();
        deleteButton.click();
        return new WelcomePage(getDriver());
    }
}