package com.aord.aord.converter;

import com.aord.aord.dto.RiskRemovalMeasurementDTO;
import com.aord.aord.model.MechanicalDangerDetails;
import com.aord.aord.model.RiskRemovalMeasurement;
import com.aord.aord.repository.MechanicalDangerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class ToRiskRemovalMeasurementConverter implements Converter<RiskRemovalMeasurementDTO, RiskRemovalMeasurement> {

    @Autowired
    MechanicalDangerDetailsRepository mechanicalDangerDetailsRepository;

    @Override
    public RiskRemovalMeasurement convert(RiskRemovalMeasurementDTO source) {
        RiskRemovalMeasurement riskRemovalMeasurement = new RiskRemovalMeasurement();

        riskRemovalMeasurement.setId(source.getId());
        riskRemovalMeasurement.setRiskFactorValue(source.getRiskFactorValue());
        riskRemovalMeasurement.setDescription(source.getDescription());
        riskRemovalMeasurement.setMeasurementImplFreq(source.getMeasurementImplFreq());

        MechanicalDangerDetails mechDangDetails = mechanicalDangerDetailsRepository.findById(source.getMechanicalDangerDetails().getId()).get();

        if (!ObjectUtils.isEmpty(mechDangDetails)) {
            riskRemovalMeasurement.setMechanicalDangerDetails(mechDangDetails);
        }

        return riskRemovalMeasurement;

    }

}