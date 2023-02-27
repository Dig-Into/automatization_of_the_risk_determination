package com.aord.aord.converter;

import com.aord.aord.dto.FrequencyDTO;
import com.aord.aord.model.Frequency;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToFrequencyConverter implements Converter<FrequencyDTO, Frequency> {

    @Override
    public Frequency convert(FrequencyDTO source) {
        Frequency frequency = new Frequency();

        frequency.setId(source.getId());
        frequency.setValue(source.getValue());
        frequency.setDescription(source.getDescription());

        return frequency;
    }

}