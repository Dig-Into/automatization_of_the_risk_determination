package aord.service;

import aord.dto.DangerDetailsDescriptionDTO;
import aord.model.DangerDetailsDescription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DangerDetailsDescriptionService {
    List<DangerDetailsDescription> getAll();
    DangerDetailsDescription getById(Long id);
    void save(DangerDetailsDescription convert);
    void update(DangerDetailsDescriptionDTO dangerDetailsDescription);
    void delete(Long id);
}