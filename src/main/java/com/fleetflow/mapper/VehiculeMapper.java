package com.fleetflow.mapper;
import com.fleetflow.dto.VehiculeRequestDTO;
import com.fleetflow.dto.VehiculeResponseDTO;
import com.fleetflow.entity.Vehicule;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehiculeMapper {

    VehiculeResponseDTO toResponseDto(Vehicule vehicule);

    Vehicule toEntity(VehiculeRequestDTO vehiculeRequestDTO);

    void updateEntityFromDto(VehiculeRequestDTO dto, @MappingTarget Vehicule vehicule);

    List<VehiculeResponseDTO> toResponseDtoList(List<Vehicule> vehicules);
}
