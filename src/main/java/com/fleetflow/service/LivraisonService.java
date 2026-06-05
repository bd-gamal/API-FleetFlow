package com.fleetflow.service;

import com.fleetflow.dto.LivraisonRequestDTO;
import com.fleetflow.dto.LivraisonResponseDTO;
import com.fleetflow.dto.LivraisonStatutRequestDTO;
import com.fleetflow.entity.StatutLivraison;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface LivraisonService {
    LivraisonResponseDTO createLivraison(LivraisonRequestDTO livraisondto);
    LivraisonResponseDTO modifierStatut(Long id, LivraisonStatutRequestDTO dto);
    Page<LivraisonResponseDTO> getAllLivraisons(Pageable pageable);
    Page<LivraisonResponseDTO> findByStatut(StatutLivraison statut, Pageable pageable);
    Page<LivraisonResponseDTO> findByClientId(Long clientId, Pageable pageable);
    LivraisonResponseDTO assignerChauffeurEtVehicule(Long livraisonId, Long chauffeurId, Long vehiculeId);
    Page<LivraisonResponseDTO> getBewteenTwoDates(LocalDate start, LocalDate end, Pageable pageable);
    Page<LivraisonResponseDTO> listerLivraisonsParVilleDestination(String ville, Pageable pageable);
}
