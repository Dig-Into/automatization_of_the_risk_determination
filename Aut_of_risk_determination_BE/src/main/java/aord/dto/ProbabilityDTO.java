package aord.dto;

import aord.model.Probability;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class ProbabilityDTO {
    private Long id;
    private Double code;
    private String description;

    public ProbabilityDTO(Probability probability) {
        this.id = probability.getId();
        this.code = probability.getCode();
        this.description = probability.getDescription();
    }

}