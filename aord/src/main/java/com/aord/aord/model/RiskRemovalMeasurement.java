package com.aord.aord.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity(name = "RiskRemovalMeasurement")
@Table
public class RiskRemovalMeasurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mechanical_danger_details_id")
    private MechanicalDangerDetails mechanicalDangerDetails;

    @Column
    private Double riskFactorValue;

    @Column
    private String description;

    // Measurement Implementation Frequency
    @Column
    private String measurementImplFreq;

}