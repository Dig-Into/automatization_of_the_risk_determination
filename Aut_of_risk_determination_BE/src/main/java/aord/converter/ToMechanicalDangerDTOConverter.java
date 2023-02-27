package aord.converter;

import aord.dto.MechanicalDangerDTO;
import aord.model.MechanicalDanger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToMechanicalDangerDTOConverter implements Converter<MechanicalDanger, MechanicalDangerDTO> {

    @Override
    public MechanicalDangerDTO convert(MechanicalDanger source) {
        return new MechanicalDangerDTO(source);
    }

    public List<MechanicalDangerDTO> convert(List<MechanicalDanger> source) {
        List<MechanicalDangerDTO> list = new ArrayList<>();

        for (MechanicalDanger data: source) {
            list.add(new MechanicalDangerDTO(data));
        }

        return list;
    }
}