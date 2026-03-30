package com.fleetflow.service;

import com.fleetflow.dto.Clientdto;
import com.fleetflow.entity.Client;
import com.fleetflow.repository.ClientRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepo clientRepo;
    public ClientService(ClientRepo clientRepo){
        this.clientRepo=clientRepo;
    }

    public Client AddClient(Client client){
        return clientRepo.save(client);
    }
    public  Client findClientById(Long id){
        return clientRepo.findById(id).orElseThrow(()->new RuntimeException("Not found"));
    }

    public Clientdto findById(Long id){
        Optional<Client> client=this.clientRepo.findById(id);
        if(client.isPresent())
            return Clientdto.toDto(client.get());
        else return  null;
    }
}
