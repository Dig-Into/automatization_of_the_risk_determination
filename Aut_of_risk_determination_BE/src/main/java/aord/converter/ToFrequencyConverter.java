package aord.converter;

import aord.dto.FrequencyDTO;
import aord.model.Frequency;
import aord.repository.FrequencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToFrequencyConverter implements Converter<FrequencyDTO, Frequency> {
    @Override
    public Frequency convert(FrequencyDTO source) {
        Frequency frequency = new Frequency();

        frequency.setId(source.getId());
        frequency.setCode(source.getCode());
        frequency.setDescription(source.getDescription());

        return frequency;
    }
}