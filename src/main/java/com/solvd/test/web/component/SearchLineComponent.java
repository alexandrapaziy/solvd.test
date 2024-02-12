package com.solvd.test.web.component;

import com.solvd.test.web.page.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchLineComponent extends AbstractUIObject {
    @FindBy(xpath = ".//input[@placeholder='Пошук']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = ".//input/following-sibling::button[2]")
    private ExtendedWebElement searchButton;

    public SearchLineComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getSearchInput() {
        return searchInput;
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public String getSearchInputPlaceholder() {
        return searchInput.getAttribute("placeholder");
    }

    public void typeSearchInputData(String data) {
        searchInput.type(data);
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return new SearchPage(getDriver());
    }
}