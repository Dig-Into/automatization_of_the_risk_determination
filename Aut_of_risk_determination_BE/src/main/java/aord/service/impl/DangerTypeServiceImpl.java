package aord.service.impl;

import aord.dto.DangerTypeDTO;
import aord.model.DangerType;
import aord.repository.DangerTypeRepository;
import aord.service.DangerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DangerTypeServiceImpl implements DangerTypeService {
    @Autowired
    DangerTypeRepository repo;
    @Override
    public List<DangerType> getAll() {
        return repo.findAll();
    }

    @Override
    public DangerType getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void save(DangerType convert) {
        repo.save(convert);
    }

    @Override
    public void update(DangerTypeDTO dangerType) {
        Optional<DangerType> target = repo.findById(dangerType.getId());
        DangerType dangType = null;
        if (target.isPresent()) {
            dangType = target.get();
            if (dangType != null) {
                dangType.setId(dangerType.getId());
                dangType.setName(dangerType.getName());

                repo.save(dangType);
            }
        }
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
