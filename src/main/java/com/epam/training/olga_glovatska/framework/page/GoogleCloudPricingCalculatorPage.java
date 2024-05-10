package com.epam.training.olga_glovatska.framework.page;

import com.epam.training.olga_glovatska.framework.page.popup.AddToEstimatePopUp;
import com.epam.training.olga_glovatska.framework.page.popup.ShareCostPopUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.olga_glovatska.framework.page.util.WaitUtil.waitForElementVisibility;

public class GoogleCloudPricingCalculatorPage extends BasePage {
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

    public GoogleCloudPricingCalculatorPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected GoogleCloudPricingCalculatorPage openPage() {
        webDriver.get(CALCULATOR_PAGE);
        return this;
    }

    public AddToEstimatePopUp clickAddToEstimateButton() {
        waitForElementVisibility(webDriver, addToEstimateButton, 10);
        addToEstimateButton.click();
        return new AddToEstimatePopUp(webDriver);
    }

    public GoogleCloudPricingCalculatorPage insertNumberOfInstances(String number) {
        waitForElementVisibility(webDriver, numberOfInstances, 10);
        numberOfInstances.clear();
        numberOfInstances.sendKeys(number);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectOperationSystem(String operationSystem) {
        waitForElementVisibility(webDriver, operatingSystemDropdown, 10);
        operatingSystemDropdown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + operationSystem + "']/ancestor::li"));
        waitForElementVisibility(webDriver, option, 10);
        option.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectRegularProvisionModel() {
        regularProvisioningModel.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectMachineFamily(String machineFamily) {
        waitForElementVisibility(webDriver, machineFamilyDropDown, 10);
        machineFamilyDropDown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + machineFamily + "']/ancestor::li"));
        waitForElementVisibility(webDriver, option, 10);
        option.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectSeries(String series) {
        waitForElementVisibility(webDriver, seriesDropDown, 10);
        seriesDropDown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + series + "']/ancestor::li"));
        waitForElementVisibility(webDriver, option, 15);
        option.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectMachineType(String machineType) {
        waitForElementVisibility(webDriver, machineTypeDropDown, 10);
        machineTypeDropDown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + machineType + "']/ancestor::li"));
        waitForElementVisibility(webDriver, option, 15);
        option.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage switchAddGPUs() {
        waitForElementVisibility(webDriver, addGPUsSwitcher, 10);
        addGPUsSwitcher.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectModelGPU(String modelGPU) {
        waitForElementVisibility(webDriver, modelGPUDropdown, 10);
        modelGPUDropdown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + modelGPU + "']/ancestor::li"));
        waitForElementVisibility(webDriver, option, 10);
        option.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectNumberOfGPUs(String number) {
        waitForElementVisibility(webDriver, numberOfGPUsDropdown, 15);
        numberOfGPUsDropdown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + number + "']/ancestor::li"));
        waitForElementVisibility(webDriver, option, 15);
        option.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectLocalSSD(String value) {
        waitForElementVisibility(webDriver, localSSDDropdown, 10);
        localSSDDropdown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + value + "']/ancestor::li"));
        waitForElementVisibility(webDriver, option, 10);
        option.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectRegion(String region) {
        waitForElementVisibility(webDriver, regionDropdown, 10);
        regionDropdown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + region + "']/ancestor::li"));
        waitForElementVisibility(webDriver, option, 10);
        option.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectOneYearCommittedUse() {
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
