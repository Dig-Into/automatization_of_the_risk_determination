package aord.dto;

import aord.model.Effect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EffectDTO {
    private Long id;
    private Double code;
    private String description;

    public EffectDTO(Effect effect) {
        this.id = effect.getId();
        this.code = effect.getCode();
        this.description = effect.getDescription();
    }

}