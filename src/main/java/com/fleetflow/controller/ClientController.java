package com.fleetflow.controller;

import com.fleetflow.dto.ClientRequestDTO;
import com.fleetflow.dto.ClientResponseDTO;
import com.fleetflow.dto.Clientdto;
import com.fleetflow.service.ClientService;
import jakarta.validation.Valid;
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
    public ResponseEntity<ClientRequestDTO> createClient(@Valid @RequestBody ClientRequestDTO client){
        ClientResponseDTO create= clientService.addClient(client);
        return  ResponseEntity.ok(client);
    }

    @PutMapping("{id}")
    public  ResponseEntity<ClientResponseDTO> updateClient(@PathVariable Long id, @Valid @RequestBody ClientRequestDTO client){
        ClientResponseDTO updateClient= clientService.updateClient(id,client);
        return  ResponseEntity.ok(updateClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getClientById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientByID(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getAllCients(){
        List<ClientResponseDTO> clients= clientService.getAllClient();
        return  ResponseEntity.ok(clients);
    }
}
