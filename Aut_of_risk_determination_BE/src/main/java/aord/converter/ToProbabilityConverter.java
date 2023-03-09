package aord.converter;

import aord.dto.ProbabilityDTO;
import aord.model.Probability;
import aord.repository.ProbabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToProbabilityConverter implements Converter<ProbabilityDTO, Probability> {
    @Override
    public Probability convert(ProbabilityDTO source) {
        Probability probability = new Probability();

        probability.setId(source.getId());
        probability.setCode(source.getCode());
        probability.setDescription(source.getDescription());

        return probability;
    }

}