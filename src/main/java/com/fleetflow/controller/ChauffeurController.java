package com.fleetflow.controller;

import com.fleetflow.dto.ChauffeurRequestDTO;
import com.fleetflow.dto.ChauffeurResponseDTO;
import com.fleetflow.service.ChauffeurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/chauffeurs")
@RequiredArgsConstructor
public class ChauffeurController {
    private final ChauffeurService chauffeurService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ChauffeurResponseDTO> ajouterChauffeur(@Valid @RequestBody ChauffeurRequestDTO dto) {
        return new ResponseEntity<>(chauffeurService.ajouterChauffeur(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ChauffeurResponseDTO> modifierChauffeur(
            @PathVariable Long id,
            @Valid @RequestBody ChauffeurRequestDTO dto) {
        return ResponseEntity.ok(chauffeurService.modifierChauffeur(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> supprimerChauffeur(@PathVariable Long id) {
        chauffeurService.supprimerChauffeur(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<Page<ChauffeurResponseDTO>> listerTousLesChauffeurs(
            @PageableDefault(size = 10, sort = "permisType")Pageable pageable) {
        return ResponseEntity.ok(chauffeurService.listerTousLesChauffeurs(pageable));
    }

    @GetMapping("/disponibles")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<Page<ChauffeurResponseDTO>> listerChauffeursDisponibles(
            @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(chauffeurService.listerChauffeursDisponibles(pageable));
    }
}
