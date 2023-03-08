package aord.converter;

import aord.dto.DangerTypeDTO;
import aord.model.DangerType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToDangerTypeDTOConverter implements Converter<DangerType, DangerTypeDTO> {
    @Override
    public DangerTypeDTO convert(DangerType source) {
        return new DangerTypeDTO(source);
    }

    public List<DangerTypeDTO> convert(List<DangerType> source) {
        List<DangerTypeDTO> list = new ArrayList<>();

        for (DangerType data: source) {
            list.add(new DangerTypeDTO(data));
        }

        return  list;
    }

}