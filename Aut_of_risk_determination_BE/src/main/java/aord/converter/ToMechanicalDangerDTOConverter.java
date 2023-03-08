package aord.converter;

import aord.dto.DangerNameDTO;
import aord.model.DangerName;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToMechanicalDangerDTOConverter implements Converter<DangerName, DangerNameDTO> {

    @Override
    public DangerNameDTO convert(DangerName source) {
        return new DangerNameDTO(source);
    }

    public List<DangerNameDTO> convert(List<DangerName> source) {
        List<DangerNameDTO> list = new ArrayList<>();

        for (DangerName data: source) {
            list.add(new DangerNameDTO(data));
        }

        return list;
    }
}