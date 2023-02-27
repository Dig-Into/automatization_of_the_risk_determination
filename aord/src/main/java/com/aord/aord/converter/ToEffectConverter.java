package com.aord.aord.converter;

import com.aord.aord.dto.EffectDTO;
import com.aord.aord.model.Effect;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToEffectConverter implements Converter<EffectDTO, Effect> {

    @Override
    public Effect convert(EffectDTO source) {
        Effect effect = new Effect();

        effect.setId(source.getId());
        effect.setValue(source.getValue());
        effect.setDescription(source.getDescription());

        return effect;
    }

}