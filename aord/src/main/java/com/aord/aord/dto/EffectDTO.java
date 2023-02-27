package com.aord.aord.dto;

import com.aord.aord.model.Effect;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EffectDTO {

    private Long id;
    private Double value;
    private String description;

    public EffectDTO() {
        // Default constructor
    }

    public EffectDTO(Effect effect) {
        this.id = effect.getId();
        this.value = effect.getValue();
        this.description = effect.getDescription();
    }
}