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
@Table(name = "RiskRemovalMeasurement")
public class RiskRemovalMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "danger_details_id")
    private DangerDetails dangerDetails;

    @Column
    private Double riskFactorValue;
    @Column
    private String description;

    // Measurement Implementation Frequency
    @Column
    private String measurementImplFreq;

}