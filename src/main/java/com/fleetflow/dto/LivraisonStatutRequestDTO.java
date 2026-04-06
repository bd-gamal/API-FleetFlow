package com.fleetflow.dto;

import com.fleetflow.entity.StatutLivraison;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivraisonStatutRequestDTO {
    @NotBlank(message = "Le statut de livraison est obligatoire")
    private StatutLivraison statut;
}
