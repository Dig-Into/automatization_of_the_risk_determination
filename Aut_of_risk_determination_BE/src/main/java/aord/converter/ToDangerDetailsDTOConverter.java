package aord.converter;

import aord.dto.DangerDetailsDTO;
import aord.model.DangerDetails;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToDangerDetailsDTOConverter implements Converter<DangerDetails, DangerDetailsDTO> {

    @Override
    public DangerDetailsDTO convert(DangerDetails source) {
        return new DangerDetailsDTO(source);
    }

    public List<DangerDetailsDTO> convert(List<DangerDetails> source) {
        List<DangerDetailsDTO> list = new ArrayList<>();

        for (DangerDetails data: source) {
            list.add(new DangerDetailsDTO(data));
        }

        return list;
    }
}