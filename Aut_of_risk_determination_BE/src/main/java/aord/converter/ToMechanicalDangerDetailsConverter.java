package aord.converter;

import aord.dto.MechanicalDangerDetailsDTO;
import aord.model.*;
import aord.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class ToMechanicalDangerDetailsConverter implements Converter<MechanicalDangerDetailsDTO, MechanicalDangerDetails> {
    @Autowired
    MechanicalDangerRepository mechanicalDangerRepository;

    @Autowired
    ProbabilityRepository probabilityRepository;

    @Autowired
    EffectRepository effectRepository;

    @Autowired
    FrequencyRepository frequencyRepository;

    @Override
    public MechanicalDangerDetails convert(MechanicalDangerDetailsDTO source) {
        MechanicalDangerDetails mechanicalDangerDetails = new MechanicalDangerDetails();

        mechanicalDangerDetails.setId(source.getId());
        mechanicalDangerDetails.setDescription(source.getDescription());
        mechanicalDangerDetails.setValue(source.getValue());

        Probability probability = probabilityRepository.findById(source.getProbability().getId()).get();

        if (!ObjectUtils.isEmpty(probability)) {
            mechanicalDangerDetails.setProbability(probability);
        }

        Effect effect = effectRepository.findById(source.getEffect().getId()).get();

        if (!ObjectUtils.isEmpty(effect)) {
            mechanicalDangerDetails.setEffect(effect);
        }

        Frequency frequency = frequencyRepository.findById(source.getFrequency().getId()).get();

        if (!ObjectUtils.isEmpty(frequency)) {
            mechanicalDangerDetails.setFrequency(frequency);
        }

        MechanicalDanger mechanicalDanger = mechanicalDangerRepository.findById(source.getMechanicalDanger().getId()).get();

        if (!ObjectUtils.isEmpty(mechanicalDanger)) {
            mechanicalDangerDetails.setMechanicalDanger(mechanicalDanger);
        }

        return mechanicalDangerDetails;

    }

}