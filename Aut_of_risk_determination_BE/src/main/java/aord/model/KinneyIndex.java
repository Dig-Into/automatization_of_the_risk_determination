package aord.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "KinneyIndex")
public class KinneyIndex {
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

    @Column
    private Double value;

    @Column
    private String description;

}