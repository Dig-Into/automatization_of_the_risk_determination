package aord.repository;

import aord.model.DangerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DangerTypeRepository extends JpaRepository<DangerType, Long> {

}