package com.fleetflow.controller;

import com.fleetflow.dto.LivraisonRequestDTO;
import com.fleetflow.service.LivraisonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/livraison")
public class LivraisonController {
    private final LivraisonService livraisonService;
    public LivraisonController(LivraisonService livraisonService){
        this.livraisonService= livraisonService;
    }

    @PostMapping
    public ResponseEntity<LivraisonRequestDTO> createLivraion(@RequestBody LivraisonRequestDTO livraisonRequestDTO){
        LivraisonRequestDTO livraison = livraisonService.createLivraison(livraisonRequestDTO);
        return ResponseEntity.ok(livraison);
    }
}
