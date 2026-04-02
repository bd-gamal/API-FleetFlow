package com.fleetflow.service;

import com.fleetflow.dto.LivraisonRequestDTO;
import com.fleetflow.dto.LivraisonResponseDTO;
import com.fleetflow.dto.LivraisonStatutRequestDTO;
import com.fleetflow.entity.Livraison;
import com.fleetflow.entity.StatutLivraison;
import com.fleetflow.mapper.LivraisonMapper;
import com.fleetflow.repository.LivraisonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivraisonService {

    private final LivraisonRepo repo;
    private final LivraisonMapper mapper;

    public LivraisonResponseDTO modifierStatut(Long id, LivraisonStatutRequestDTO dto) {
        Livraison livraison = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Livraison non trouvee"));

        mapper.updateStatutFromDto(dto, livraison);
        Livraison updatedLivraison = repo.save(livraison);
        return mapper.toResponseDto(updatedLivraison);
    }

    public List<LivraisonResponseDTO> findByStatut(StatutLivraison statut) {
        return mapper.toResponseDtoList(repo.findByStatut(statut));
    }

    public List<LivraisonResponseDTO> findByClientId(Long clientId) {
        return mapper.toResponseDtoList(repo.findByClientId(clientId));
    }
}
