package aord.converter;

import aord.dto.RiskRemovalMeasurementDTO;
import aord.model.DangerDetails;
import aord.model.RiskRemovalMeasurement;
import aord.repository.DangerDetailsRepository;
import aord.repository.RiskRemovalMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class ToRiskRemovalMeasurementConverter implements Converter<RiskRemovalMeasurementDTO, RiskRemovalMeasurement> {

    @Autowired
    DangerDetailsRepository dangerDetailsRepository;

    @Override
    public RiskRemovalMeasurement convert(RiskRemovalMeasurementDTO source) {
        RiskRemovalMeasurement riskRemovalMeasurement = new RiskRemovalMeasurement();

        riskRemovalMeasurement.setId(source.getId());
        riskRemovalMeasurement.setRiskFactorValue(source.getRiskFactorValue());
        riskRemovalMeasurement.setDescription(source.getDescription());
        riskRemovalMeasurement.setMeasurementImplFreq(source.getMeasurementImplFreq());

        DangerDetails dangerDetails = dangerDetailsRepository.findById(source.getDangerDetails().getId()).get();

        if (!ObjectUtils.isEmpty(dangerDetails)) {
            riskRemovalMeasurement.setDangerDetails(dangerDetails);
        }

        return riskRemovalMeasurement;

    }

}