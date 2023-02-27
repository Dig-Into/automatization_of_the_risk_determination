package aord.converter;

import aord.dto.MechanicalDangerDTO;
import aord.model.MechanicalDanger;
import aord.repository.MechanicalDangerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToMechanicalDangerConverter implements Converter<MechanicalDangerDTO, MechanicalDanger> {
    @Autowired
    MechanicalDangerRepository repo;

    @Override
    public MechanicalDanger convert(MechanicalDangerDTO source) {
        MechanicalDanger mechanicalDanger = new MechanicalDanger();

        mechanicalDanger.setId(source.getId());
        mechanicalDanger.setDangerNumber(source.getDangerNumber());
        mechanicalDanger.setDangerType(source.getDangerType());
        mechanicalDanger.setDescription(source.getDescription());

        return mechanicalDanger;
    }
}