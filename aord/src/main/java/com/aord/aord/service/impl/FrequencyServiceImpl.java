package com.aord.aord.service.impl;

import com.aord.aord.dto.FrequencyDTO;
import com.aord.aord.model.Frequency;
import com.aord.aord.repository.FrequencyRepository;
import com.aord.aord.service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FrequencyServiceImpl implements FrequencyService {

    @Autowired
    FrequencyRepository frequencyRepository;
    @Override
    public List<Frequency> getAll() {
        return frequencyRepository.findAll();
    }

    @Override
    public Frequency getById(Long id) {
        return frequencyRepository.findById(id).get();
    }

    @Override
    public void save(Frequency convert) {
        frequencyRepository.save(convert);
    }

    @Override
    public void update(FrequencyDTO frequency) {
        Optional<Frequency> target = frequencyRepository.findById(frequency.getId());
        Frequency freq = null;
        if (target.isPresent()) {
            freq = target.get();
            if (freq != null) {
                freq.setId(frequency.getId());
                freq.setValue(frequency.getValue());
                freq.setDescription(frequency.getDescription());

                frequencyRepository.save(freq);

            }

        }
    }

    @Override
    public void delete(Long id) {
        frequencyRepository.deleteById(id);
    }
}
