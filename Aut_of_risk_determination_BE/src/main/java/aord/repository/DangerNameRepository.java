package aord.repository;

import aord.model.DangerName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DangerNameRepository extends JpaRepository<DangerName, Long> {
}
