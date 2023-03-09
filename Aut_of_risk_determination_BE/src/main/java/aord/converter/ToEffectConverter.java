package aord.converter;

import aord.dto.EffectDTO;
import aord.model.Effect;
import aord.repository.EffectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToEffectConverter implements Converter<EffectDTO, Effect> {
    @Override
    public Effect convert(EffectDTO source) {
        Effect effect = new Effect();

        effect.setId(source.getId());
        effect.setCode(source.getCode());
        effect.setDescription(source.getDescription());

        return effect;
    }

}