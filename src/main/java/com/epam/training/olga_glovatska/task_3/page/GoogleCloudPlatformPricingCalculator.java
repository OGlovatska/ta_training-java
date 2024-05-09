package com.epam.training.olga_glovatska.task_3.page;

import com.epam.training.olga_glovatska.task_3.page.popup.AddToEstimatePopUp;
import com.epam.training.olga_glovatska.task_3.page.popup.ShareCostPopUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.olga_glovatska.task_3.util.WaitUtil.*;

public class GoogleCloudPlatformPricingCalculator extends BasePage {
    private static final String CALCULATOR_PAGE = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//span[@class='UywwFc-vQzf8d']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//*[@id='c11']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//span[text() = 'Operating System / Software']/ancestor::div[@class='VfPpkd-TkwUic']")
    private WebElement operatingSystemDropdown;

    @FindBy(xpath = "//label[text()='Regular']")
    private WebElement regularProvisioningModel;

    @FindBy(xpath = "//span[text() = 'Machine Family']/ancestor::div[@class='O1htCb-H9tDt PPUDSe t8xIwc']")
    private WebElement machineFamilyDropDown;

    @FindBy(xpath = "//span[text() = 'Series']/ancestor::div[@class='VfPpkd-TkwUic']")
    private WebElement seriesDropDown;

    @FindBy(xpath = "//span[text() = 'Machine type']/ancestor::div[@class='VfPpkd-TkwUic']")
    private WebElement machineTypeDropDown;

    @FindBy(xpath = "//span[@class='eBlXUe-hywKDc']/ancestor::button[@aria-label='Add GPUs']")
    private WebElement addGPUsSwitcher;

    @FindBy(xpath = "//span[text() = 'GPU Model']/ancestor::div[@class='VfPpkd-TkwUic']")
    private WebElement modelGPUDropdown;

    @FindBy(xpath = "//span[text() = 'Number of GPUs']/ancestor::div[@class='VfPpkd-TkwUic']")
    private WebElement numberOfGPUsDropdown;

    @FindBy(xpath = "//span[text() = 'Local SSD']/ancestor::div[@class='VfPpkd-TkwUic']")
    private WebElement localSSDDropdown;

    @FindBy(xpath = "//span[text() = 'Region']/ancestor::div[@class='VfPpkd-TkwUic']")
    private WebElement regionDropdown;

    @FindBy(xpath = "//label[text()='1 year']")
    private WebElement oneYearCommittedUseButton;

    @FindBy(xpath = "//label[@class='gt0C8e MyvX5d D0aEmf']")
    private WebElement estimateCost;

    @FindBy(xpath = "//button[@aria-label='Open Share Estimate dialog']")
    private WebElement shareButton;

    @FindBy(xpath = "//button[@class='AeBiU-LgbsSe AeBiU-LgbsSe-OWXEXe-Bz112c-M1Soyc AeBiU-LgbsSe-OWXEXe-dgl2Hf AeBiU-LgbsSe-OWXEXe-wdeprb-MD85tf-DKzjMe VVEJ3d']")
    private WebElement addToEstimateOnCostDetailsButton;

