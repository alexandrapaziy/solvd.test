package com.solvd.test.mobile;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeitnerBoxTests extends AbstractTest implements IMobileUtils {
    private static final String BOX_NAME = "Animals";
    private static final String FRONT_SIDE = "Cat";
    private static final String BACK_SIDE = "An animal with four legs";

    @Test
    public void verifyYourNameInWelcomeTitleTest() {
        startApp("com.floor57.leitnerbox");

        WelcomePage welcomePage = new WelcomePage(getDriver());
        Assert.assertTrue(welcomePage.isWelcomePageOpen(), "Welcome page is not open");

        SettingsPage settingsPage = welcomePage.clickOnSettingsButton();
        Assert.assertTrue(settingsPage.isSettingsPageOpen(), "Settings page is not open");

        settingsPage.clickOnYourNameField();
        String yourName = settingsPage.getYourNameTypingFieldText();
        Assert.assertNotEquals("", yourName, "Name is not taken");

        welcomePage = settingsPage.clickOnBackButton();
        Assert.assertTrue(welcomePage.isWelcomePageOpen(), "Welcome page is not open");

        String welcomeTitle = welcomePage.getTitleText(yourName);
        Assert.assertEquals(welcomeTitle, "Hi, " + yourName + "!", "Name in welcome title is not correct");
    }

    @Test()
    public void verifyNewBoxCreatingTest() {
        startApp("com.floor57.leitnerbox");

        WelcomePage welcomePage = new WelcomePage(getDriver());
        Assert.assertTrue(welcomePage.isWelcomePageOpen(), "Welcome page is not open");

        AddBoxPage addNewBoxPage = welcomePage.clickOnAddNewBoxButton();
        Assert.assertTrue(addNewBoxPage.isAddBoxPageOpen(), "Add new box page is not open");

        addNewBoxPage.typeBoxName(BOX_NAME);
        Assert.assertEquals(addNewBoxPage.getBoxFieldText(), BOX_NAME, "Box name is not typed");

        welcomePage = addNewBoxPage.clickOnCreateBoxButton();
        Assert.assertTrue(welcomePage.isWelcomePageOpen(), "Welcome page is not open");

        Assert.assertTrue(welcomePage.isBoxWithThisNamePresent(BOX_NAME));
    }

    @Test
    public void verifyAddNewCardsToBoxTest() {
        startApp("com.floor57.leitnerbox");

        WelcomePage welcomePage = new WelcomePage(getDriver());
        Assert.assertTrue(welcomePage.isWelcomePageOpen(), "Welcome page is not open");
        Assert.assertTrue(welcomePage.isBoxWithThisNamePresent(BOX_NAME));

        BoxPage boxPage = welcomePage.clickOnBoxWithThisName(BOX_NAME);
        Assert.assertTrue(boxPage.isBoxPageOpen(), "Box page is not open");

        AddCardPage addCardPage = boxPage.clickOnAddCardButton();
        Assert.assertTrue(addCardPage.isAddCardPageOpen(), "Add card page is not open");

        addCardPage.typeCardFrontSide(FRONT_SIDE);
        Assert.assertEquals(addCardPage.getCardFrontSideText(), FRONT_SIDE, "Front side text is not typed");
        addCardPage.typeCardBackSide(BACK_SIDE);
        Assert.assertEquals(addCardPage.getCardBackSideText(), BACK_SIDE, "Back side text is not typed");

        boxPage = addCardPage.clickOnDoneButton();
        Assert.assertTrue(boxPage.isBoxPageOpen(), "Box page is not open");

        Assert.assertTrue(boxPage.isCardWithThisNamePresent(FRONT_SIDE));
    }

    @Test
    public void verifyDeleteCardFromBoxTest() {
        startApp("com.floor57.leitnerbox");

        WelcomePage welcomePage = new WelcomePage(getDriver());
        Assert.assertTrue(welcomePage.isWelcomePageOpen(), "Welcome page is not open");
        Assert.assertTrue(welcomePage.isBoxWithThisNamePresent(BOX_NAME));

        BoxPage boxPage = welcomePage.clickOnBoxWithThisName(BOX_NAME);
        Assert.assertTrue(boxPage.isBoxPageOpen(), "Box page is not open");

        EditCardPage editCardPage = boxPage.clickOnEditCardButtonWithThisName(FRONT_SIDE);
        Assert.assertTrue(editCardPage.isEditCardPageOpen(), "Edit card page is not open");

        boxPage = editCardPage.clickOnDeleteCardButton();
        Assert.assertTrue(boxPage.isBoxPageOpen(), "Box page is not open");
        Assert.assertFalse(boxPage.isCardWithThisNamePresent(FRONT_SIDE), "Card is still present");
    }

    @Test
    public void verifyDeleteBoxTest() {
        startApp("com.floor57.leitnerbox");

        WelcomePage welcomePage = new WelcomePage(getDriver());
        Assert.assertTrue(welcomePage.isWelcomePageOpen(), "Welcome page is not open");
        Assert.assertTrue(welcomePage.isBoxWithThisNamePresent(BOX_NAME));

        BoxPage boxPage = welcomePage.clickOnBoxWithThisName(BOX_NAME);
        Assert.assertTrue(boxPage.isBoxPageOpen(), "Box page is not open");

        boxPage.clickOnSettingsButton();
        Assert.assertTrue(boxPage.isDeleteButtonPresent(), "Delete button is not present");

        welcomePage = boxPage.clickOnDeleteButton();
        Assert.assertTrue(welcomePage.isWelcomePageOpen(), "Welcome page is not open");

        Assert.assertFalse(welcomePage.isBoxWithThisNamePresent(BOX_NAME), "Box is still present");
    }
}