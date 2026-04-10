package com.fleetflow.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDTO {
    @NotBlank(message = "le nom est obligatoire")
    private String nom;
    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Le format de l'email est invalide")
    private String email;
    @NotBlank(message = "La ville est obligatoire")
    private String ville;
    @NotBlank(message = "Le telephone est obligatoire")
    private String telephone;
}
