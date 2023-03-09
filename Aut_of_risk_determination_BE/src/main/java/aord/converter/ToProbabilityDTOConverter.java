package aord.converter;

import aord.dto.ProbabilityDTO;
import aord.model.Probability;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToProbabilityDTOConverter implements Converter<Probability, ProbabilityDTO> {

    @Override
    public ProbabilityDTO convert(Probability source) {
        return new ProbabilityDTO(source);
    }

    public List<ProbabilityDTO> convert(List<Probability> source) {
        List<ProbabilityDTO> list = new ArrayList<>();

        for (Probability data: source) {
            list.add(new ProbabilityDTO(data));
        }

        return list;
    }

}