    public GoogleCloudPlatformPricingCalculator(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected GoogleCloudPlatformPricingCalculator openPage() {
        webDriver.get(CALCULATOR_PAGE);
        return this;
    }

    public AddToEstimatePopUp clickAddToEstimateButton() {
        waitForElementVisibility(webDriver, addToEstimateButton, 10);
        addToEstimateButton.click();
        return new AddToEstimatePopUp(webDriver);
    }

    public GoogleCloudPlatformPricingCalculator insertNumberOfInstances(String number) {
        waitForElementVisibility(webDriver, numberOfInstances, 10);
        numberOfInstances.clear();
        numberOfInstances.sendKeys(number);
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectOperationSystem(String operationSystem) {
        waitForElementVisibility(webDriver, operatingSystemDropdown, 10);
        operatingSystemDropdown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + operationSystem + "']/ancestor::li[@class='MCs1Pd HiC7Nc VfPpkd-OkbHre VfPpkd-aJasdd-RWgCYc-wQNmvb VfPpkd-rymPhb-ibnC6b VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc']"));
        waitForElementVisibility(webDriver, option, 10);
        option.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectRegularProvisionModel() {
        regularProvisioningModel.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectMachineFamily(String machineFamily) {
        waitForElementVisibility(webDriver, machineFamilyDropDown, 10);
        machineFamilyDropDown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + machineFamily + "']/ancestor::li[@class='MCs1Pd HiC7Nc VfPpkd-OkbHre VfPpkd-hjZysc-RWgCYc-wQNmvb VfPpkd-rymPhb-ibnC6b VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb']"));
        waitForElementVisibility(webDriver, option, 10);
        option.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectSeries(String series) {
        waitForElementVisibility(webDriver, seriesDropDown, 10);
        seriesDropDown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + series + "']/ancestor::li[@class='MCs1Pd HiC7Nc VfPpkd-OkbHre VfPpkd-hjZysc-RWgCYc-wQNmvb VfPpkd-rymPhb-ibnC6b VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb']"));
        waitForElementVisibility(webDriver, option, 15);
        option.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectMachineType(String machineType) {
        waitForElementVisibility(webDriver, machineTypeDropDown, 10);
        machineTypeDropDown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + machineType + "']/ancestor::li[@class='MCs1Pd HiC7Nc VfPpkd-OkbHre VfPpkd-hjZysc-RWgCYc-wQNmvb VfPpkd-rymPhb-ibnC6b VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-aSi1db-MCEKJb']"));
        waitForElementVisibility(webDriver, option, 15);
        option.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculator switchAddGPUs() {
        waitForElementVisibility(webDriver, addGPUsSwitcher, 10);
        addGPUsSwitcher.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectModelGPU(String modelGPU) {
        waitForElementVisibility(webDriver, modelGPUDropdown, 10);
        modelGPUDropdown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + modelGPU + "']/ancestor::li[@class='MCs1Pd HiC7Nc VfPpkd-OkbHre VfPpkd-aJasdd-RWgCYc-wQNmvb VfPpkd-rymPhb-ibnC6b VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc']"));
        waitForElementVisibility(webDriver, option, 10);
        option.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectNumberOfGPUs(String number) {
        waitForElementVisibility(webDriver, numberOfGPUsDropdown, 10);
        numberOfGPUsDropdown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + number + "']/ancestor::li[@class='MCs1Pd HiC7Nc VfPpkd-OkbHre VfPpkd-aJasdd-RWgCYc-wQNmvb VfPpkd-rymPhb-ibnC6b VfPpkd-rymPhb-ibnC6b-OWXEXe-gk6SMd VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc']"));
        waitForElementVisibility(webDriver, option, 15);
        option.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectLocalSSD(String value) {
        waitForElementVisibility(webDriver, localSSDDropdown, 10);
        localSSDDropdown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + value + "']/ancestor::li[@class='MCs1Pd HiC7Nc VfPpkd-OkbHre VfPpkd-aJasdd-RWgCYc-wQNmvb VfPpkd-rymPhb-ibnC6b VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc']"));
        waitForElementVisibility(webDriver, option, 10);
        option.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectRegion(String region) {
        waitForElementVisibility(webDriver, regionDropdown, 10);
        regionDropdown.click();

        WebElement option = webDriver.findElement(By.xpath("//span[text() = '" + region + "']/ancestor::li[@class='MCs1Pd HiC7Nc VfPpkd-OkbHre VfPpkd-aJasdd-RWgCYc-wQNmvb VfPpkd-rymPhb-ibnC6b VfPpkd-rymPhb-ibnC6b-OWXEXe-SfQLQb-Woal0c-RWgCYc']"));
        waitForElementVisibility(webDriver, option, 10);
        option.click();
        return this;
    }

    public GoogleCloudPlatformPricingCalculator selectOneYearCommittedUse() {
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
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return estimateCost.getText();
    }
}
