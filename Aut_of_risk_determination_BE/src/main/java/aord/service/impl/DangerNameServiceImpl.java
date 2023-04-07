package aord.service.impl;

import aord.dto.DangerNameDTO;
import aord.model.DangerName;
import aord.repository.DangerNameRepository;
import aord.service.DangerNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DangerNameServiceImpl implements DangerNameService {
    @Autowired
    DangerNameRepository repo;
    @Override
    public List<DangerName> getAll() {
        return repo.findAll();
    }

    @Override
    public DangerName getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Integer> getAllDangerNameCodes() {
        return repo.getAllDangerNameCodes();
    }

    @Override
    public DangerName findDangerNameByDangerNumber(Integer dangerNumber) {
        return repo.findDangerNameByDangerNumber(dangerNumber);
    }


    @Override
    public void save(DangerName convert) {
        repo.save(convert);
    }

    @Override
    public void update(DangerNameDTO dangerName) {
        Optional<DangerName> target = repo.findById(dangerName.getId());
        DangerName dangName = null;
        if (target.isPresent()) {
            dangName = target.get();
            if (dangName != null) {
                dangName.setId(dangerName.getId());
                dangName.setDangerNumber(dangerName.getDangerNumber());
                dangName.setDangerType(dangerName.getDangerType());
                dangName.setDescription(dangerName.getDescription());

                repo.save(dangName);
            }
        }
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}