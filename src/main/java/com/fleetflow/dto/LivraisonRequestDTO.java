package com.fleetflow.dto;

import com.fleetflow.entity.StatutLivraison;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivraisonRequestDTO {
    private LocalDate dateLivraison;
    private String adresseDepart;
    private String adresseDestination;
    private Long clientId;
}
