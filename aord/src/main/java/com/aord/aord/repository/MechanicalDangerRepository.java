package com.aord.aord.repository;

import com.aord.aord.model.MechanicalDanger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicalDangerRepository extends JpaRepository<MechanicalDanger, Long> {

}