package aord.converter;

import aord.dto.MechanicalDangerDetailsDTO;
import aord.model.MechanicalDangerDetails;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToMechanicalDangerDetailsDTOConverter implements Converter<MechanicalDangerDetails, MechanicalDangerDetailsDTO> {

    @Override
    public MechanicalDangerDetailsDTO convert(MechanicalDangerDetails source) {
        return new MechanicalDangerDetailsDTO(source);
    }

    public List<MechanicalDangerDetailsDTO> convert(List<MechanicalDangerDetails> source) {
        List<MechanicalDangerDetailsDTO> list = new ArrayList<>();

        for (MechanicalDangerDetails data: source) {
            list.add(new MechanicalDangerDetailsDTO(data));
        }

        return list;
    }
}