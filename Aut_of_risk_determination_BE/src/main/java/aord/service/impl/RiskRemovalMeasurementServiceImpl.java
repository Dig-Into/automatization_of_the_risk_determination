package aord.service.impl;

import aord.dto.RiskRemovalMeasurementDTO;
import aord.model.RiskRemovalMeasurement;
import aord.repository.RiskRemovalMeasurementRepository;
import aord.service.RiskRemovalMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RiskRemovalMeasurementServiceImpl implements RiskRemovalMeasurementService {
    @Autowired
    RiskRemovalMeasurementRepository repo;
    @Override
    public List<RiskRemovalMeasurement> getAll() {
        return repo.findAll();
    }

    @Override
    public RiskRemovalMeasurement getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void save(RiskRemovalMeasurement convert) {
        repo.save(convert);
    }

    @Override
    public void update(RiskRemovalMeasurementDTO riskRemovalMeasurement) {
        Optional<RiskRemovalMeasurement> target = repo.findById(riskRemovalMeasurement.getId());
        RiskRemovalMeasurement riskRem = null;
        if (target.isPresent()) {
            riskRem = target.get();
            if (riskRem != null) {
                riskRem.setId(riskRemovalMeasurement.getId());
                riskRem.setRiskFactorValue(riskRemovalMeasurement.getRiskFactorValue());
                riskRem.setDescription(riskRemovalMeasurement.getDescription());
                riskRem.setMeasurementImplFreq(riskRemovalMeasurement.getMeasurementImplFreq());

                repo.save(riskRem);
            }
        }
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
