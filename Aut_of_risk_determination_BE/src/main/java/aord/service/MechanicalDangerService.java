package aord.service;

import aord.dto.MechanicalDangerDTO;
import aord.model.MechanicalDanger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MechanicalDangerService {
    List<MechanicalDanger> getAll();
    MechanicalDanger getById(Long id);
    void save(MechanicalDanger convert);
    void update(MechanicalDangerDTO mechanicalDanger);
    void delete(Long id);
}