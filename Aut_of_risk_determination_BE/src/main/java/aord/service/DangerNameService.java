package aord.service;

import aord.dto.DangerNameDTO;
import aord.model.DangerName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DangerNameService {
    List<DangerName> getAll();
    DangerName getById(Long id);
    List<Integer> getAllDangerNameCodes();
    DangerName findDangerNameByDangerNumber(Integer dangerNumber);
    void save(DangerName convert);
    void update(DangerNameDTO mechanicalDanger);
    void delete(Long id);
}