package com.fleetflow.dto;

import com.fleetflow.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clientdto {
    private Long id;
    private String nom;
    private String email;
    private String ville;
    private String telephone;
}
