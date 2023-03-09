package aord.service;

import aord.dto.DangerTypeDTO;
import aord.model.DangerType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DangerTypeService {

    List<DangerType> getAll();
    DangerType getById(Long id);
    void save(DangerType convert);
    void update(DangerTypeDTO dangerType);
    void delete(Long id);

}