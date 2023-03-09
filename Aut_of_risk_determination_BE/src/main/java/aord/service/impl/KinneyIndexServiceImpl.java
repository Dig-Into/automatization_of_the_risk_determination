package aord.service.impl;

import aord.dto.KinneyIndexDTO;
import aord.model.KinneyIndex;
import aord.repository.KinneyIndexRepository;
import aord.service.KinneyIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KinneyIndexServiceImpl implements KinneyIndexService {
    @Autowired
    KinneyIndexRepository repo;
    @Override
    public List<KinneyIndex> getAll() {
        return repo.findAll();
    }

    @Override
    public KinneyIndex getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void save(KinneyIndex convert) {
        repo.save(convert);
    }

    @Override
    public void update(KinneyIndexDTO kinneyIndex) {
        Optional<KinneyIndex> target = repo.findById(kinneyIndex.getId());
        KinneyIndex kinn = null;
        if (target.isPresent()) {
            kinn = target.get();
            if (kinn != null) {
                kinn.setId(kinneyIndex.getId());
                kinn.setValue(kinneyIndex.getValue());
                kinn.setDescription(kinneyIndex.getDescription());
                kinn.setProbability(kinneyIndex.getProbability());
                kinn.setEffect(kinneyIndex.getEffect());
                kinn.setFrequency(kinneyIndex.getFrequency());

                repo.save(kinn);
            }
        }
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}