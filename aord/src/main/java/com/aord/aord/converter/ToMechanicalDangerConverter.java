package com.aord.aord.converter;

import com.aord.aord.dto.MechanicalDangerDTO;
import com.aord.aord.model.MechanicalDanger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToMechanicalDangerConverter implements Converter<MechanicalDangerDTO, MechanicalDanger> {

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