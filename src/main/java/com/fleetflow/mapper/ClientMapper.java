package com.fleetflow.mapper;

import com.fleetflow.dto.ClientRequestDTO;
import com.fleetflow.dto.ClientResponseDTO;
import com.fleetflow.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel ="spring")
public interface ClientMapper {
    ClientResponseDTO toDTO(Client client);
    List<ClientResponseDTO> toDto(List<Client> clientList);
    Client toEntity(ClientRequestDTO clientRequestDto);

    void updateClient(ClientRequestDTO clientRequestDto , @MappingTarget Client client);

}
