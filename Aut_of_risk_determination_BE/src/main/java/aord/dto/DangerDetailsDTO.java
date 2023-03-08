package aord.dto;

import aord.model.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Getter
@Setter
public class DangerDetailsDTO {
    private Long id;
    private Integer code;
    private Double value;
    @ManyToOne
    @JoinColumn(name = "danger_details_description_id")
    private DangerDetailsDescription[] descriptions;
    @ManyToOne
    @JoinColumn(name = "probability_id")
    private Probability probability;
    @ManyToOne
    @JoinColumn(name = "effect_id")
    private Effect effect;
    @ManyToOne
    @JoinColumn(name = "frequency_id")
    private Frequency frequency;
    @ManyToOne
    @JoinColumn(name = "danger_name_id")
    private DangerName dangerName;

    public DangerDetailsDTO(DangerDetails dangerDetails) {
        this.id = dangerDetails.getId();
        this.code = dangerDetails.getCode();
        this.value = dangerDetails.getValue();

        DangerDetailsDescription[] dangerDetailsDescriptions = dangerDetails.getDescriptions();
        if (dangerDetailsDescriptions.length != 0) {
            this.descriptions = dangerDetailsDescriptions;
        }

        Probability prob = dangerDetails.getProbability();
        if (prob != null) {
            this.probability = prob;
        }

        Effect eff = dangerDetails.getEffect();
        if (eff != null) {
            this.effect = eff;
        }

        Frequency freq = dangerDetails.getFrequency();
        if (freq != null) {
            this.frequency = freq;
        }

        DangerName dangName = dangerDetails.getDangerName();
        if (dangName != null) {
            this.dangerName = dangName;
        }
    }

}