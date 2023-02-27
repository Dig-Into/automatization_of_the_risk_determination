package com.aord.aord.service;

import com.aord.aord.dto.ProbabilityDTO;
import com.aord.aord.model.Probability;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProbabilityService {
    List<Probability> getAll();
    Probability getById(Long id);
    void save(Probability convert);
    void update(ProbabilityDTO probability);
    void delete(Long id);
}
