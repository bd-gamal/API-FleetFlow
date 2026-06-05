package com.fleetflow.service;

import com.fleetflow.dto.ClientRequestDTO;
import com.fleetflow.dto.ClientResponseDTO;
import com.fleetflow.entity.Client;
import com.fleetflow.mapper.ClientMapper;
import com.fleetflow.repository.ClientRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;
    private  final ClientMapper clientMapper;

    @Override
    @Transactional
     public ClientResponseDTO addClient(ClientRequestDTO client){
         if (clientRepo.existsByEmail(client.getEmail())) {
             throw new RuntimeException("Email already exists");
         }
        Client addClient = clientMapper.toEntity(client);
        Client saveClient =clientRepo.save(addClient);
        return clientMapper.toDTO(saveClient);
     }

     @Override
     @Transactional
     public ClientResponseDTO updateClient(Long id , ClientRequestDTO client){
        Client findClient =clientRepo.findById(id).orElseThrow(()->new RuntimeException("not Exist"));
        clientMapper.updateClient(client, findClient);
         Client clientUpdated = clientRepo.save(findClient);
         return  clientMapper.toDTO(clientUpdated);
     }

     @Override
     @Transactional
    public  ClientResponseDTO findById(Long id){
        return  clientRepo.findById(id).map(clientMapper::toDTO).orElseThrow(()->new EntityNotFoundException("not found"));
    }

    @Override
    @Transactional
    public  void deleteClient( Long id){
        clientRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Page<ClientResponseDTO> getAllClients(Pageable pageable){
        Page<Client> clients = clientRepo.findAll(pageable);
                return clients.map(clientMapper::toDTO);
    }
}
