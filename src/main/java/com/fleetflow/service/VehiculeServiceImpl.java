package com.fleetflow.service;
import com.fleetflow.dto.VehiculeRequestDTO;
import com.fleetflow.dto.VehiculeResponseDTO;
import com.fleetflow.entity.StatutVehicule;
import com.fleetflow.entity.Vehicule;
import com.fleetflow.mapper.VehiculeMapper;
import com.fleetflow.repository.VehiculeRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements VehiculeService{

    private final VehiculeMapper mapper;
    private final VehiculeRepo repo;

    @Override
    @Transactional
    public VehiculeResponseDTO ajouterVehicule(VehiculeRequestDTO dto) {
        Vehicule vehicule = mapper.toEntity(dto);
        Vehicule savedVehicule = repo.save(vehicule);
        return mapper.toResponseDto(savedVehicule);
    }

    @Override
    @Transactional
    public Page<VehiculeResponseDTO> listeVehiculesDisponibles(Pageable pageable) {
        return repo.findByStatut(StatutVehicule.DISPONIBLE, pageable).map(mapper::toResponseDto);
    }

    @Override
    @Transactional
    public Page<VehiculeResponseDTO> findVehiculeByStatut(StatutVehicule statut, Pageable pageable) {
        return repo.findByStatut(statut, pageable).map(mapper::toResponseDto);
    }

    @Override
    @Transactional
    public Page<VehiculeResponseDTO> findCapaciteVehiculeGreaterThan(int capacite, Pageable pageable) {
        return repo.findByCapaciteGreaterThan(capacite, pageable).map(mapper::toResponseDto);
    }

    @Override
    @Transactional
    public void supprimerVehiculeById(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Vehicule non trouve");
        }
        repo.deleteById(id);
    }

    @Override
    @Transactional
    public VehiculeResponseDTO modifier(Long id, VehiculeRequestDTO dto) {
        Vehicule vehicule = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicule non trouve"));

        mapper.updateEntityFromDto(dto, vehicule);
        Vehicule updatedVehicule = repo.save(vehicule);
        return mapper.toResponseDto(updatedVehicule);
    }
}
