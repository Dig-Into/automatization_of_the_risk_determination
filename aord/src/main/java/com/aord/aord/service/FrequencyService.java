package com.aord.aord.service;

import com.aord.aord.dto.FrequencyDTO;
import com.aord.aord.model.Frequency;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FrequencyService {

    List<Frequency> getAll();
    Frequency getById(Long id);
    void save(Frequency convert);
    void update(FrequencyDTO frequency);
    void delete(Long id);

}