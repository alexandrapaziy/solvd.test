package com.solvd.test.web;

import com.solvd.test.web.component.*;
import com.solvd.test.web.page.*;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class EpicentrTests extends AbstractTest {

    private static final String USER_PHONE = R.TESTDATA.get("user_phone");
    private static final String USER_PASSWORD = R.TESTDATA.get("user_password");

    @Test
    public void verifyProductSearchTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getRegionalBanner().clickCloseBannerButton();

        SearchLineComponent searchLineComponent = homePage.getHeader().getSearchLineComponent();
        Assert.assertTrue(searchLineComponent.getSearchInput().isElementPresent(1), "Search input is not present");
        Assert.assertTrue(searchLineComponent.getSearchButton().isElementPresent(1), "Search button is not present");
        Assert.assertEquals(searchLineComponent.getSearchInputPlaceholder(), "Пошук", "Search input placeholder is incorrect");

        String brandName = "Apple";
        searchLineComponent.typeSearchInputData(brandName);
        SearchPage searchPage = searchLineComponent.clickSearchButton();
        Assert.assertTrue(searchPage.isPageOpened(), "Search page is not opened");

        Assert.assertTrue(getDriver().getCurrentUrl().contains(brandName.toLowerCase()), "Url does not contain the brand name");
        List<ProductCardComponent> productCards = searchPage.getProductCards();
        for (ProductCardComponent productCard : productCards) {
            Assert.assertTrue(productCard.getProductCardTitleText().toLowerCase().contains(brandName.toLowerCase()), "Product card title does not contain the brand name");
        }
    }

    @Test
    public void verifyAddToCartTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getRegionalBanner().clickCloseBannerButton();

        homePage.getHeader().clickCatalogOpenButton();
        ShopCategoryPage shopCategoryPage = homePage.getCatalog().clickCatalogItemByName("Електроніка");
        ShopSubcategoryPage shopSubcategoryPage = shopCategoryPage.clickShopCategoryItemByName("Мобільні телефони");
        SearchPage searchPage = shopSubcategoryPage.clickShopSubcategoryItemByName("Смартфони");

        ProductCardComponent productCard = searchPage.getProductCards().get(0);
        CartPage cartPage = productCard.clickOnCartButton();
        cartPage.clickOnCloseButton();
        productCard.clickOnCartButton();

        pause(5); // pause

        Assert.assertEquals(cartPage.getQuantityInputInt(), 2, "Cart has wrong quantity of the same goods");
    }

    @Test
    public void verifyDiscountFilterTest() {
        // not working
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getRegionalBanner().clickCloseBannerButton();

        ShopCategoryPage shopCategoryPage = homePage.clickShowcaseItemName("Електроніка");
        ShopSubcategoryPage shopSubcategoryPage = shopCategoryPage.clickShopCategoryItemByName("Мобільні телефони");
        SearchPage searchPage = shopSubcategoryPage.clickShopSubcategoryItemByName("Смартфони");

        searchPage.clickOnDiscountSortFilter();

        pause(5); // pause

        ProductCardComponent productCard = searchPage.getProductCards().get(0);
        int priceWithDiscount = productCard.getProductCardPriceWithDiscountTextInt();

        pause(5); // pause

        CartPage cartPage = productCard.clickOnCartButton();
        MakePurchasePage makePurchasePage = cartPage.clickOnMakePurchaseButton();
        Assert.assertTrue(priceWithDiscount == makePurchasePage.getToPayPriceInt(), "Product card price does not lower or equals the upper price limit");
    }

    @Test
    void verifyPriceFilterTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getRegionalBanner().clickCloseBannerButton();

        SearchLineComponent searchLineComponent = homePage.getHeader().getSearchLineComponent();
        Assert.assertTrue(searchLineComponent.getSearchInput().isElementPresent(1), "Search input is not present");
        Assert.assertTrue(searchLineComponent.getSearchButton().isElementPresent(1), "Search button is not present");
        Assert.assertEquals(searchLineComponent.getSearchInputPlaceholder(), "Пошук", "Search input placeholder is incorrect");

        String brandName = "Apple";
        searchLineComponent.typeSearchInputData(brandName);
        SearchPage searchPage = searchLineComponent.clickSearchButton();
        Assert.assertTrue(searchPage.isPageOpened(), "Search page is not opened");
        Assert.assertTrue(searchPage.getPriceFilterPanelComponent().getUpperPriceLimit().isElementPresent(1), "Some element is not present");

        int upperPriceLimit = 500;
        searchPage.getPriceFilterPanelComponent().typeUpperPriceLimit(String.valueOf(upperPriceLimit));

        pause(5); //pause

        List<ProductCardComponent> productCards = searchPage.getProductCards();
        for (ProductCardComponent productCard : productCards) {
            Assert.assertTrue(productCard.getProductCardPriceTextInt() <= upperPriceLimit, "Product card price does not lower or equals the upper price limit");
        }
    }

    @Test
    public void verifyLoginTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getRegionalBanner().clickCloseBannerButton();

        LoginPage loginPage = homePage.getHeader().clickLoginButton();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        Assert.assertTrue(loginPage.getPhoneInput().isElementPresent(1), "Phone input is not present");
        Assert.assertTrue(loginPage.getPasswordInput().isElementPresent(1), "Password input is not present");
        Assert.assertTrue(loginPage.getLoginButton().isElementPresent(1), "Login button is not present");
        Assert.assertEquals(loginPage.getPhoneInputPlaceholder(), "+38 (0XX) XXX-XX-XX", "Phone input placeholder is incorrect");
        Assert.assertEquals(loginPage.getPasswordInputPlaceholder(), "Мінімум 8 символів", "Password input placeholder is incorrect");

        homePage = loginPage.login(USER_PHONE, USER_PASSWORD);
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Assert.assertFalse(homePage.getHeader().getLoginButton().isElementPresent(1), "Login button is present");
    }
}