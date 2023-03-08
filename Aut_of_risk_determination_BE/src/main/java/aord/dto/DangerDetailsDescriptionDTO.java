package aord.dto;

import aord.model.DangerDetailsDescription;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DangerDetailsDescriptionDTO {
    private Long id;
    private String description;

    public DangerDetailsDescriptionDTO(DangerDetailsDescription dangerDetailsDescription) {
        this.id = dangerDetailsDescription.getId();
        this.description = dangerDetailsDescription.getDescription();
    }

}