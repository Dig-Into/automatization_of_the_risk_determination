package com.aord.aord.service;

import com.aord.aord.dto.RiskRemovalMeasurementDTO;
import com.aord.aord.model.RiskRemovalMeasurement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RiskRemovalMeasurementService {
    List<RiskRemovalMeasurement> getAll();
    RiskRemovalMeasurement getById(Long id);
    void save(RiskRemovalMeasurement convert);
    void update(RiskRemovalMeasurementDTO riskRemovalManagement);
    void delete(Long id);
}