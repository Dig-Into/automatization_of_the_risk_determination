package aord.dto;

import aord.model.DangerType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DangerTypeDTO {
    private Long id;
    private String name;

    public DangerTypeDTO(DangerType dangerType) {
        this.id = dangerType.getId();
        this.name = dangerType.getName();
    }
}