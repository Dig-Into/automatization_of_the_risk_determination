package aord.service.impl;

import aord.dto.DangerDetailsDTO;
import aord.model.DangerDetails;
import aord.repository.DangerDetailsRepository;
import aord.service.DangerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DangerDetailsServiceImpl implements DangerDetailsService {
    @Autowired
    DangerDetailsRepository repo;

    @Override
    public List<DangerDetails> getAll() {
        return repo.findAll();
    }

    @Override
    public DangerDetails getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public DangerDetails findDangerDetailsByCode(Integer code) {
        return repo.findDangerDetailsByCode(code);
    }


    @Override
    public void save(DangerDetails convert) {
        repo.save(convert);
    }

    @Override
    public void update(DangerDetailsDTO dangerDetails) {
        Optional<DangerDetails> target = repo.findById(dangerDetails.getId());
        DangerDetails dangDetails = null;
        if (target.isPresent()) {
            dangDetails = target.get();
            if (dangDetails != null) {
                dangDetails.setId(dangerDetails.getId());
                dangDetails.setCode(dangerDetails.getCode());
                dangDetails.setValue(dangerDetails.getValue());
                dangDetails.setDescriptions(dangerDetails.getDescriptions());
                dangDetails.setProbability(dangerDetails.getProbability());
                dangDetails.setEffect(dangerDetails.getEffect());
                dangDetails.setFrequency(dangerDetails.getFrequency());
                dangDetails.setDangerName(dangerDetails.getDangerName());

                repo.save(dangDetails);
            }
        }
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
