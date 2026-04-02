package com.fleetflow.dto;

import com.fleetflow.entity.Client;
import com.fleetflow.entity.StatusLivraison;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livraisondto {
    private LocalDate dateLivraison;
    private String adresseDepart;
    private  String adresseDestination;
    private StatusLivraison statusLivraison;
    private Long clientId;

}
