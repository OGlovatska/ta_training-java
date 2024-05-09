package com.epam.training.olga_glovatska.task_3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.olga_glovatska.task_3.util.WaitUtil.waitForElementVisibility;

public class CostEstimateSummaryPage extends BasePage{

    @FindBy(xpath = "//h4[@class='n8xu5 Nh2Phe D0aEmf']")
    private WebElement totalEstimatedCost;

    @FindBy(xpath = "//span[text()='Number of Instances']/following-sibling::span[@class='Kfvdz']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//span[text()='Operating System / Software']/following-sibling::span[@class='Kfvdz']")
    private WebElement operatingSystem;

    @FindBy(xpath = "//span[text()='Provisioning Model']/following-sibling::span[@class='Kfvdz']")
    private WebElement provisioningModel;

    @FindBy(xpath = "//span[text()='Machine type']/following-sibling::span[@class='Kfvdz']")
    private WebElement machineType;

    @FindBy(xpath = "//span[text()='GPU Model']/following-sibling::span[@class='Kfvdz']")
    private WebElement modelGPU;

    @FindBy(xpath = "//span[text()='Number of GPUs']/following-sibling::span[@class='Kfvdz']")
    private WebElement numberOfGPUs;

    @FindBy(xpath = "//span[text()='Local SSD']/following-sibling::span[@class='Kfvdz']")
    private WebElement localSSD;

    @FindBy(xpath = "//span[text()='Region']/following-sibling::span[@class='Kfvdz']")
    private WebElement region;

    @FindBy(xpath = "//span[text()='Committed use discount options']/following-sibling::span[@class='Kfvdz']")
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
        waitForElementVisibility(webDriver, totalEstimatedCost, 10);
        return totalEstimatedCost.getText();
    }

    public String getNumberOfInstances(){
        waitForElementVisibility(webDriver, numberOfInstances, 10);
        return numberOfInstances.getText();
    }

    public String getOperationSystem(){
        waitForElementVisibility(webDriver, operatingSystem, 10);
        return operatingSystem.getText();
    }

    public String getProvisioningModel(){
        waitForElementVisibility(webDriver, provisioningModel, 10);
        return provisioningModel.getText();
    }

    public String getMachineType(){
        waitForElementVisibility(webDriver, machineType, 10);
        return machineType.getText();
    }

    public String getModelGPU(){
        waitForElementVisibility(webDriver, modelGPU, 10);
        return modelGPU.getText();
    }

    public String getNumberOfGPUs(){
        waitForElementVisibility(webDriver, numberOfGPUs, 10);
        return numberOfGPUs.getText();
    }

    public String getLocalSSD(){
        waitForElementVisibility(webDriver, localSSD, 10);
        return localSSD.getText();
    }

    public String getRegion(){
        waitForElementVisibility(webDriver, region, 10);
        return region.getText();
    }

    public String getCommittedUse(){
        waitForElementVisibility(webDriver, committedUse, 10);
        return committedUse.getText();
    }
}
