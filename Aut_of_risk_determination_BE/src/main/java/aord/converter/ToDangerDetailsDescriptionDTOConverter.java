package aord.converter;

import aord.dto.DangerDetailsDescriptionDTO;
import aord.model.DangerDetailsDescription;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToDangerDetailsDescriptionDTOConverter implements Converter<DangerDetailsDescription, DangerDetailsDescriptionDTO> {
    @Override
    public DangerDetailsDescriptionDTO convert(DangerDetailsDescription source) {
        return new DangerDetailsDescriptionDTO(source);
    }

    public List<DangerDetailsDescriptionDTO> convert(List<DangerDetailsDescription> source) {
        List<DangerDetailsDescriptionDTO> list = new ArrayList<>();

        for (DangerDetailsDescription data: source) {
            list.add(new DangerDetailsDescriptionDTO(data));
        }

        return list;
    }

}