package com.fleetflow.dto;

import com.fleetflow.entity.StatutVehicule;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculeRequestDTO {
    @NotBlank(message = "Le matricule est obligatoire")
    private String matricule;
    @NotBlank(message = "Le type de véhicule est obligatoire")
    private String type;
    @Positive(message = "La capacité doit être strictement positive")
    private int capacite;
    @NotNull(message = "Le statut du véhicule est obligatoire")
    private StatutVehicule statut;
}
