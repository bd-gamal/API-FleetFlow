package com.fleetflow.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricule;
    private String type;
    private int capacite;
    @Enumerated(EnumType.STRING )
    private StatutVehicule statut = StatutVehicule.DISPONIBLE;
}

