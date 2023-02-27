package com.aord.aord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskRemovalMeasurementRepository extends JpaRepository<com.aord.aord.model.RiskRemovalMeasurement, Long> {

}