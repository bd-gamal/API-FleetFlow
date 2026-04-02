package com.fleetflow.mapper;

import com.fleetflow.dto.ChauffeurRequestDTO;
import com.fleetflow.dto.ChauffeurResponseDTO;
import com.fleetflow.entity.Chauffeur;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ChauffeurMapper {

    ChauffeurResponseDTO toDto(Chauffeur chauffeur);

    Chauffeur toEntity(ChauffeurRequestDTO dto);

    void updateEntityFromDto(ChauffeurRequestDTO dto, @MappingTarget Chauffeur chauffeur);
}
