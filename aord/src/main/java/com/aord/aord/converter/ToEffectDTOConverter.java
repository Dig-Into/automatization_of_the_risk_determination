package com.aord.aord.converter;

import com.aord.aord.dto.EffectDTO;
import com.aord.aord.model.Effect;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToEffectDTOConverter implements Converter<Effect, EffectDTO> {

    @Override
    public EffectDTO convert(Effect source) {
        return new EffectDTO(source);
    }

    public List<EffectDTO> convert(List<Effect> source) {
        List<EffectDTO> list = new ArrayList<>();

        for (Effect data: source) {
            list.add(new EffectDTO(data));
        }

        return list;
    }

}