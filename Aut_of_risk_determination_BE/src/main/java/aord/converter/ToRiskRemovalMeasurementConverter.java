package aord.converter;

import aord.dto.RiskRemovalMeasurementDTO;
import aord.model.MechanicalDangerDetails;
import aord.model.RiskRemovalMeasurement;
import aord.repository.MechanicalDangerDetailsRepository;
import aord.repository.RiskRemovalMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class ToRiskRemovalMeasurementConverter implements Converter<RiskRemovalMeasurementDTO, RiskRemovalMeasurement> {
    @Autowired
    RiskRemovalMeasurementRepository repo;

    @Autowired
    MechanicalDangerDetailsRepository mechanicalDangerDetailsRepository;

    @Override
    public RiskRemovalMeasurement convert(RiskRemovalMeasurementDTO source) {
        RiskRemovalMeasurement riskRemovalMeasurement = new RiskRemovalMeasurement();

        riskRemovalMeasurement.setId(source.getId());
        riskRemovalMeasurement.setRiskFactorValue(source.getRiskFactorValue());
        riskRemovalMeasurement.setDescription(source.getDescription());
        riskRemovalMeasurement.setMeasurementImplFreq(source.getMeasurementImplFreq());

        MechanicalDangerDetails mechanicalDangerDetails = mechanicalDangerDetailsRepository.findById(source.getMechanicalDangerDetails().getId()).get();

        if (!ObjectUtils.isEmpty(mechanicalDangerDetails)) {
            riskRemovalMeasurement.setMechanicalDangerDetails(mechanicalDangerDetails);
        }

        return riskRemovalMeasurement;

    }

}