package com.solvd.test.web.page;

import com.solvd.test.web.component.PriceFilterPanelComponent;
import com.solvd.test.web.component.ProductCardComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='card__info']")
    private List<ProductCardComponent> productCards;

    @FindBy(xpath = "//div[text()='Ціна']/..")
    private PriceFilterPanelComponent priceFilterPanelComponent;

    @FindBy(xpath = "//a[@data-href='aktsii']")
    private ExtendedWebElement discountSortFilter;

    @FindBy(xpath = "//main")
    private ExtendedWebElement main;

    public SearchPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(main);
    }

    public List<ProductCardComponent> getProductCards() {
        return productCards;
    }

    public PriceFilterPanelComponent getPriceFilterPanelComponent() {
        return priceFilterPanelComponent;
    }

    public void clickOnDiscountSortFilter() {
        discountSortFilter.click();
    }
}