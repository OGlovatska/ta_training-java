package com.epam.training.olga_glovatska.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.olga_glovatska.framework.util.WaitUtil.waitForElementVisibility;

public class CostEstimateSummaryPage extends BasePage {

    @FindBy(xpath = "//h5[text()='Total estimated cost']/following-sibling::h4")
    private WebElement totalEstimatedCost;

    @FindBy(xpath = "//span[text()='Number of Instances']/following-sibling::span")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//span[text()='Operating System / Software']/following-sibling::span")
    private WebElement operatingSystem;

    @FindBy(xpath = "//span[text()='Provisioning Model']/following-sibling::span")
    private WebElement provisioningModel;

    @FindBy(xpath = "//span[text()='Machine type']/following-sibling::span")
    private WebElement machineType;

    @FindBy(xpath = "//span[text()='GPU Model']/following-sibling::span")
    private WebElement modelGPU;

    @FindBy(xpath = "//span[text()='Number of GPUs']/following-sibling::span")
    private WebElement numberOfGPUs;

    @FindBy(xpath = "//span[text()='Local SSD']/following-sibling::span")
    private WebElement localSSD;

    @FindBy(xpath = "//span[text()='Region']/following-sibling::span")
    private WebElement region;

    @FindBy(xpath = "//span[text()='Committed use discount options']/following-sibling::span")
    private WebElement committedUse;

    public CostEstimateSummaryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected CostEstimateSummaryPage openPage() {
        throw new RuntimeException("The page opens in response for getting summary cost " +
                "and can not be accessed directly.");
    }

    public String getTotalEstimatedCost(){
        waitForElementVisibility(driver, totalEstimatedCost, 10);
        return totalEstimatedCost.getText();
    }

    public String getNumberOfInstances(){
        waitForElementVisibility(driver, numberOfInstances, 10);
        return numberOfInstances.getText();
    }

    public String getOperationSystem(){
        waitForElementVisibility(driver, operatingSystem, 10);
        return operatingSystem.getText();
    }

    public String getProvisioningModel(){
        waitForElementVisibility(driver, provisioningModel, 10);
        return provisioningModel.getText();
    }

    public String getMachineType(){
        waitForElementVisibility(driver, machineType, 10);
        return machineType.getText();
    }

    public String getModelGPU(){
        waitForElementVisibility(driver, modelGPU, 10);
        return modelGPU.getText();
    }

    public String getNumberOfGPUs(){
        waitForElementVisibility(driver, numberOfGPUs, 10);
        return numberOfGPUs.getText();
    }

    public String getLocalSSD(){
        waitForElementVisibility(driver, localSSD, 10);
        return localSSD.getText();
    }

    public String getRegion(){
        waitForElementVisibility(driver, region, 10);
        return region.getText();
    }

    public String getCommittedUse(){
        waitForElementVisibility(driver, committedUse, 10);
        return committedUse.getText();
    }
}
