package com.fleetflow.mapper;

import com.fleetflow.dto.Livraisondto;
import com.fleetflow.entity.Livraison;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LivraisonMapper {
    @Mapping(source = "client.id",target = "clientId")
    Livraisondto toDto(Livraison livraison);

    @Mapping(source ="clientId",target ="client.id")
    Livraison toEntity(Livraisondto livraisondto);

}
