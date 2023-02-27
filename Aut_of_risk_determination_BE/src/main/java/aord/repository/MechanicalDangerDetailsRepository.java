package aord.repository;

import aord.model.MechanicalDangerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicalDangerDetailsRepository extends JpaRepository<MechanicalDangerDetails, Long> {
}
