package aord.repository;

import aord.model.KinneyIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KinneyIndexRepository extends JpaRepository<KinneyIndex, Long> {
}
