package com.epam.training.olga_glovatska.framework.assertions;

import com.epam.training.olga_glovatska.framework.model.GoogleCloudPricingCalculator;
import com.epam.training.olga_glovatska.framework.page.CostEstimateSummaryPage;
import org.assertj.core.api.SoftAssertions;

public class GoogleCloudPricingCalculatorAssertions {

    public static void assertCalculatorModelWithSummaryResponse(GoogleCloudPricingCalculator pricingCalculator, CostEstimateSummaryPage summaryPage) {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(pricingCalculator.getEstimateCost()).isEqualTo(summaryPage.getTotalEstimatedCost());
            softAssertions.assertThat(pricingCalculator.getNumberOfInstances()).isEqualTo(summaryPage.getNumberOfInstances());
            softAssertions.assertThat(pricingCalculator.getOperatingSystem()).isEqualTo(summaryPage.getOperationSystem());
            softAssertions.assertThat(pricingCalculator.getProvisioningModel()).isEqualTo(summaryPage.getProvisioningModel());
            softAssertions.assertThat(pricingCalculator.getMachineType()).isEqualTo(summaryPage.getMachineType());
            softAssertions.assertThat(pricingCalculator.getModelGPU()).isEqualTo(summaryPage.getModelGPU());
            softAssertions.assertThat(pricingCalculator.getNumberOfGPUs()).isEqualTo(summaryPage.getNumberOfGPUs());
            softAssertions.assertThat(pricingCalculator.getLocalSSD()).isEqualTo(summaryPage.getLocalSSD());
            softAssertions.assertThat(pricingCalculator.getRegion()).isEqualTo(summaryPage.getRegion());
            softAssertions.assertThat(pricingCalculator.getCommittedUse()).isEqualTo(summaryPage.getCommittedUse());
        });
    }
}
