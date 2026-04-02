package com.fleetflow.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private  String email;
    private  String ville;
    private  String telephone;
    @OneToMany(mappedBy = "client")
    private List<Livraison> livrasionList;
}
