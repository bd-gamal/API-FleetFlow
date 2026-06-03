package com.fleetflow.service;

import com.fleetflow.dto.LivraisonRequestDTO;
import com.fleetflow.dto.LivraisonResponseDTO;
import com.fleetflow.dto.LivraisonStatutRequestDTO;
import com.fleetflow.entity.*;
import com.fleetflow.mapper.LivraisonMapper;
import com.fleetflow.repository.ChauffeurRepository;
import com.fleetflow.repository.ClientRepo;
import com.fleetflow.repository.LivraisonRepo;
import com.fleetflow.repository.VehiculeRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivraisonServiceImpl implements LivraisonService {

    private final LivraisonRepo repo;
    private final LivraisonMapper mapper;
    private final ClientRepo clientRepo;
    private final VehiculeRepo vehiculeRepo;
    private final ChauffeurRepository chauffeurRepo;

    @Override
    @Transactional
    public LivraisonResponseDTO createLivraison(LivraisonRequestDTO livraisondto){
        Livraison createLivraison=mapper.toEntity(livraisondto);
        if (livraisondto.getClientId() != null) {
            Client client = clientRepo.findById(livraisondto.getClientId())
                    .orElseThrow(() -> new RuntimeException("Client introuvable avec l'ID : " + livraisondto.getClientId()));
            createLivraison.setClient(client);
        }
        if(createLivraison.getStatut()== null){
            createLivraison.setStatut(StatutLivraison.EN_ATTENTE);
        }
        Livraison saveLivraison =repo.save(createLivraison);
        return  mapper.toResponseDto(saveLivraison);
    }

    @Override
    @Transactional
    public LivraisonResponseDTO modifierStatut(Long id, LivraisonStatutRequestDTO dto) {
        Livraison livraison = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Livraison non trouvee"));

        mapper.updateStatutFromDto(dto, livraison);
        Livraison updatedLivraison = repo.save(livraison);
        return mapper.toResponseDto(updatedLivraison);
    }

    @Override
    @Transactional
    public Page<LivraisonResponseDTO> getAllLivraisons(Pageable pageable){
        return repo.findAll(pageable).map(mapper::toResponseDto);
    }

    @Override
    @Transactional
    public Page<LivraisonResponseDTO> findByStatut(StatutLivraison statut, Pageable pageable) {
        return repo.findByStatut(statut, pageable).map(mapper::toResponseDto);
    }

    @Override
    @Transactional
    public Page<LivraisonResponseDTO> findByClientId(Long clientId, Pageable pageable) {
        return repo.findByClientId(clientId, pageable).map(mapper::toResponseDto);
    }

    @Override
    @Transactional
    public LivraisonResponseDTO assignerChauffeurEtVehicule(Long livraisonId, Long chauffeurId, Long vehiculeId) {
        Livraison livraison = repo.findById(livraisonId).orElseThrow(() -> new RuntimeException("Livraison n'est pas trouvée"));
        Chauffeur chauffeur = chauffeurRepo.findById(chauffeurId).orElseThrow(() -> new RuntimeException("Chauffeur introuvable"));
        Vehicule vehicule = vehiculeRepo.findById(vehiculeId).orElseThrow(() -> new RuntimeException("Véhicule introuvable"));
        livraison.setVehicule(vehicule);
        livraison.setChauffeur(chauffeur);
        livraison.setStatut(StatutLivraison.EN_COURS);
        return mapper.toResponseDto(repo.save(livraison));
    }

    @Override
    @Transactional
    public Page<LivraisonResponseDTO> getBewteenTwoDates(LocalDate start , LocalDate end, Pageable pageable){
        return repo.findByDateLivraisonBetween(start, end, pageable).map(mapper::toResponseDto);
    }

    @Override
    @Transactional
    public Page<LivraisonResponseDTO> listerLivraisonsParVilleDestination(String ville, Pageable pageable) {
        return repo.findLivraisonsParVilleDestination(ville, pageable).map(mapper::toResponseDto);
    }
}
