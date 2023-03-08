package aord.service;

import aord.dto.DangerDetailsDescriptionDTO;
import aord.model.DangerDetailsDescription;
import aord.repository.DangerDetailsDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DangerDetailsDescriptionServiceImpl implements DangerDetailsDescriptionService {
    @Autowired
    DangerDetailsDescriptionRepository repo;
    @Override
    public List<DangerDetailsDescription> getAll() {
        return repo.findAll();
    }

    @Override
    public DangerDetailsDescription getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void save(DangerDetailsDescription convert) {
        repo.save(convert);
    }

    @Override
    public void update(DangerDetailsDescriptionDTO dangerDetailsDescription) {
        Optional<DangerDetailsDescription> target = repo.findById(dangerDetailsDescription.getId());
        DangerDetailsDescription dangDetailsDesc = null;
        if (target.isPresent()) {
            dangDetailsDesc = target.get();
            if (dangDetailsDesc != null) {
                dangDetailsDesc.setId(dangerDetailsDescription.getId());
                dangDetailsDesc.setDescription(dangerDetailsDescription.getDescription());

                repo.save(dangDetailsDesc);
            }
        }
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
