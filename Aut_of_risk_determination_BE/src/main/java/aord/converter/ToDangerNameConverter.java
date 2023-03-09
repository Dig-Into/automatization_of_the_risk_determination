package aord.converter;

import aord.dto.DangerNameDTO;
import aord.model.DangerName;
import aord.model.DangerType;
import aord.repository.DangerNameRepository;
import aord.repository.DangerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class ToDangerNameConverter implements Converter<DangerNameDTO, DangerName> {
    @Autowired
    DangerTypeRepository dangerTypeRepository;

    @Override
    public DangerName convert(DangerNameDTO source) {
        DangerName dangerName = new DangerName();

        dangerName.setId(source.getId());
        dangerName.setDangerNumber(source.getDangerNumber());
        dangerName.setDescription(source.getDescription());

        DangerType dangerType = dangerTypeRepository.findById(source.getDangerType().getId()).get();

        if (!ObjectUtils.isEmpty(dangerType)) {
            dangerName.setDangerType(dangerType);
        }

        return dangerName;
    }
}