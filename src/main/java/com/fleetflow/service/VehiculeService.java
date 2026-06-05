package com.fleetflow.service;

import com.fleetflow.dto.VehiculeRequestDTO;
import com.fleetflow.dto.VehiculeResponseDTO;
import com.fleetflow.entity.StatutVehicule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VehiculeService {
    VehiculeResponseDTO ajouterVehicule(VehiculeRequestDTO dto);
    Page<VehiculeResponseDTO> listeVehiculesDisponibles(Pageable pageable);
    Page<VehiculeResponseDTO> findVehiculeByStatut(StatutVehicule statut, Pageable pageable);
    Page<VehiculeResponseDTO> findCapaciteVehiculeGreaterThan(int capacite, Pageable pageable);
    void supprimerVehiculeById(Long id);
    VehiculeResponseDTO modifier(Long id, VehiculeRequestDTO dto);
}
