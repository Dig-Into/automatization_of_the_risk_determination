package com.aord.aord.service;

import com.aord.aord.dto.EffectDTO;
import com.aord.aord.model.Effect;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EffectService {

    List<Effect> getAll();
    Effect getById(Long id);
    void save(Effect convert);
    void update(EffectDTO effect);
    void delete(Long id);

}