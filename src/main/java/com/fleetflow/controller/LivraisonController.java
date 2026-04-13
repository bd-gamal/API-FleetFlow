package com.fleetflow.controller;

import com.fleetflow.dto.LivraisonRequestDTO;
import com.fleetflow.dto.LivraisonResponseDTO;
import com.fleetflow.dto.LivraisonStatutRequestDTO;
import com.fleetflow.entity.StatutLivraison;
import com.fleetflow.service.LivraisonService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/livraisons")
@RequiredArgsConstructor
public class LivraisonController {

    private final LivraisonService service;

    @PostMapping
    public ResponseEntity<LivraisonResponseDTO> createLivraison(@Valid @RequestBody LivraisonRequestDTO livraisonRequestDTO){
        LivraisonResponseDTO livraison = service.createLivraison(livraisonRequestDTO);
        return ResponseEntity.ok(livraison);
    }

    @PutMapping("/{id}/assigner")
    public ResponseEntity<LivraisonResponseDTO> assignerRessources(
            @PathVariable Long id,
            @Valid @RequestParam Long chauffeurId,
            @Valid @RequestParam Long vehiculeId) {
        return ResponseEntity.ok(service.assignerChauffeurEtVehicule(id, chauffeurId, vehiculeId));
    }

    @GetMapping
    public ResponseEntity<List<LivraisonResponseDTO>> getAllLivraison(){
        List<LivraisonResponseDTO> listLivraison=service.getAllLivraison();
        return ResponseEntity.ok(listLivraison);
    }

    @PutMapping("/{id}/statut")
    @Operation(summary = "Modifier le statut d'une livraison")
    public LivraisonResponseDTO modifierStatut(@PathVariable Long id, @Valid @RequestBody LivraisonStatutRequestDTO dto) {
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

    @GetMapping("/between-dates")
    public List<LivraisonResponseDTO> getBetweenDates(@RequestParam LocalDate start, @RequestParam LocalDate end){
        return service.getBewteenTwoDates(start, end);
    }

    @GetMapping("/recherche/ville")
    public ResponseEntity<List<LivraisonResponseDTO>> listerLivraisonsParVille(@RequestParam String ville) {
        List<LivraisonResponseDTO> livraisons = service.listerLivraisonsParVilleDestination(ville);
        return ResponseEntity.ok(livraisons);
    }
}
