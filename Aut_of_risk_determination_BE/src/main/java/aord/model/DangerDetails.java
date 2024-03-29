package aord.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "DangerDetails")
public class DangerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "probability_id")
    private Probability probability;

    @ManyToOne
    @JoinColumn(name = "effect_id")
    private Effect effect;

    @ManyToOne
    @JoinColumn(name = "frequency_id")
    private Frequency frequency;

    @ManyToOne
    @JoinColumn(name = "danger_name_id")
    private DangerName dangerName;

    @Column
    private Integer code;

    @Column
    private Double value;

    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> descriptions;

}