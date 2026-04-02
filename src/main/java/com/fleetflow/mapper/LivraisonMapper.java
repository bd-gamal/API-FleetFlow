package com.fleetflow.mapper;

import com.fleetflow.dto.LivraisonRequestDTO;
import com.fleetflow.entity.Livraison;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LivraisonMapper {
    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "vehicule.id", target = "vehiculeId")
    @Mapping(source = "chauffeur.id", target = "chauffeurId")
    LivraisonRequestDTO toDto(Livraison livraison);

    @Mapping(source ="clientId", target ="client.id")
    Livraison toEntity(LivraisonRequestDTO dto);

}
