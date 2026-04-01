package com.fleetflow.dto;

import com.fleetflow.entity.Client;
import com.fleetflow.entity.StatusLivraison;

import java.time.LocalDate;

public class Livraisondto {
    private LocalDate dateLivraison;
    private String adresseDepart;
    private  String adresseDestination;
    private StatusLivraison status;
    private Long clientId;

}
