package aord.dto;

import aord.model.MechanicalDangerDetails;
import aord.model.RiskRemovalMeasurement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Getter
@Setter
public class RiskRemovalMeasurementDTO {
    private Long id;
    private Double riskFactorValue;
    private String description;
    private String measurementImplFreq;
    @ManyToOne
    @JoinColumn(name = "mechanical_danger_details_id")
    private MechanicalDangerDetails mechanicalDangerDetails;

    public RiskRemovalMeasurementDTO(RiskRemovalMeasurement riskRemovalMeasurement) {
        this.id = riskRemovalMeasurement.getId();
        this.riskFactorValue = riskRemovalMeasurement.getRiskFactorValue();
        this.description = riskRemovalMeasurement.getDescription();
        this.measurementImplFreq = riskRemovalMeasurement.getMeasurementImplFreq();

        MechanicalDangerDetails mechDetails = riskRemovalMeasurement.getMechanicalDangerDetails();
        if (mechDetails != null) {
            this.mechanicalDangerDetails = mechDetails;
        }
    }


}