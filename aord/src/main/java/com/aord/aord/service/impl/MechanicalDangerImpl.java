package com.aord.aord.service.impl;

import com.aord.aord.dto.MechanicalDangerDTO;
import com.aord.aord.model.MechanicalDanger;
import com.aord.aord.repository.MechanicalDangerRepository;
import com.aord.aord.service.MechanicalDangerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MechanicalDangerImpl implements MechanicalDangerService {

    @Autowired
    MechanicalDangerRepository mechanicalDangerRepository;
    @Override
    public List<MechanicalDanger> getAll() {
        return mechanicalDangerRepository.findAll();
    }

    @Override
    public MechanicalDanger getById(Long id) {
        return mechanicalDangerRepository.findById(id).get();
    }

    @Override
    public void save(MechanicalDanger convert) {
        mechanicalDangerRepository.save(convert);
    }

    @Override
    public void update(MechanicalDangerDTO mechanicalDanger) {
        Optional<MechanicalDanger> target = mechanicalDangerRepository.findById(mechanicalDanger.getId());
        MechanicalDanger mechDang = null;
        if (target.isPresent()) {
            mechDang = target.get();
            if (mechDang != null) {
                mechDang.setId(mechanicalDanger.getId());
                mechDang.setDangerNumber(mechanicalDanger.getDangerNumber());
                mechDang.setDangerType(mechanicalDanger.getDangerType());
                mechDang.setDescription(mechanicalDanger.getDescription());

                mechanicalDangerRepository.save(mechDang);

            }

        }
    }

    @Override
    public void delete(Long id) {
        mechanicalDangerRepository.deleteById(id);
    }
}
