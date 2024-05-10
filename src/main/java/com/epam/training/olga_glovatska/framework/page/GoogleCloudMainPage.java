package com.epam.training.olga_glovatska.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudMainPage extends BasePage {
    private static final String MAIN_PAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//div[@class='YSM5S']")
    private WebElement magnifyingGlassIcon;

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchInputField;

    @FindBy(xpath = "//i[@aria-label='Search']")
    private WebElement searchInitButton;

    public GoogleCloudMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public GoogleCloudMainPage openPage() {
        webDriver.get(MAIN_PAGE_URL);
        return this;
    }

    public GoogleCloudMainPage clickMagnifyingGlassIcon() {
        magnifyingGlassIcon.click();
        return this;
    }

    public GoogleCloudMainPage inputSearchRequest(String searchRequest) {
        searchInputField.sendKeys(searchRequest);
        return this;
    }

    public GoogleCloudSearchResultPage initiateSearch() {
        searchInitButton.click();
        return new GoogleCloudSearchResultPage(webDriver);
    }
}
