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

    @Override
    public void save(Probability convert) {
        repo.save(convert);
    }

    @Override
    public void update(ProbabilityDTO probability) {
        Optional<Probability> target = repo.findById(probability.getId());
        Probability prob = null;
        if (target.isPresent()) {
            prob = target.get();
            if (prob != null) {
                prob.setId(probability.getId());
                prob.setValue(probability.getValue());
                prob.setDescription(probability.getDescription());

                repo.save(prob);
            }
        }
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}