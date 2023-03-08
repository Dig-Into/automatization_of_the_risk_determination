package aord.converter;

import aord.dto.DangerNameDTO;
import aord.model.DangerName;
import aord.repository.MechanicalDangerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToMechanicalDangerConverter implements Converter<DangerNameDTO, DangerName> {
    @Autowired
    MechanicalDangerRepository repo;

    @Override
    public DangerName convert(DangerNameDTO source) {
        DangerName mechanicalDanger = new DangerName();

        mechanicalDanger.setId(source.getId());
        mechanicalDanger.setDangerNumber(source.getDangerNumber());
        mechanicalDanger.setDangerType(source.getDangerType());
        mechanicalDanger.setDescription(source.getDescription());

        return mechanicalDanger;
    }
}