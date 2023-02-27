package com.aord.aord.service.impl;

import com.aord.aord.dto.MechanicalDangerDetailsDTO;
import com.aord.aord.model.MechanicalDangerDetails;
import com.aord.aord.repository.MechanicalDangerDetailsRepository;
import com.aord.aord.service.MechanicalDangerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MechanicalDangerDetailsServiceImpl implements MechanicalDangerDetailsService {

    @Autowired
    MechanicalDangerDetailsRepository mechanicalDangerDetailsRepository;

    @Override
    public List<MechanicalDangerDetails> getAll() {
        return mechanicalDangerDetailsRepository.findAll();
    }

    @Override
    public MechanicalDangerDetails getById(Long id) {
        return mechanicalDangerDetailsRepository.findById(id).get();
    }

    @Override
    public void save(MechanicalDangerDetails convert) {
        mechanicalDangerDetailsRepository.save(convert);
    }

    @Override
    public void update(MechanicalDangerDetailsDTO mechanicalDangerDetails) {
        Optional<MechanicalDangerDetails> target = mechanicalDangerDetailsRepository.findById(mechanicalDangerDetails.getId());
        MechanicalDangerDetails mechDangDetails = null;
        if (target.isPresent()) {
            mechDangDetails = target.get();
            if (mechDangDetails != null) {
                mechDangDetails.setId(mechanicalDangerDetails.getId());
                mechDangDetails.setDescription(mechanicalDangerDetails.getDescription());
                mechDangDetails.setValue(mechanicalDangerDetails.getValue());

                mechanicalDangerDetailsRepository.save(mechDangDetails);

            }

        }
    }

    @Override
    public void delete(Long id) {
        mechanicalDangerDetailsRepository.deleteById(id);
    }
}
