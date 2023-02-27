package com.aord.aord.service.impl;

import com.aord.aord.dto.ProbabilityDTO;
import com.aord.aord.model.Probability;
import com.aord.aord.repository.ProbabilityRepository;
import com.aord.aord.service.ProbabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProbabilityServiceImpl implements ProbabilityService {

    @Autowired
    ProbabilityRepository probabilityRepository;

    @Override
    public List<Probability> getAll() {
        return probabilityRepository.findAll();
    }

    @Override
    public Probability getById(Long id) {
        return probabilityRepository.findById(id).get();
    }

    @Override
    public void save(Probability convert) {
        probabilityRepository.save(convert);
    }

    @Override
    public void update(ProbabilityDTO probability) {
        Optional<Probability> target = probabilityRepository.findById(probability.getId());
        Probability prob = null;
        if (target.isPresent()) {
            prob = target.get();
            if (prob != null) {
                prob.setId(probability.getId());
                prob.setValue(probability.getValue());
                prob.setDescription(probability.getDescription());

                probabilityRepository.save(prob);

            }

        }
    }

    @Override
    public void delete(Long id) {
        probabilityRepository.deleteById(id);
    }
}