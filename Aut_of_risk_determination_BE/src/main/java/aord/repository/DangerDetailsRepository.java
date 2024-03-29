package aord.repository;

import aord.model.DangerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DangerDetailsRepository extends JpaRepository<DangerDetails, Long> {
    DangerDetails findDangerDetailsByCode(Integer code);
}