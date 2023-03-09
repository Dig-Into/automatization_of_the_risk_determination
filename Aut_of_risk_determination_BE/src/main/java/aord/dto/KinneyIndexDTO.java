package aord.dto;


import aord.model.Effect;
import aord.model.Frequency;
import aord.model.KinneyIndex;
import aord.model.Probability;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Getter
@Setter
public class KinneyIndexDTO {
    private Long id;
    private Double value;
    private String description;
    @ManyToOne
    @JoinColumn(name = "probability_id")
    private Probability probability;
    @ManyToOne
    @JoinColumn(name = "effect_id")
    private Effect effect;
    @ManyToOne
    @JoinColumn(name = "frequency_id")
    private Frequency frequency;

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