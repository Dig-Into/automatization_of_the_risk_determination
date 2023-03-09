package aord.dto;

import aord.model.DangerName;
import aord.model.DangerType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Getter
@Setter
public class DangerNameDTO {
    private Long id;
    private Integer dangerNumber;
    @ManyToOne
    @JoinColumn(name = "danger_type_id")
    private DangerType dangerType;
    private String description;

    public DangerNameDTO(DangerName dangerName) {
        this.id = dangerName.getId();
        this.dangerNumber = dangerName.getDangerNumber();
        this.description = dangerName.getDescription();

        DangerType dangType = dangerName.getDangerType();
        if (dangType != null) {
            this.dangerType = dangType;
        }
    }

}