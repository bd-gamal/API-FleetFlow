package com.fleetflow.controller;
import com.fleetflow.dto.VehiculeRequestDTO;
import com.fleetflow.dto.VehiculeResponseDTO;
import com.fleetflow.entity.StatutVehicule;
import com.fleetflow.service.VehiculeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final VehiculeService service;

    @PostMapping
    @Operation(summary = "Ajouter un vehicule")
    public VehiculeResponseDTO ajouter(@RequestBody VehiculeRequestDTO dto) {
        return service.ajouterVehicule(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un vehicule")
    public VehiculeResponseDTO modifier(@PathVariable Long id, @RequestBody VehiculeRequestDTO dto) {
        return service.modifier(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un vehicule")
    public void supprimerVehicule(@PathVariable Long id) {
        service.supprimerVehiculeById(id);
    }

    @GetMapping("/disponibles")
    @Operation(summary = "Lister les vehicules disponibles")
    public List<VehiculeResponseDTO> listerDisponibles() {
        return service.listeVehiculesDisponibles();
    }

    @GetMapping("/statut/{statut}")
    @Operation(summary = "Trouver les vehicules par statut")
    public List<VehiculeResponseDTO> getVehiculeByStatut(@PathVariable StatutVehicule statut) {
        return service.findVehiculeByStatut(statut);
    }

    @GetMapping("/capacite/{capacite}")
    @Operation(summary = "Trouver les vehicules avec capacite superieure")
    public List<VehiculeResponseDTO> getVehiculeByCapacite(@PathVariable int capacite) {
        return service.findCapaciteVehiculeGreaterThan(capacite);
    }
}
