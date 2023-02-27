package com.aord.aord.service.impl;

import com.aord.aord.dto.KinneyIndexDTO;
import com.aord.aord.model.KinneyIndex;
import com.aord.aord.repository.KinneyIndexRepository;
import com.aord.aord.service.KinneyIndexService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class KinneyIndexImpl implements KinneyIndexService {

    @Autowired
    KinneyIndexRepository kinneyIndexRepository;

    @Override
    public List<KinneyIndex> getAll() {
        return kinneyIndexRepository.findAll();
    }

    @Override
    public KinneyIndex getById(Long id) {
        return kinneyIndexRepository.findById(id).get();
    }

    @Override
    public void save(KinneyIndex convert) {
        kinneyIndexRepository.save(convert);
    }

    @Override
    public void update(KinneyIndexDTO kinneyIndex) {
        Optional<KinneyIndex> target = kinneyIndexRepository.findById(kinneyIndex.getId());
        KinneyIndex kinn = null;
        if (target.isPresent()) {
            kinn = target.get();
            if (kinn != null) {
                kinn.setId(kinneyIndex.getId());
                kinn.setValue(kinneyIndex.getValue());
                kinn.setDescription(kinneyIndex.getDescription());

                kinneyIndexRepository.save(kinn);

            }

        }
    }

    @Override
    public void delete(Long id) {
        kinneyIndexRepository.deleteById(id);
    }
}