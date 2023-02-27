package com.aord.aord.converter;

import com.aord.aord.dto.RiskRemovalMeasurementDTO;
import com.aord.aord.model.RiskRemovalMeasurement;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToRiskRemovalMeasurementDTOConverter implements Converter<RiskRemovalMeasurement, RiskRemovalMeasurementDTO> {

    @Override
    public RiskRemovalMeasurementDTO convert(RiskRemovalMeasurement source) {
        return new RiskRemovalMeasurementDTO(source);
    }

    public List<RiskRemovalMeasurementDTO> convert(List<RiskRemovalMeasurement> source) {
        List<RiskRemovalMeasurementDTO> list = new ArrayList<>();

        for (RiskRemovalMeasurement data: source) {
            list.add(new RiskRemovalMeasurementDTO(data));
        }

        return list;

    }
}