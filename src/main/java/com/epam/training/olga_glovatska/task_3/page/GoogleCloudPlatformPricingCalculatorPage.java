package com.epam.training.olga_glovatska.task_3.page;

import com.epam.training.olga_glovatska.task_3.page.popup.AddToEstimatePopUp;
import com.epam.training.olga_glovatska.task_3.page.popup.ShareCostPopUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.olga_glovatska.task_3.util.WaitUtil.*;

public class GoogleCloudPlatformPricingCalculatorPage extends BasePage {
    private static final String CALCULATOR_PAGE = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "(//span[text()='Add to estimate']/ancestor::button)[1]")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//*[@id='c11']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//span[text() = 'Operating System / Software']/ancestor::div[1]")
    private WebElement operatingSystemDropdown;

    @FindBy(xpath = "//label[text()='Regular']")
    private WebElement regularProvisioningModel;

    @FindBy(xpath = "//span[text() = 'Machine Family']/ancestor::div[1]")
    private WebElement machineFamilyDropDown;

    @FindBy(xpath = "//span[text() = 'Series']/ancestor::div[1]")
    private WebElement seriesDropDown;

    @FindBy(xpath = "//span[text() = 'Machine type']/ancestor::div[1]")
    private WebElement machineTypeDropDown;

    @FindBy(xpath = "//span[@class='eBlXUe-hywKDc']/ancestor::button[@aria-label='Add GPUs']")
    private WebElement addGPUsSwitcher;

    @FindBy(xpath = "//span[text() = 'GPU Model']/ancestor::div[1]")
    private WebElement modelGPUDropdown;

    @FindBy(xpath = "//span[text() = 'Number of GPUs']/ancestor::div[1]")
    private WebElement numberOfGPUsDropdown;

    @FindBy(xpath = "//span[text() = 'Local SSD']/ancestor::div[@aria-describedby='c40']")
    private WebElement localSSDDropdown;

    @FindBy(xpath = "//span[text()='Region']/ancestor::div[1]")
    private WebElement regionDropdown;

    @FindBy(xpath = "//label[text()='1 year']")
    private WebElement oneYearCommittedUseButton;

    @FindBy(xpath = "//div[text()='Estimated cost']/following-sibling::div/label")
    private WebElement estimateCost;

    @FindBy(xpath = "//button[@aria-label='Open Share Estimate dialog']")
    private WebElement shareButton;

    @FindBy(xpath = "//span[text()='Add to estimate']/ancestor::button")
    private WebElement addToEstimateOnCostDetailsButton;
    
    @FindBy(xpath = "//*[text()='Service cost updated']")
    private WebElement serviceCostUpdateMessage;

    public GoogleCloudPlatformPricingCalculatorPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected GoogleCloudPlatformPricingCalculatorPage openPage() {
        webDriver.get(CALCULATOR_PAGE);
        return this;
    }

    public AddToEstimatePopUp clickAddToEstimateButton() {
        waitForElementVisibility(webDriver, addToEstimateButton, 10);
        addToEstimateButton.click();
        return new AddToEstimatePopUp(webDriver);
    }

    public GoogleCloudPlatformPricingCalculatorPage insertNumberOfInstances(String number) {
        waitForElementVisibility(webDriver, numberOfInstances, 10);
        numberOfInstances.clear();
        numberOfInstances.sendKeys(number);
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectOperationSystem(String operationSystem) {
        waitForElementVisibility(webDriver, operatingSystemDropdown, 10);
        operatingSystemDropdown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + operationSystem + "']/ancestor::li"));
        waitForElementVisibility(webDriver, option, 10);
        option.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectRegularProvisionModel() {
        regularProvisioningModel.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectMachineFamily(String machineFamily) {
        waitForElementVisibility(webDriver, machineFamilyDropDown, 10);
        machineFamilyDropDown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + machineFamily + "']/ancestor::li"));
        waitForElementVisibility(webDriver, option, 10);
        option.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectSeries(String series) {
        waitForElementVisibility(webDriver, seriesDropDown, 10);
        seriesDropDown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + series + "']/ancestor::li"));
        waitForElementVisibility(webDriver, option, 15);
        option.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectMachineType(String machineType) {
        waitForElementVisibility(webDriver, machineTypeDropDown, 10);
        machineTypeDropDown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + machineType + "']/ancestor::li"));
        waitForElementVisibility(webDriver, option, 15);
        option.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage switchAddGPUs() {
        waitForElementVisibility(webDriver, addGPUsSwitcher, 10);
        addGPUsSwitcher.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectModelGPU(String modelGPU) {
        waitForElementVisibility(webDriver, modelGPUDropdown, 10);
        modelGPUDropdown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + modelGPU + "']/ancestor::li"));
        waitForElementVisibility(webDriver, option, 10);
        option.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectNumberOfGPUs(String number) {
        waitForElementVisibility(webDriver, numberOfGPUsDropdown, 15);
        numberOfGPUsDropdown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + number + "']/ancestor::li"));
        waitForElementVisibility(webDriver, option, 15);
        option.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectLocalSSD(String value) {
        waitForElementVisibility(webDriver, localSSDDropdown, 10);
        localSSDDropdown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + value + "']/ancestor::li"));
        waitForElementVisibility(webDriver, option, 10);
        option.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectRegion(String region) {
        waitForElementVisibility(webDriver, regionDropdown, 10);
        regionDropdown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + region + "']/ancestor::li"));
        waitForElementVisibility(webDriver, option, 10);
        option.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage selectOneYearCommittedUse() {
        oneYearCommittedUseButton.click();
        return this;
    }

    public AddToEstimatePopUp clickAddToEstimateOnCostDetailsButton(){
        waitForElementVisibility(webDriver, addToEstimateOnCostDetailsButton, 10);
        addToEstimateOnCostDetailsButton.click();
        return new AddToEstimatePopUp(webDriver);
    }

    public ShareCostPopUp clickShareButton() {
        shareButton.click();
        return new ShareCostPopUp(webDriver);
    }

    public String getEstimateCost() {
        waitForElementVisibility(webDriver, serviceCostUpdateMessage, 10);
        return estimateCost.getText();
    }
}
