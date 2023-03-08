package aord.converter;

import aord.dto.DangerDetailsDescriptionDTO;
import aord.model.DangerDetailsDescription;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToDangerDetailsDescriptionConverter implements Converter<DangerDetailsDescriptionDTO, DangerDetailsDescription> {
    @Override
    public DangerDetailsDescription convert(DangerDetailsDescriptionDTO source) {
        DangerDetailsDescription dangerDetailsDescription = new DangerDetailsDescription();

        dangerDetailsDescription.setId(source.getId());
        dangerDetailsDescription.setDescription(source.getDescription());

        return dangerDetailsDescription;
    }

}