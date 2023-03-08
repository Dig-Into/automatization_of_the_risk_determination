package aord.converter;

import aord.dto.DangerDetailsDTO;
import aord.model.*;
import aord.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToDangerDetailsConverter implements Converter<DangerDetailsDTO, DangerDetails> {
    @Autowired
    DangerNameRepository dangerNameRepository;

    @Autowired
    ProbabilityRepository probabilityRepository;

    @Autowired
    EffectRepository effectRepository;

    @Autowired
    FrequencyRepository frequencyRepository;

    @Autowired
    DangerDetailsDescriptionRepository dangerDetailsDescriptionRepository;

    @Override
    public DangerDetails convert(DangerDetailsDTO source) {
        DangerDetails dangerDetails = new DangerDetails();

        dangerDetails.setId(source.getId());
        dangerDetails.setCode(source.getCode());
        dangerDetails.setValue(source.getValue());

        Probability probability = probabilityRepository.findById(source.getProbability().getId()).get();

        if (!ObjectUtils.isEmpty(probability)) {
            dangerDetails.setProbability(probability);
        }

        Effect effect = effectRepository.findById(source.getEffect().getId()).get();

        if (!ObjectUtils.isEmpty(effect)) {
            dangerDetails.setEffect(effect);
        }

        Frequency frequency = frequencyRepository.findById(source.getFrequency().getId()).get();

        if (!ObjectUtils.isEmpty(frequency)) {
            dangerDetails.setFrequency(frequency);
        }

        DangerName dangerName = dangerNameRepository.findById(source.getDangerName().getId()).get();

        if (!ObjectUtils.isEmpty(dangerName)) {
            dangerDetails.setDangerName(dangerName);
        }

        List<DangerDetailsDescription> dangerDetailsDescriptions = dangerDetailsDescriptionRepository.findAll();
        List<DangerDetailsDescription> listToReturn = new ArrayList<>();

        for (DangerDetailsDescription data: dangerDetailsDescriptions) {
            if (source.getDescriptions().contains(data.getId())) {
                listToReturn.add(data);
            }
        }
        dangerDetails.setDescriptions(listToReturn);

        return dangerDetails;

    }

}