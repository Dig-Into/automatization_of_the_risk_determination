package com.aord.aord.dto;

import com.aord.aord.model.Frequency;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FrequencyDTO {

    private Long id;
    private Double value;
    private String description;

    public FrequencyDTO() {
        // Default constructor
    }

    public FrequencyDTO(Frequency frequency) {
        this.id = frequency.getId();
        this.value = frequency.getValue();
        this.description = frequency.getDescription();
    }
}