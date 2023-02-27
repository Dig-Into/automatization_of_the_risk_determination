package aord.dto;

import aord.model.MechanicalDanger;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MechanicalDangerDTO {
    private Long id;
    private Integer dangerNumber;
    private String dangerType;
    private String description;

    public MechanicalDangerDTO(MechanicalDanger mechanicalDanger) {
        this.id = mechanicalDanger.getId();
        this.dangerNumber = mechanicalDanger.getDangerNumber();
        this.dangerType = mechanicalDanger.getDangerType();
        this.description = mechanicalDanger.getDescription();
    }

}