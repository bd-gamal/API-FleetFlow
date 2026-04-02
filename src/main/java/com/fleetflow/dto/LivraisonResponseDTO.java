package com.fleetflow.dto;

import com.fleetflow.entity.StatusLivraison;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
public class LivraisonResponseDTO {
    private Long id;
    private LocalDate dateLivraison;
    private String adresseDepart;
    private String adresseDestination;
    private StatusLivraison statutLivraison;
    private Long clientId;
    private Long vehiculeId;
    private Long chauffeurId;
}
