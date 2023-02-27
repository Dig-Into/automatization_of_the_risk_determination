package com.aord.aord.repository;

import com.aord.aord.model.Probability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProbabilityRepository extends JpaRepository<Probability, Long> {

}