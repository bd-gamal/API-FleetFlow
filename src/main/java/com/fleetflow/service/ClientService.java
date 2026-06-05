package com.fleetflow.service;

import com.fleetflow.dto.ClientRequestDTO;
import com.fleetflow.dto.ClientResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {
    ClientResponseDTO addClient(ClientRequestDTO client);
    ClientResponseDTO updateClient(Long id, ClientRequestDTO client);
    ClientResponseDTO findById(Long id);
    void deleteClient(Long id);
    Page<ClientResponseDTO> getAllClients(Pageable pageable);
}
