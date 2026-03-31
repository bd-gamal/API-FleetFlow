package com.fleetflow.controller;

import com.fleetflow.dto.Clientdto;
import com.fleetflow.entity.Client;
import com.fleetflow.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class CLientController {
    private  final ClientService clientService;

    @PostMapping
    public ResponseEntity<Clientdto> createClient( @RequestBody Clientdto client){
        Clientdto create= clientService.addClient(client);
        return  ResponseEntity.ok(client);
    }

    @PutMapping("{id}")
    public  ResponseEntity<Clientdto> updateClient(@PathVariable Long id,@RequestBody Clientdto client){
        Clientdto updateClient= clientService.updateClient(id,client);
        return  ResponseEntity.ok(updateClient);
    }

    @GetMapping("/{id}")
    public  Clientdto getClientById(@PathVariable  Long id){
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
    public ResponseEntity<List<Clientdto>> getAllCients(){
        List<Clientdto> clients= clientService.getAllClient();
        return  ResponseEntity.ok(clients);
    }
}
