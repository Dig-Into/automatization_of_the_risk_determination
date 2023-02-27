package com.aord.aord.converter;

import com.aord.aord.dto.ProbabilityDTO;
import com.aord.aord.model.Probability;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToProbabilityConverter implements Converter<ProbabilityDTO, Probability> {

    @Override
    public Probability convert(ProbabilityDTO source) {
        Probability probability = new Probability();

        probability.setId(source.getId());
        probability.setValue(source.getValue());
        probability.setDescription(source.getDescription());

        return probability;
    }

}