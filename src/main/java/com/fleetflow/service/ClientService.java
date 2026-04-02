package com.fleetflow.service;

import com.fleetflow.dto.ClientRequestDto;
import com.fleetflow.dto.Clientdto;
import com.fleetflow.entity.Client;
import com.fleetflow.mapper.ClientMapper;
import com.fleetflow.repository.ClientRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepo clientRepo;
    private  final ClientMapper clientMapper;
    public ClientService(ClientRepo clientRepo, ClientMapper clientMapper){
        this.clientRepo=clientRepo;
        this.clientMapper =clientMapper;
    }

     public Clientdto addClient(ClientRequestDto client){
        Client addClient = clientMapper.toEntity(client);
        Client saveClient =clientRepo.save(addClient);
        return clientMapper.toDTO(saveClient);
     }
     public Clientdto updateClient(Long id , ClientRequestDto client){
        Client findClient =clientRepo.findById(id).orElseThrow(()->new RuntimeException("not Exist"));
        clientMapper.updateClient(client, findClient);
         Client clientUpdated = clientRepo.save(findClient);
         return  clientMapper.toDTO(clientUpdated);
     }
    public  Clientdto findById(Long id){
        return  clientRepo.findById(id).map(client->clientMapper.toDTO(client)).orElse(new Clientdto());
//                .orElseThrow(()->new EntityNotFoundException("not found"));
    }
    public  void deleteClient( Long id){
        clientRepo.deleteById(id);
    }

    public List<Clientdto> getAllClient(){
        List<Client> clients = clientRepo.findAll();
               // return clients.stream().map(clientMapper::toDTO).toList();
        return  clientMapper.toDto(clients);
    }

}
