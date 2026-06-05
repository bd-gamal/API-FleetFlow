package com.fleetflow.controller;
import com.fleetflow.dto.VehiculeRequestDTO;
import com.fleetflow.dto.VehiculeResponseDTO;
import com.fleetflow.entity.StatutVehicule;
import com.fleetflow.service.VehiculeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Synthesizer;
import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final VehiculeService vehiculeService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<VehiculeResponseDTO> ajouterVehicule(@RequestBody VehiculeRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculeService.ajouterVehicule(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<VehiculeResponseDTO> modifierVehicule(@PathVariable Long id, @RequestBody VehiculeRequestDTO dto) {
        return ResponseEntity.ok(vehiculeService.modifier(id, dto));
    }

    @GetMapping("/disponibles")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<Page<VehiculeResponseDTO>> listerVehiculesDisponibles(
            @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(vehiculeService.listeVehiculesDisponibles(pageable));
    }

    @GetMapping("/statut/{statut}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<Page<VehiculeResponseDTO>> listerVehiculesParStatut(
            @PathVariable StatutVehicule statut,
            @PageableDefault(size = 10)Pageable pageable) {
        return ResponseEntity.ok(vehiculeService.findVehiculeByStatut(statut, pageable));
    }

    @GetMapping("/capacite")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<Page<VehiculeResponseDTO>> listerVehiculesParCapacite(
            @RequestParam int minimum,
            @PageableDefault(size = 10, direction = Sort.Direction.ASC)Pageable pageable) {
        return ResponseEntity.ok(vehiculeService.findCapaciteVehiculeGreaterThan(minimum, pageable));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> supprimerVehicule(@PathVariable Long id) {
        vehiculeService.supprimerVehiculeById(id);
        return ResponseEntity.noContent().build();
    }
}
