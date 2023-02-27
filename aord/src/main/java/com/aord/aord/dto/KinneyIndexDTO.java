package com.aord.aord.dto;

import com.aord.aord.model.Effect;
import com.aord.aord.model.Frequency;
import com.aord.aord.model.KinneyIndex;
import com.aord.aord.model.Probability;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class KinneyIndexDTO {

    private Long id;

    @ManyToOne
    @JoinColumn(name = "probability_id")
    private Probability probability;

    @ManyToOne
    @JoinColumn(name = "effect_id")
    private Effect effect;

    @ManyToOne
    @JoinColumn(name = "frequency_id")
    private Frequency frequency;

    private Double value;
    private String description;

    public KinneyIndexDTO() {
        // Default constructor
    }

    public KinneyIndexDTO(KinneyIndex kinneyIndex) {
        this.id = kinneyIndex.getId();
        this.value = kinneyIndex.getValue();
        this.description = kinneyIndex.getDescription();

        Probability prob = kinneyIndex.getProbability();
        if (prob != null) {
            this.probability = prob;
        }

        Effect eff = kinneyIndex.getEffect();
        if (eff != null) {
            this.effect = eff;
        }

        Frequency freq = kinneyIndex.getFrequency();
        if (freq != null) {
            this.frequency = freq;
        }
    }
}