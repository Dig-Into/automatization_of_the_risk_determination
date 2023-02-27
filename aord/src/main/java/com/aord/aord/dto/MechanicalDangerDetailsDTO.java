package com.aord.aord.dto;

import com.aord.aord.model.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MechanicalDangerDetailsDTO {

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

    @ManyToOne
    @JoinColumn(name = "mechanical_danger_id")
    private MechanicalDanger mechanicalDanger;

    private Double value;

    private String description;

    public MechanicalDangerDetailsDTO() {
        // Default constructor
    }
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

        MechanicalDanger mechDang = mechanicalDangerDetails.getMechanicalDanger();
        if (mechDang != null) {
            this.mechanicalDanger = mechDang;
        }

    }
}