package aord.converter;

import aord.dto.KinneyIndexDTO;
import aord.model.KinneyIndex;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToKinneyIndexDTOConverter implements Converter<KinneyIndex, KinneyIndexDTO> {
    @Override
    public KinneyIndexDTO convert(KinneyIndex source) {
        return new KinneyIndexDTO(source);
    }

    public List<KinneyIndexDTO> convert(List<KinneyIndex> source) {
        List<KinneyIndexDTO> list = new ArrayList<>();

        for (KinneyIndex data: source) {
            list.add(new KinneyIndexDTO(data));
        }

        return list;
    }
}