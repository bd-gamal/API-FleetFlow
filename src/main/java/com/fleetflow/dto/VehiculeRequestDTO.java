package com.fleetflow.dto;

import com.fleetflow.entity.StatutVehicule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculeRequestDTO {
    private String matricule;
    private String type;
    private int capacite;
    private StatutVehicule statut;
}
