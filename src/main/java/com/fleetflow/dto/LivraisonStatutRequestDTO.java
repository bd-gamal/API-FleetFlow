package com.fleetflow.dto;

import com.fleetflow.entity.StatutLivraison;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivraisonStatutRequestDTO {
    @NotNull(message = "Le statut de livraison est obligatoire")
    private StatutLivraison statut;
}
