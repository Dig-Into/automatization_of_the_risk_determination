package com.aord.aord.dto;

import com.aord.aord.model.MechanicalDangerDetails;
import com.aord.aord.model.RiskRemovalMeasurement;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RiskRemovalMeasurementDTO {

    private Long id;

    @ManyToOne
    @JoinColumn(name = "mechanical_danger_details_id")
    private MechanicalDangerDetails mechanicalDangerDetails;

    private Double riskFactorValue;

    private String description;

    private String measurementImplFreq;

    public RiskRemovalMeasurementDTO() {
        // Default constructor
    }

    public RiskRemovalMeasurementDTO(RiskRemovalMeasurement riskRemovalMeasurement) {
        this.id = riskRemovalMeasurement.getId();
        this.riskFactorValue = riskRemovalMeasurement.getRiskFactorValue();
        this.description = riskRemovalMeasurement.getDescription();
        this.measurementImplFreq = riskRemovalMeasurement.getMeasurementImplFreq();

        MechanicalDangerDetails mechDangDet = riskRemovalMeasurement.getMechanicalDangerDetails();
        if (mechDangDet != null) {
            this.mechanicalDangerDetails = mechDangDet;
        }

    }
}