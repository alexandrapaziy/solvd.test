package com.solvd.test.mobile;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LeitnerBoxTests extends AbstractTest implements IMobileUtils {
    private static final String BOX_NAME = "Animals";
    private static final String FRONT_SIDE = "Cat";
    private static final String BACK_SIDE = "An animal with four legs";

    @BeforeTest
    public void beforeTest() {
        startApp("com.floor57.leitnerbox");
    }

    @Test
    public void verifyYourNameInWelcomeTitleTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        Assert.assertTrue(welcomePage.isWelcomePageOpened(), "Welcome page is not opened");

        SettingsPage settingsPage = welcomePage.clickOnSettingsButton();
        Assert.assertTrue(settingsPage.isSettingsPageOpened(), "Settings page is not opened");

        settingsPage.clickOnYourNameField();
        String yourName = settingsPage.getYourNameTypingFieldText();
        Assert.assertNotEquals("", yourName, "Name is not taken");

        welcomePage = settingsPage.clickOnBackButton();
        Assert.assertTrue(welcomePage.isWelcomePageOpened(), "Welcome page is not opened");

        String welcomeTitle = welcomePage.getTitleText(yourName);
        Assert.assertEquals(welcomeTitle, "Hi, " + yourName + "!", "Name in welcome title is not correct");
    }

    @Test
    public void verifyNewBoxCreatingTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        Assert.assertTrue(welcomePage.isWelcomePageOpened(), "Welcome page is not opened");

        AddBoxPage addNewBoxPage = welcomePage.clickOnAddNewBoxButton();
        Assert.assertTrue(addNewBoxPage.isAddBoxPageOpened(), "Add new box page is not opened");

        addNewBoxPage.typeBoxName(BOX_NAME);
        Assert.assertEquals(addNewBoxPage.getBoxFieldText(), BOX_NAME, "Box name is not typed");

        welcomePage = addNewBoxPage.clickOnCreateBoxButton();
        Assert.assertTrue(welcomePage.isWelcomePageOpened(), "Welcome page is not opened");

        Assert.assertTrue(welcomePage.isBoxWithThisNamePresent(BOX_NAME), "Box is not present");
    }

    @Test
    public void verifyAddNewCardsToBoxTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        Assert.assertTrue(welcomePage.isWelcomePageOpened(), "Welcome page is not opened");
        Assert.assertTrue(welcomePage.isBoxWithThisNamePresent(BOX_NAME), "Box is not present");

        BoxPage boxPage = welcomePage.clickOnBoxByName(BOX_NAME);
        Assert.assertTrue(boxPage.isBoxPageOpened(), "Box page is not opened");

        AddCardPage addCardPage = boxPage.clickOnAddCardButton();
        Assert.assertTrue(addCardPage.isAddCardPageOpened(), "Add card page is not opened");

        addCardPage.typeCardFrontSide(FRONT_SIDE);
        Assert.assertEquals(addCardPage.getCardFrontSideText(), FRONT_SIDE, "Front side text is not typed");
        addCardPage.typeCardBackSide(BACK_SIDE);
        Assert.assertEquals(addCardPage.getCardBackSideText(), BACK_SIDE, "Back side text is not typed");

        boxPage = addCardPage.clickOnDoneButton();
        Assert.assertTrue(boxPage.isBoxPageOpened(), "Box page is not opened");

        Assert.assertTrue(boxPage.isCardPresentByName(FRONT_SIDE), "Card is not present");
    }

    @Test
    public void verifyDeleteCardFromBoxTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        Assert.assertTrue(welcomePage.isWelcomePageOpened(), "Welcome page is not opened");
        Assert.assertTrue(welcomePage.isBoxWithThisNamePresent(BOX_NAME), "Box is not present");

        BoxPage boxPage = welcomePage.clickOnBoxByName(BOX_NAME);
        Assert.assertTrue(boxPage.isBoxPageOpened(), "Box page is not opened");

        EditCardPage editCardPage = boxPage.clickOnEditCardButtonByName(FRONT_SIDE);
        Assert.assertTrue(editCardPage.isEditCardPageOpened(), "Edit card page is not opened");

        boxPage = editCardPage.clickOnDeleteCardButton();
        Assert.assertTrue(boxPage.isBoxPageOpened(), "Box page is not opened");
        Assert.assertFalse(boxPage.isCardPresentByName(FRONT_SIDE), "Card is still present");
    }

    @Test
    public void verifyDeleteBoxTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        Assert.assertTrue(welcomePage.isWelcomePageOpened(), "Welcome page is not opened");
        Assert.assertTrue(welcomePage.isBoxWithThisNamePresent(BOX_NAME), "Box is not present");

        BoxPage boxPage = welcomePage.clickOnBoxByName(BOX_NAME);
        Assert.assertTrue(boxPage.isBoxPageOpened(), "Box page is not opened");

        boxPage.clickOnSettingsButton();
        Assert.assertTrue(boxPage.isDeleteButtonPresent(), "Delete button is not present");

        welcomePage = boxPage.clickOnDeleteButton();
        Assert.assertTrue(welcomePage.isWelcomePageOpened(), "Welcome page is not opened");

        Assert.assertFalse(welcomePage.isBoxWithThisNamePresent(BOX_NAME), "Box is still present");
    }

    @AfterTest
    public void afterTest() {
        terminateApp("com.floor57.leitnerbox");
    }
}