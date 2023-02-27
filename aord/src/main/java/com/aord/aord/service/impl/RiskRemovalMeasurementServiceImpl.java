package com.aord.aord.service.impl;

import com.aord.aord.dto.RiskRemovalMeasurementDTO;
import com.aord.aord.model.RiskRemovalMeasurement;
import com.aord.aord.repository.RiskRemovalMeasurementRepository;
import com.aord.aord.service.RiskRemovalMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RiskRemovalMeasurementServiceImpl implements RiskRemovalMeasurementService {

    @Autowired
    RiskRemovalMeasurementRepository riskRemovalMeasurementRepository;
    @Override
    public List<RiskRemovalMeasurement> getAll() {
        return riskRemovalMeasurementRepository.findAll();
    }

    @Override
    public RiskRemovalMeasurement getById(Long id) {
        return riskRemovalMeasurementRepository.findById(id).get();
    }

    @Override
    public void save(RiskRemovalMeasurement convert) {
        riskRemovalMeasurementRepository.save(convert);
    }

    @Override
    public void update(RiskRemovalMeasurementDTO riskRemovalMeasurement) {
        Optional<RiskRemovalMeasurement> target = riskRemovalMeasurementRepository.findById(riskRemovalMeasurement.getId());
        RiskRemovalMeasurement riskRem = null;
        if (target.isPresent()) {
            riskRem = target.get();
            if (riskRem != null) {
                riskRem.setId(riskRemovalMeasurement.getId());
                riskRem.setRiskFactorValue(riskRemovalMeasurement.getRiskFactorValue());
                riskRem.setDescription(riskRemovalMeasurement.getDescription());
                riskRem.setMeasurementImplFreq(riskRemovalMeasurement.getMeasurementImplFreq());

                riskRemovalMeasurementRepository.save(riskRem);

            }

        }
    }

    @Override
    public void delete(Long id) {
        riskRemovalMeasurementRepository.deleteById(id);
    }
}