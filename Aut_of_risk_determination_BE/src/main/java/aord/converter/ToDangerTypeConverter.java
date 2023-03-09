package aord.converter;

import aord.dto.DangerTypeDTO;
import aord.model.DangerType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToDangerTypeConverter implements Converter<DangerTypeDTO, DangerType> {
    @Override
    public DangerType convert(DangerTypeDTO source) {
        DangerType dangerType = new DangerType();

        dangerType.setId(source.getId());
        dangerType.setName(source.getName());

        return dangerType;

    }

}