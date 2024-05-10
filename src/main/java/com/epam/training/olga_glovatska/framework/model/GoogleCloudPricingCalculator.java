package com.epam.training.olga_glovatska.framework.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Builder
@Getter
public class GoogleCloudPricingCalculator {

    private final String numberOfInstances;

    private final String operatingSystem;

    private final String provisioningModel;

    private final String machineFamily;

    private final String series;

    private final String machineType;

    private final boolean addGPUs;

    private final String modelGPU;

    private final String numberOfGPUs;

    private final String localSSD;

    private final String region;

    private final String committedUse;

    private String estimateCost;

    public void setEstimateCost(String estimateCost) {
        this.estimateCost = estimateCost;
    }
}
