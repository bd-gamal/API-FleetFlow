package com.fleetflow.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.fleetflow.dto.ClientRequestDto;
import com.fleetflow.dto.Clientdto;
import com.fleetflow.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Clientdto toDTO(Client client);
    List<Clientdto> toDto(List<Client> clientList);
    Client toEntity(ClientRequestDto clientRequestDto);

    void updateClient(ClientRequestDto clientRequestDto , @MappingTarget Client client);

}
