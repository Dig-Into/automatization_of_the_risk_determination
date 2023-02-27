package com.aord.aord.service.impl;

import com.aord.aord.dto.EffectDTO;
import com.aord.aord.model.Effect;
import com.aord.aord.repository.EffectRepository;
import com.aord.aord.service.EffectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EffectServiceImpl implements EffectService {

    @Autowired
    EffectRepository effectRepository;
    @Override
    public List<Effect> getAll() {
        return effectRepository.findAll();
    }

    @Override
    public Effect getById(Long id) {
        return effectRepository.findById(id).get();
    }

    @Override
    public void save(Effect convert) {
        effectRepository.save(convert);
    }

    @Override
    public void update(EffectDTO effect) {
        Optional<Effect> target = effectRepository.findById(effect.getId());
        Effect eff = null;
        if (target.isPresent()) {
            eff = target.get();
            if (eff != null) {
                eff.setId(effect.getId());
                eff.setValue(effect.getValue());
                eff.setDescription(effect.getDescription());

                effectRepository.save(eff);

            }

        }
    }

    @Override
    public void delete(Long id) {
        effectRepository.deleteById(id);
    }
}
