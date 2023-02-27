package com.aord.aord.service;

import com.aord.aord.dto.MechanicalDangerDetailsDTO;
import com.aord.aord.model.MechanicalDangerDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MechanicalDangerDetailsService {

    List<MechanicalDangerDetails> getAll();
    MechanicalDangerDetails getById(Long id);
    void save(MechanicalDangerDetails convert);
    void update(MechanicalDangerDetailsDTO mechanicalDangerDetails);
    void delete(Long id);
}