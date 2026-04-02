package com.fleetflow.controller;

import com.fleetflow.dto.LivraisonRequestDTO;
import com.fleetflow.dto.LivraisonResponseDTO;
import com.fleetflow.dto.LivraisonStatutRequestDTO;
import com.fleetflow.entity.StatutLivraison;
import com.fleetflow.service.LivraisonService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livraisons")
@RequiredArgsConstructor
public class LivraisonController {

    private final LivraisonService service;


    @PutMapping("/{id}/statut")
    @Operation(summary = "Modifier le statut d'une livraison")
    public LivraisonResponseDTO modifierStatut(@PathVariable Long id, @RequestBody LivraisonStatutRequestDTO dto) {
        return service.modifierStatut(id, dto);
    }

    @GetMapping("/statut/{statut}")
    @Operation(summary = "Trouver les livraisons par statut")
    public List<LivraisonResponseDTO> findByStatut(@PathVariable StatutLivraison statut) {
        return service.findByStatut(statut);
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "Trouver les livraisons par client")
    public List<LivraisonResponseDTO> findByClientId(@PathVariable Long clientId) {
        return service.findByClientId(clientId);
    }
}
