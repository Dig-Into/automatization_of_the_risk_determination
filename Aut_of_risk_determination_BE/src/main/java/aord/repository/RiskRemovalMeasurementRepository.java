package aord.repository;

import aord.model.RiskRemovalMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskRemovalMeasurementRepository extends JpaRepository<RiskRemovalMeasurement, Long> {
}
