package com.aord.aord.dto;

import com.aord.aord.model.Probability;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProbabilityDTO {

    private Long id;
    private Double value;
    private String description;

    public ProbabilityDTO() {
        // Default constructor
    }

    public ProbabilityDTO(Probability probability) {
        this.id = probability.getId();
        this.value = probability.getValue();
        this.description = probability.getDescription();
    }

}