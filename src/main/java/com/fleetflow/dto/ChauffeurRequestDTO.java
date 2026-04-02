package com.fleetflow.dto;

import lombok.Data;

@Data
public class ChauffeurRequestDTO {
    private String nom;
    private String telephone;
    private String permisType;
    private boolean disponible;
}
