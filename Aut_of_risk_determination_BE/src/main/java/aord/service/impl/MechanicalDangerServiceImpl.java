package aord.service.impl;

import aord.dto.DangerNameDTO;
import aord.model.DangerName;
import aord.repository.MechanicalDangerRepository;
import aord.service.MechanicalDangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MechanicalDangerServiceImpl implements MechanicalDangerService {
    @Autowired
    MechanicalDangerRepository repo;
    @Override
    public List<DangerName> getAll() {
        return repo.findAll();
    }

    @Override
    public DangerName getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void save(DangerName convert) {
        repo.save(convert);
    }

    @Override
    public void update(DangerNameDTO mechanicalDanger) {
        Optional<DangerName> target = repo.findById(mechanicalDanger.getId());
        DangerName mechDang = null;
        if (target.isPresent()) {
            mechDang = target.get();
            if (mechDang != null) {
                mechDang.setId(mechanicalDanger.getId());
                mechDang.setDangerNumber(mechanicalDanger.getDangerNumber());
                mechDang.setDangerType(mechanicalDanger.getDangerType());
                mechDang.setDescription(mechanicalDanger.getDescription());

                repo.save(mechDang);
            }
        }
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}