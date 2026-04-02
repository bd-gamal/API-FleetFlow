package com.fleetflow.service;

import com.fleetflow.dto.LivraisonRequestDTO;
import com.fleetflow.dto.LivraisonResponseDTO;
import com.fleetflow.dto.LivraisonStatutRequestDTO;
import com.fleetflow.entity.Livraison;
import com.fleetflow.entity.StatutLivraison;
import com.fleetflow.mapper.LivraisonMapper;
import com.fleetflow.repository.LivraisonRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivraisonService {

    private final LivraisonRepo repo;
    private final LivraisonMapper mapper;

    @Transactional
    public LivraisonResponseDTO createLivraison(LivraisonRequestDTO livraisondto){
        Livraison createLivraison=mapper.toEntity(livraisondto);
        if(createLivraison.getStatut()== null){
            createLivraison.setStatut(StatutLivraison.EN_ATTENTE);
        }
        Livraison saveLivraison =repo.save(createLivraison);
        return  mapper.toResponseDto(saveLivraison);
    }

    @Transactional
    public LivraisonResponseDTO modifierStatut(Long id, LivraisonStatutRequestDTO dto) {
        Livraison livraison = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Livraison non trouvee"));

        mapper.updateStatutFromDto(dto, livraison);
        Livraison updatedLivraison = repo.save(livraison);
        return mapper.toResponseDto(updatedLivraison);
    }

    @Transactional
    public List<LivraisonResponseDTO> getAllLivraison(){
        List<Livraison> livraisons = repo.findAll();
        //return livraisons.stream().map(livraisonMapper::toDto).toList();
        return mapper.toResponseDtoList(livraisons);
    }

    public List<LivraisonResponseDTO> findByStatut(StatutLivraison statut) {
        return mapper.toResponseDtoList(repo.findByStatut(statut));
    }

    public List<LivraisonResponseDTO> findByClientId(Long clientId) {
        return mapper.toResponseDtoList(repo.findByClientId(clientId));
    }

    public LivraisonResponseDTO assignerChauffeurEtVehicule(Long livraisonId, Long chauffeurId, Long vehiculeId) {
        Livraison livraison = repo.findById(livraisonId).orElseThrow(() -> new RuntimeException("Livraison n'est pas trouvée"));
        livraison.setStatut(StatutLivraison.EN_COURS);
        return mapper.toResponseDto(repo.save(livraison));
    }

    public List<LivraisonResponseDTO> getBewteenTwoDates(LocalDate start , LocalDate end){
        List<Livraison> livraisons = repo.findByDateLivraisonBetween(start,end);
        return mapper.toResponseDtoList(livraisons);
    }

    public List<LivraisonResponseDTO> listerLivraisonsParVilleDestination(String ville) {
        return repo.findLivraisonsParVilleDestination(ville).stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
