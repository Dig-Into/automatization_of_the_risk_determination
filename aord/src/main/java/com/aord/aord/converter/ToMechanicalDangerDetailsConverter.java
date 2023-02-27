package com.aord.aord.converter;

import com.aord.aord.dto.MechanicalDangerDetailsDTO;
import com.aord.aord.model.*;
import com.aord.aord.repository.EffectRepository;
import com.aord.aord.repository.FrequencyRepository;
import com.aord.aord.repository.MechanicalDangerRepository;
import com.aord.aord.repository.ProbabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class ToMechanicalDangerDetailsConverter implements Converter<MechanicalDangerDetailsDTO, MechanicalDangerDetails> {

    @Autowired
    ProbabilityRepository probabilityRepository;

    @Autowired
    EffectRepository effectRepository;

    @Autowired
    FrequencyRepository frequencyRepository;
    @Autowired
    MechanicalDangerRepository mechanicalDangerRepository;

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

        MechanicalDanger mechDanger = mechanicalDangerRepository.findById(source.getMechanicalDanger().getId()).get();

        if (!ObjectUtils.isEmpty(mechDanger)) {
            mechanicalDangerDetails.setMechanicalDanger(mechDanger);
        }

        return mechanicalDangerDetails;

    }

}