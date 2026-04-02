package com.fleetflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "livraisons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_livraison")
    private LocalDateTime dateLivraison;

    @Column(name = "adresse_depart")
    private String adresseDepart;

    @Column(name = "adresse_destination")
    private String adresseDestination;

    @Enumerated(EnumType.STRING)
    private StatutLivraison statut;

    @Column(name = "clients_id")
    private Long clientId;
}
