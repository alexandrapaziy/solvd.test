package com.solvd.test.mobile;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EditCardPage extends AbstractPage {
    @FindBy(xpath = "//android.widget.Button[@content-desc='Delete Card']")
    private ExtendedWebElement deleteCardButton;

    public EditCardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEditCardPageOpen() {
        return deleteCardButton.isElementPresent();
    }

    public BoxPage clickOnDeleteCardButton() {
        deleteCardButton.click();
        return new BoxPage(getDriver());
    }
}
