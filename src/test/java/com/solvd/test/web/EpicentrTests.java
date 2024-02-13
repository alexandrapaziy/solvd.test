package com.solvd.test.web;

import com.solvd.test.web.component.*;
import com.solvd.test.web.page.*;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EpicentrTests extends AbstractTest {
    private static final String USER_PHONE = R.TESTDATA.get("user_phone");
    private static final String USER_PASSWORD = R.TESTDATA.get("user_password");
    private static final String BRAND_NAME = "Apple";
    private static final String CATALOG_ITEM_NAME = "Електроніка";
    private static final String SHOP_CATEGORY_ITEM_NAME = "Мобільні телефони";
    private static final String SHOP_SUBCATEGORY_ITEM_NAME = "Смартфони";

    @Test
    public void verifyProductSearchTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.getHeader().typeSearchInputData(BRAND_NAME);
        Assert.assertTrue(homePage.getHeader().isSearchInputNotEmpty(), "Search input is empty");

        SearchPage searchPage = homePage.getHeader().clickSearchButton();
        Assert.assertTrue(searchPage.isPageOpened(), "Search page is not opened");

        List<ProductCardComponent> productCards = searchPage.getProductCards();
        for (ProductCardComponent productCard : productCards) {
            Assert.assertTrue(productCard.getProductCardTitleText().toLowerCase().contains(BRAND_NAME.toLowerCase()), "Product card title does not contain the brand name");
        }
    }

    @Test
    public void verifyAddToCartTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.getHeader().clickCatalogOpenButton();
        Assert.assertTrue(homePage.isCatalogPresent(), "Catalog is not present");

        ShopCategoryPage shopCategoryPage = homePage.getCatalog().clickCatalogItemByName(CATALOG_ITEM_NAME);
        Assert.assertTrue(shopCategoryPage.isPageOpened(), "Shop category page is not open");
        ShopSubcategoryPage shopSubcategoryPage = shopCategoryPage.clickShopCategoryItemByName(SHOP_CATEGORY_ITEM_NAME);
        Assert.assertTrue(shopSubcategoryPage.isPageOpened(), "Shop subcategory page is not open");
        SearchPage searchPage = shopSubcategoryPage.clickShopSubcategoryItemByName(SHOP_SUBCATEGORY_ITEM_NAME);
        Assert.assertTrue(searchPage.isPageOpened(), "Search page is not open");

        ProductCardComponent productCard = searchPage.getProductCards().get(0);
        CartPage cartPage = productCard.clickAddToCartButton();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not open");
        cartPage.clickOnCloseButton();
        Assert.assertFalse(cartPage.isMakePurchaseButtonNotPresent(), "Cart page is open");
        productCard.clickAddToCartButton();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not open");

        Assert.assertEquals(cartPage.getQuantityInputText(), 2, "Cart has wrong quantity of the same goods");
    }

    @Test
    public void verifyDiscountFilterTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        ShopCategoryPage shopCategoryPage = homePage.clickShowcaseItemName(CATALOG_ITEM_NAME);
        Assert.assertTrue(shopCategoryPage.isPageOpened(), "Shop category page is not open");
        ShopSubcategoryPage shopSubcategoryPage = shopCategoryPage.clickShopCategoryItemByName(SHOP_CATEGORY_ITEM_NAME);
        Assert.assertTrue(shopSubcategoryPage.isPageOpened(), "Shop subcategory page is not open");
        SearchPage searchPage = shopSubcategoryPage.clickShopSubcategoryItemByName(SHOP_SUBCATEGORY_ITEM_NAME);
        Assert.assertTrue(searchPage.isPageOpened(), "Search page is not open");

        searchPage.clickOnDiscountSortFilter();
        Assert.assertTrue(searchPage.isDiscountSortFilterActive(), "SDiscount sort filter is not active");

        ProductCardComponent productCard = searchPage.getProductCards().get(0);
        int priceWithDiscount = productCard.getProductCardPriceWithDiscountText();

        CartPage cartPage = productCard.clickAddToCartButton();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not open");
        MakePurchasePage makePurchasePage = cartPage.clickOnMakePurchaseButton();
        Assert.assertTrue(makePurchasePage.isPageOpened(), "Make purchase page is not open");
        Assert.assertEquals(priceWithDiscount, makePurchasePage.getToPayPriceInt(), "Product card price does not lower or equals the upper price limit");
    }

    @Test
    void verifyPriceFilterTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.getHeader().typeSearchInputData(BRAND_NAME);
        Assert.assertTrue(homePage.getHeader().isSearchInputNotEmpty(), "Search input is empty");

        SearchPage searchPage = homePage.getHeader().clickSearchButton();
        Assert.assertTrue(searchPage.isPageOpened(), "Search page is not opened");

        int upperPriceLimit = 500;
        searchPage.typeUpperPriceLimit(String.valueOf(upperPriceLimit));
        Assert.assertFalse(searchPage.isUpperPriceLimitEmpty(), "Upper price limit is empty");

        List<ProductCardComponent> productCards = searchPage.getProductCards();
        for (ProductCardComponent productCard : productCards) {
            Assert.assertTrue(productCard.getProductCardPriceText() <= upperPriceLimit, "Product card price does not lower or equals the upper price limit");
        }
    }

    @Test
    public void verifyLoginTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        LoginPage loginPage = homePage.getHeader().clickLoginButton();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");

        loginPage.typeLoginInfo(USER_PHONE, USER_PASSWORD);
        Assert.assertTrue(loginPage.isPhoneInputNotEmpty(), "Phone input is empty");
        Assert.assertTrue(loginPage.isPasswordInputNotEmpty(), "Password input is empty");

        homePage = loginPage.clickLoginButton();

        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Assert.assertTrue(homePage.getHeader().isLoginButtonNotPresent(), "Login button is present");
    }
}