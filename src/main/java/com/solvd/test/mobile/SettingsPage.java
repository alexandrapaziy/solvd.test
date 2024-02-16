package com.solvd.test.mobile;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends AbstractPage {
    @FindBy(xpath = "//android.view.View[contains(@content-desc, 'Your name')]")
    private ExtendedWebElement yourNameField;

    @FindBy(xpath = "//android.widget.EditText[@text]")
    private ExtendedWebElement yourNameTypingField;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Back']")
    private ExtendedWebElement backButton;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSettingsPageOpened() {
        return yourNameField.isElementPresent();
    }

    public void clickOnYourNameField() {
        yourNameField.click();
    }

    public String getYourNameTypingFieldText() {
        return yourNameTypingField.getText();
    }

    public WelcomePage clickOnBackButton() {
        backButton.click();
        return new WelcomePage(getDriver());
    }
}