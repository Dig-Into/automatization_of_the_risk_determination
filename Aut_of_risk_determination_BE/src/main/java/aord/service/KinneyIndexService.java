package aord.service;

import aord.dto.KinneyIndexDTO;
import aord.model.KinneyIndex;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KinneyIndexService {
    List<KinneyIndex> getAll();
    KinneyIndex getById(Long id);
    void save(KinneyIndex convert);
    void update(KinneyIndexDTO kinneyIndex);
    void delete(Long id);
}