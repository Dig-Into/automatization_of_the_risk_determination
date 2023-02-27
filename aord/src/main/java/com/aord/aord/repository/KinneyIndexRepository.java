package com.aord.aord.repository;

import com.aord.aord.model.KinneyIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KinneyIndexRepository extends JpaRepository<KinneyIndex, Long> {

}