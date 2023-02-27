package aord.service;

import aord.dto.RiskRemovalMeasurementDTO;
import aord.model.RiskRemovalMeasurement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RiskRemovalMeasurementService {
    List<RiskRemovalMeasurement> getAll();
    RiskRemovalMeasurement getById(Long id);
    void save(RiskRemovalMeasurement convert);
    void update(RiskRemovalMeasurementDTO riskRemovalMeasurement);
    void delete(Long id);

}