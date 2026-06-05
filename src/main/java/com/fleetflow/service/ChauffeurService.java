package com.fleetflow.service;

import com.fleetflow.dto.ChauffeurRequestDTO;
import com.fleetflow.dto.ChauffeurResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChauffeurService {
    ChauffeurResponseDTO ajouterChauffeur(ChauffeurRequestDTO requestDTO);
    ChauffeurResponseDTO modifierChauffeur(Long id, ChauffeurRequestDTO requestDTO);
    void supprimerChauffeur(Long id);
    Page<ChauffeurResponseDTO> listerChauffeursDisponibles(Pageable pageable);
    Page<ChauffeurResponseDTO> listerTousLesChauffeurs(Pageable pageable);
}
