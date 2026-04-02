package com.fleetflow.controller;

import com.fleetflow.dto.ClientRequestDTO;
import com.fleetflow.dto.ClientResponseDTO;
import com.fleetflow.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private  final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientRequestDTO> createClient(@RequestBody ClientRequestDTO client){
        ClientResponseDTO create= clientService.addClient(client);
        return  ResponseEntity.ok(client);
    }

    @PutMapping("{id}")
    public  ResponseEntity<ClientResponseDTO> updateClient(@PathVariable Long id, @RequestBody ClientRequestDTO client){
        ClientResponseDTO updateClient= clientService.updateClient(id,client);
        return  ResponseEntity.ok(updateClient);
    }

    @GetMapping("/{id}")
    public ClientResponseDTO getClientById(@PathVariable  Long id){
        return clientService.findById(id);
    }
//    public  ResponseEntity<Clientdto> getClientById(@PathVariable  Long id){
//        Clientdto client =clientService.findById(id);
//        return ResponseEntity.ok(client);
//    }
    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable Long id){
        clientService.deleteClient(id);
    }
//    public ResponseEntity<Void> deleteClientByID(@PathVariable Long id){
//        clientService.deleteClient(id);
//        return ResponseEntity.noContent().build();
//    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getAllCients(){
        List<ClientResponseDTO> clients= clientService.getAllClient();
        return  ResponseEntity.ok(clients);
    }
}
