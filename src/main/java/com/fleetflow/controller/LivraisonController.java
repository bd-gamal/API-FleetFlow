package com.fleetflow.controller;

import com.fleetflow.dto.Clientdto;
import com.fleetflow.dto.LivraisonRequestDTO;
import com.fleetflow.dto.LivraisonResponseDTO;
import com.fleetflow.entity.Livraison;
import com.fleetflow.service.LivraisonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
    @PutMapping("/{id}/assigner")
    public ResponseEntity<LivraisonRequestDTO> assignerRessources(
            @PathVariable Long id,
            @RequestParam Long chauffeurId,
            @RequestParam Long vehiculeId) {
        return ResponseEntity.ok(livraisonService.assignerChauffeurEtVehicule(id, chauffeurId, vehiculeId));
    }
    @GetMapping
    public ResponseEntity<List<LivraisonResponseDTO>> getAllLivraison(){
        List<LivraisonResponseDTO> listLivraison=livraisonService.getAllLivraison();
        return ResponseEntity.ok(listLivraison);
    }

    @GetMapping("/between-dates")
    public List<LivraisonResponseDTO> getBetweenDates(@RequestParam LocalDate start,
                                                      @RequestParam LocalDate end){
        return livraisonService.getBewteenTwoDates(start, end);
    }
}
