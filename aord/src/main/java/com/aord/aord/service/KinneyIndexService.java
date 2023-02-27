package com.aord.aord.service;

import com.aord.aord.dto.KinneyIndexDTO;
import com.aord.aord.model.KinneyIndex;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KinneyIndexService {
    List<KinneyIndex> getAll();
    KinneyIndex getById(Long id);
    void save(KinneyIndex convert);
    void update(KinneyIndexDTO kinneyIndex);
    void delete(Long id);


}