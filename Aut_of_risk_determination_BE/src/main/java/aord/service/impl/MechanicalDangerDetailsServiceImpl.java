package aord.service.impl;

import aord.dto.DangerDetailsDTO;
import aord.model.DangerDetails;
import aord.repository.MechanicalDangerDetailsRepository;
import aord.service.MechanicalDangerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MechanicalDangerDetailsServiceImpl implements MechanicalDangerDetailsService {
    @Autowired
    MechanicalDangerDetailsRepository repo;

    @Override
    public List<DangerDetails> getAll() {
        return repo.findAll();
    }

    @Override
    public DangerDetails getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void save(DangerDetails convert) {
        repo.save(convert);
    }

    @Override
    public void update(DangerDetailsDTO mechanicalDangerDetails) {
        Optional<DangerDetails> target = repo.findById(mechanicalDangerDetails.getId());
        DangerDetails mechDangDetails = null;
        if (target.isPresent()) {
            mechDangDetails = target.get();
            if (mechDangDetails != null) {
                mechDangDetails.setId(mechanicalDangerDetails.getId());
                mechDangDetails.setValue(mechanicalDangerDetails.getValue());
                mechDangDetails.setDescription(mechanicalDangerDetails.getDescription());
                mechDangDetails.setProbability(mechanicalDangerDetails.getProbability());
                mechDangDetails.setEffect(mechanicalDangerDetails.getEffect());
                mechDangDetails.setFrequency(mechanicalDangerDetails.getFrequency());

                repo.save(mechDangDetails);
            }
        }
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
