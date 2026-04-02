package com.fleetflow.mapper;

import com.fleetflow.dto.LivraisonRequestDTO;
import com.fleetflow.dto.LivraisonResponseDTO;
import com.fleetflow.dto.LivraisonStatutRequestDTO;
import com.fleetflow.dto.VehiculeResponseDTO;
import com.fleetflow.entity.Livraison;
import com.fleetflow.entity.Vehicule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LivraisonMapper {
    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "vehicule.id", target = "vehiculeId")
    @Mapping(source = "chauffeur.id", target = "chauffeurId")
    LivraisonResponseDTO toResponseDto(Livraison livraison);

    List<LivraisonResponseDTO> toResponseDtoList(List<Livraison> livraisons);

    @Mapping(source = "clientId", target = "client.id")
    Livraison toEntity(LivraisonRequestDTO dto);

    void updateEntityFromDto(LivraisonRequestDTO dto, @MappingTarget Livraison livraison);

    void updateStatutFromDto(LivraisonStatutRequestDTO dto, @MappingTarget Livraison livraison);
}
