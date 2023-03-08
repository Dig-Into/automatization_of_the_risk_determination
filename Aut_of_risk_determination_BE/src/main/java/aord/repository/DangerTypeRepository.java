package aord.repository;

import aord.model.DangerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DangerTypeRepository extends JpaRepository<DangerType, Long> {
}
