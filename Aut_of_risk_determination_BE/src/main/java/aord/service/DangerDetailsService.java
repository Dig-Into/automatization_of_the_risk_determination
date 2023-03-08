package aord.service;

import aord.dto.DangerDetailsDTO;
import aord.model.DangerDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DangerDetailsService {
    List<DangerDetails> getAll();
    DangerDetails getById(Long id);
    void save(DangerDetails convert);
    void update(DangerDetailsDTO mechanicalDangerDetails);
    void delete(Long id);
}