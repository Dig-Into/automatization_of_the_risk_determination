package aord.service.impl;

import aord.dto.FrequencyDTO;
import aord.model.Frequency;
import aord.repository.FrequencyRepository;
import aord.service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FrequencyServiceImpl implements FrequencyService {
    @Autowired
    FrequencyRepository repo;
    @Override
    public List<Frequency> getAll() {
        return repo.findAll();
    }

    @Override
    public Frequency getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void save(Frequency convert) {
        repo.save(convert);
    }

    @Override
    public void update(FrequencyDTO frequency) {
        Optional<Frequency> target = repo.findById(frequency.getId());
        Frequency freq = null;
        if (target.isPresent()) {
            freq = target.get();
            if (freq != null) {
                freq.setId(frequency.getId());
                freq.setValue(frequency.getValue());
                freq.setDescription(frequency.getDescription());

                repo.save(freq);
            }
        }
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}