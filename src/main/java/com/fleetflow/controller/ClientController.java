package com.fleetflow.controller;

import com.fleetflow.dto.ClientRequestDTO;
import com.fleetflow.dto.ClientResponseDTO;
import com.fleetflow.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
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
    public ResponseEntity<Page<ClientResponseDTO>> getAllClients(
            @PageableDefault(size = 10, sort = "ville") Pageable pageable){
        return ResponseEntity.ok(clientService.getAllClients(pageable));
    }
}
