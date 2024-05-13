package com.epam.training.olga_glovatska.framework.service;

import com.epam.training.olga_glovatska.framework.model.GoogleCloudPricingCalculator;
import com.epam.training.olga_glovatska.framework.page.GoogleCloudPricingCalculatorPage;
import com.epam.training.olga_glovatska.framework.page.GoogleCloudSearchResultPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.training.olga_glovatska.framework.service.TestDataReader.getTestData;
import static com.epam.training.olga_glovatska.framework.util.GoogleCloudPricingCalculatorConstants.*;

public class GoogleCloudPricingCalculatorCreator {
    private static final String SEARCH_REQUEST = "test.data.search.request";
    private static final String SEARCH_PAGE_TITLE = "test.data.search.page.title";
    private static final String NUMBER_OF_INSTANCES = "test.data.number.of.instances";
    private static final String OPERATION_SYSTEM = "test.data.operation.system";
    private static final String PROVISION_MODEL = "test.data.provision.model";
    private static final String MACHINE_FAMILY = "test.data.machine.family";
    private static final String SERIES = "test.data.series";
    private static final String MACHINE_TYPE = "test.data.machine.type";
    private static final String ADD_GPU = "test.data.add.gpu";
    private static final String MODEL_GPU = "test.data.model.gpu";
    private static final String NUMBER_OF_GPU = "test.data.number.of.gpu";
    private static final String LOCAL_SSD = "test.data.local.ssd";
    private static final String REGION = "test.data.region";
    private static final String COMMITTED_USE = "test.data.committed.use";

    public static String getSearchRequest() {
        return getTestData(SEARCH_REQUEST);
    }

    public static String getSearchPageTitle(){
        return getTestData(SEARCH_PAGE_TITLE);
    }

    public static GoogleCloudPricingCalculator createGoogleCloudPricingCalculatorModel() {
        return GoogleCloudPricingCalculator.builder()
                .numberOfInstances(getTestData(NUMBER_OF_INSTANCES))
                .operatingSystem(getTestData(OPERATION_SYSTEM))
                .provisioningModel(getTestData(PROVISION_MODEL))
                .machineFamily(getTestData(MACHINE_FAMILY))
                .series(getTestData(SERIES))
                .machineType(getTestData(MACHINE_TYPE))
                .addGPUs(Boolean.parseBoolean(getTestData(ADD_GPU)))
                .modelGPU(getTestData(MODEL_GPU))
                .numberOfGPUs(getTestData(NUMBER_OF_GPU))
                .localSSD(getTestData(LOCAL_SSD))
                .region(getTestData(REGION))
                .committedUse(getTestData(COMMITTED_USE))
                .build();
    }

    public static GoogleCloudPricingCalculatorPage createGoogleCloudPricingCalculatorPage(GoogleCloudSearchResultPage resultPage, GoogleCloudPricingCalculator model) {
        GoogleCloudPricingCalculatorPage calculatorPage = resultPage
                .clickCalculator()
                .clickAddToEstimateButton()
                .clickComputerEngineButton()
                .insertNumberOfInstances(model.getNumberOfInstances())
                .selectOperationSystem(model.getOperatingSystem());

        selectProvisionModel(calculatorPage, model.getProvisioningModel());
        selectMachineFamily(calculatorPage, model.getMachineFamily());
        selectSeries(calculatorPage, model.getSeries());
        selectMachineType(calculatorPage, model.getMachineType());
        selectGPUs(calculatorPage, model);
        selectRegion(calculatorPage, model.getRegion());
        selectCommittedUse(calculatorPage, model.getCommittedUse());

        return calculatorPage;
    }

    private static void selectProvisionModel(GoogleCloudPricingCalculatorPage calculatorPage, String provisionModel){
        switch (provisionModel) {
            case REGULAR_PROVISION_MODEL -> calculatorPage.selectRegularProvisionModel();
            case SPOT_PROVISION_MODEL -> calculatorPage.selectSpotProvisionModel();
        }
    }

    public static void selectMachineFamily(GoogleCloudPricingCalculatorPage calculatorPage, String machineFamily){
        calculatorPage.selectMachineFamily(machineFamily);
    }

    public static void selectSeries(GoogleCloudPricingCalculatorPage calculatorPage, String machineType){
        calculatorPage.selectSeries(machineType);
    }

    private static void selectMachineType(GoogleCloudPricingCalculatorPage calculatorPage, String machineType){
        Pattern pattern = Pattern.compile("^([^,]+)");
        Matcher matcher = pattern.matcher(machineType);
        if (matcher.find()) {
            calculatorPage.selectMachineType(matcher.group(1));
        }
    }

    private static void selectGPUs(GoogleCloudPricingCalculatorPage calculatorPage, GoogleCloudPricingCalculator model) {
        if (model.isAddGPUs()) {
            calculatorPage
                    .switchAddGPUs()
                    .selectModelGPU(model.getModelGPU())
                    .selectNumberOfGPUs(model.getNumberOfGPUs())
                    .selectLocalSSD(model.getLocalSSD());
        }
    }

    private static void selectRegion(GoogleCloudPricingCalculatorPage calculatorPage, String region) {
        calculatorPage.selectRegion(region);
    }

    private static void selectCommittedUse(GoogleCloudPricingCalculatorPage calculatorPage, String committedUse){
        switch (committedUse) {
            case NONE_COMMITTED_USE -> calculatorPage.selectNoneCommittedUse();
            case ONE_YEAR_COMMITTED_USE -> calculatorPage.selectOneYearCommittedUse();
            case THREE_YEARS_COMMITTED_USE -> calculatorPage.selectThreeYearCommittedUse();
        }
    }
}
