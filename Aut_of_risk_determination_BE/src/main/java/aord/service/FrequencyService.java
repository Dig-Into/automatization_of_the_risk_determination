package aord.service;

import aord.dto.FrequencyDTO;
import aord.model.Frequency;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FrequencyService {
    List<Frequency> getAll();
    Frequency getById(Long id);
    Frequency findFrequencyByCode(Double code);


}