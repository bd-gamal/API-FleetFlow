package com.fleetflow.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.fleetflow.dto.Clientdto;
import com.fleetflow.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel ="spring")
public interface ClientMapper {
    Clientdto toDTO(Client client);
    Client toEntity(Clientdto clientdto);

    void updateClient(Clientdto clientdto , @MappingTarget Client client);

}
