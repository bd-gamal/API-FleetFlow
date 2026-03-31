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
    private  Long id;
    private  String nom;
    private String ville;

//    public static Clientdto toDto(Client entity){
//        return Clientdto.builder()
//                .id(entity.getId())
//                .nom(entity.getNom())
//                .ville(entity.getVille())
//                .build();
//    }
}
