package com.solvd.test.mobile;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddBoxPage extends AbstractPage {
    @FindBy(xpath = "//android.widget.EditText")
    private ExtendedWebElement boxNameField;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Create Box']")
    private ExtendedWebElement createBoxButton;

    public AddBoxPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAddBoxPageOpen() {
        return createBoxButton.isElementPresent();
    }

    public void typeBoxName(String name) {
        boxNameField.click();
        boxNameField.type(name);
    }

    public String getBoxFieldText() {
        return boxNameField.getText();
    }

    public WelcomePage clickOnCreateBoxButton() {
        createBoxButton.click();
        return new WelcomePage(getDriver());
    }
}