package aord.converter;

import aord.dto.KinneyIndexDTO;
import aord.dto.ProbabilityDTO;
import aord.model.Effect;
import aord.model.Frequency;
import aord.model.KinneyIndex;
import aord.model.Probability;
import aord.repository.EffectRepository;
import aord.repository.FrequencyRepository;
import aord.repository.KinneyIndexRepository;
import aord.repository.ProbabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class ToKinneyIndexConverter implements Converter<KinneyIndexDTO, KinneyIndex> {
    @Autowired
    KinneyIndexRepository repo;

    @Autowired
    ProbabilityRepository probabilityRepository;

    @Autowired
    EffectRepository effectRepository;

    @Autowired
    FrequencyRepository frequencyRepository;

    @Override
    public KinneyIndex convert(KinneyIndexDTO source) {
        KinneyIndex kinneyIndex = new KinneyIndex();

        kinneyIndex.setId(source.getId());
        kinneyIndex.setValue(source.getValue());
        kinneyIndex.setDescription(source.getDescription());

        Probability probability = probabilityRepository.findById(source.getProbability().getId()).get();

        if (!ObjectUtils.isEmpty(probability)) {
            kinneyIndex.setProbability(probability);
        }

        Effect effect = effectRepository.findById(source.getEffect().getId()).get();

        if (!ObjectUtils.isEmpty(effect)) {
            kinneyIndex.setEffect(effect);
        }

        Frequency frequency = frequencyRepository.findById(source.getFrequency().getId()).get();

        if (!ObjectUtils.isEmpty(frequency)) {
            kinneyIndex.setFrequency(frequency);
        }

        return kinneyIndex;
    }
}