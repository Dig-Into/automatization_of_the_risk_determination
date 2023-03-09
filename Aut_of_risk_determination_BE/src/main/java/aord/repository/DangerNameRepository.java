package aord.repository;

import aord.model.DangerName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DangerNameRepository extends JpaRepository<DangerName, Long> {

    @Query("SELECT dn.dangerNumber FROM DangerName dn")
    List<Integer> getAllDangerNameCodes();
}