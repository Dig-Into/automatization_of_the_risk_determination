package aord.repository;

import aord.model.MechanicalDanger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicalDangerRepository extends JpaRepository<MechanicalDanger, Long> {
}
