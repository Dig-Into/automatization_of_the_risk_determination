package aord.dto;

import aord.model.Effect;
import aord.model.Frequency;
import aord.model.MechanicalDangerDetails;
import aord.model.Probability;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Getter
@Setter
public class MechanicalDangerDetailsDTO {
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

    public MechanicalDangerDetailsDTO(MechanicalDangerDetails mechanicalDangerDetails) {
        this.id = mechanicalDangerDetails.getId();
        this.value = mechanicalDangerDetails.getValue();
        this.description = mechanicalDangerDetails.getDescription();

        Probability prob = mechanicalDangerDetails.getProbability();
        if (prob != null) {
            this.probability = prob;
        }

        Effect eff = mechanicalDangerDetails.getEffect();
        if (eff != null) {
            this.effect = eff;
        }

        Frequency freq = mechanicalDangerDetails.getFrequency();
        if (freq != null) {
            this.frequency = freq;
        }
    }

}