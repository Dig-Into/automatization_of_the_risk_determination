package com.aord.aord.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity(name = "MechanicalDangerDetails")
@Table
public class MechanicalDangerDetails {

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
    @JoinColumn(name = "mechanical_danger_id")
    private MechanicalDanger mechanicalDanger;

    @Column
    private Double value;

    @Column
    private String description;

}