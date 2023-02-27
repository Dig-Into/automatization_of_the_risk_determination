package com.aord.aord.converter;

import com.aord.aord.dto.FrequencyDTO;
import com.aord.aord.model.Frequency;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToFrequencyDTOConverter implements Converter<Frequency, FrequencyDTO> {

    @Override
    public FrequencyDTO convert(Frequency source) {
        return new FrequencyDTO(source);
    }

    public List<FrequencyDTO> convert(List<Frequency> source) {
        List<FrequencyDTO> list = new ArrayList<>();

        for (Frequency data: source) {
            list.add(new FrequencyDTO(data));
        }

        return list;
    }

}