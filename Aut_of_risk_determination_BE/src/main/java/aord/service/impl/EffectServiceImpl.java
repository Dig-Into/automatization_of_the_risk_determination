package aord.service.impl;

import aord.dto.EffectDTO;
import aord.model.Effect;
import aord.repository.EffectRepository;
import aord.service.EffectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EffectServiceImpl implements EffectService {
    @Autowired
    EffectRepository repo;
    @Override
    public List<Effect> getAll() {
        return repo.findAll();
    }

    @Override
    public Effect getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void save(Effect convert) {
        repo.save(convert);
    }

    @Override
    public void update(EffectDTO effect) {
        Optional<Effect> target = repo.findById(effect.getId());
        Effect eff = null;
        if (target.isPresent()) {
            eff = target.get();
            if (eff != null) {
                eff.setId(effect.getId());
                eff.setValue(effect.getValue());
                eff.setDescription(effect.getDescription());

                repo.save(eff);
            }
        }
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);

    }
}
