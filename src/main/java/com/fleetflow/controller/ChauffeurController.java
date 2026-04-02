package com.fleetflow.controller;

import com.fleetflow.dto.ChauffeurRequestDTO;
import com.fleetflow.dto.ChauffeurResponseDTO;
import com.fleetflow.service.ChauffeurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/chauffeurs")
@RequiredArgsConstructor
public class ChauffeurController {
    private final ChauffeurService chauffeurService;

    @PostMapping
    public ResponseEntity<ChauffeurResponseDTO> ajouterChauffeur(@RequestBody ChauffeurRequestDTO dto) {
        return new ResponseEntity<>(chauffeurService.ajouterChauffeur(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChauffeurResponseDTO> modifierChauffeur(
            @PathVariable Long id,
            @RequestBody ChauffeurRequestDTO dto) {
        return ResponseEntity.ok(chauffeurService.modifierChauffeur(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerChauffeur(@PathVariable Long id) {
        chauffeurService.supprimerChauffeur(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ChauffeurResponseDTO>> listerTousLesChauffeurs() {
        return ResponseEntity.ok(chauffeurService.listerTousLesChauffeurs());
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<ChauffeurResponseDTO>> listerChauffeursDisponibles() {
        return ResponseEntity.ok(chauffeurService.listerChauffeursDisponibles());
    }
}
