package com.fleetflow.dto;

import com.fleetflow.entity.StatutLivraison;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivraisonResponseDTO {
    private Long id;
    private LocalDateTime dateLivraison;
    private String adresseDepart;
    private String adresseDestination;
    private StatutLivraison statut;
    private Long clientId;
}
