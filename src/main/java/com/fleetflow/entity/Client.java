package com.fleetflow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Client {
    private Long id;
    private String nom;
    private  String email;
    private  String ville;
    private  String telephone;
    @OneToMany(mappedBy = "clients")
    private List<Livraison> livrasionList;
}
