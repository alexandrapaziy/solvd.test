package com.solvd.test.mobile;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddCardPage extends AbstractPage {
    @FindBy(xpath = "//android.view.View[@content-desc='Front Side']/following-sibling::*[1]")
    private ExtendedWebElement frontSideField;

    @FindBy(xpath = "//android.view.View[@content-desc='Back Side']/following-sibling::*[1]")
    private ExtendedWebElement backSideField;

    @FindBy(xpath = "//android.view.View[@content-desc='Add New Card']/following-sibling::*[1]")
    private ExtendedWebElement doneButton;

    public AddCardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAddCardPageOpened() {
        return frontSideField.isElementPresent();
    }

    public void typeCardFrontSide(String text) {
        frontSideField.click();
        frontSideField.type(text);
    }

    public String getCardFrontSideText() {
        return frontSideField.getText();
    }

    public void typeCardBackSide(String text) {
        backSideField.click();
        backSideField.type(text);
    }

    public String getCardBackSideText() {
        return backSideField.getText();
    }

    public BoxPage clickOnDoneButton() {
        doneButton.click();
        return new BoxPage(getDriver());
    }
}
