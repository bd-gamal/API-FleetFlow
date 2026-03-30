package com.fleetflow.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Livraison {
    private Long id;
    private LocalDate dateLivraison;
    private String adresseDepart;
    private  String adresseDestination;
    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Client client;
    @Enumerated(EnumType.STRING)
    private StatusLivraison statusLivraison;
}
