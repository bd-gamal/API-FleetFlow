package com.fleetflow.dto;

import com.fleetflow.entity.StatutLivraison;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivraisonStatutRequestDTO {
    private StatutLivraison statut;
}
