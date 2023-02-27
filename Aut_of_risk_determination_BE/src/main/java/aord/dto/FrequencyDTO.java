package aord.dto;

import aord.model.Frequency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FrequencyDTO {
    private Long id;
    private Double value;
    private String description;

    public FrequencyDTO(Frequency frequency) {
        this.id = frequency.getId();
        this.value = frequency.getValue();
        this.description = frequency.getDescription();
    }

}