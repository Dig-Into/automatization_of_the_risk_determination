package aord.service.impl;

import aord.dto.ProbabilityDTO;
import aord.model.Probability;
import aord.repository.ProbabilityRepository;
import aord.service.ProbabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProbabilityServiceImpl implements ProbabilityService {
    @Autowired
    ProbabilityRepository repo;

    @Override
    public List<Probability> getAll() {
        return repo.findAll();
    }

    @Override
    public Probability getById(Long id) {
        return repo.findById(id).get();
    }

}