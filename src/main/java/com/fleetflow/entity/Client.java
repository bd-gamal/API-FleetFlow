package com.fleetflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data @NoArgsConstructor @AllArgsConstructor
public class Client extends User {

    private String nom;
    private  String ville;
    private  String telephone;
    @OneToMany(mappedBy = "client")
    private List<Livraison> livrasionList;

}
