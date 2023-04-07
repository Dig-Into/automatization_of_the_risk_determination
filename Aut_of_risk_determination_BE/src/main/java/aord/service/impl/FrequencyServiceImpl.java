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
    public Frequency findFrequencyByCode(Double code) {
        return repo.findFrequencyByCode(code);
    }


}