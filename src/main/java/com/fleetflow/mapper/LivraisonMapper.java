package com.fleetflow.mapper;

import com.fleetflow.dto.LivraisonRequestDTO;
import com.fleetflow.dto.LivraisonResponseDTO;
import com.fleetflow.dto.LivraisonStatutRequestDTO;
import com.fleetflow.dto.VehiculeResponseDTO;
import com.fleetflow.entity.Livraison;
import com.fleetflow.entity.Vehicule;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LivraisonMapper {

    LivraisonResponseDTO toResponseDto(Livraison livraison);

    List<LivraisonResponseDTO> toResponseDtoList(List<Livraison> livraisons);

    Livraison toEntity(LivraisonRequestDTO dto);

    void updateEntityFromDto(LivraisonRequestDTO dto, @MappingTarget Livraison livraison);

    void updateStatutFromDto(LivraisonStatutRequestDTO dto, @MappingTarget Livraison livraison);
}
