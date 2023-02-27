package com.aord.aord.dto;

import com.aord.aord.model.MechanicalDanger;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MechanicalDangerDTO {

    private Long id;
    private Integer dangerNumber;
    private String dangerType;
    private String description;

    public MechanicalDangerDTO() {
        // Default constructor
    }

    public MechanicalDangerDTO(MechanicalDanger mechanicalDanger) {
        this.id = mechanicalDanger.getId();
        this.dangerNumber = mechanicalDanger.getDangerNumber();
        this.dangerType = mechanicalDanger.getDangerType();
        this.description = mechanicalDanger.getDescription();
    }
}