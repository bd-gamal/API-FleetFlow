package com.fleetflow.service;

import com.fleetflow.dto.LivraisonRequestDTO;
import com.fleetflow.entity.Livraison;
import com.fleetflow.entity.StatusLivraison;
import com.fleetflow.mapper.LivraisonMapper;
import com.fleetflow.repository.LivraisonRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class LivraisonService {
    private final LivraisonMapper livraisonMapper;
    private  final LivraisonRepo livraisonRepo;

    public LivraisonService(LivraisonMapper livraisonMapper, LivraisonRepo livraisonRepo){
        this.livraisonRepo=livraisonRepo;
        this.livraisonMapper=livraisonMapper;
    }

    @Transactional
    public LivraisonRequestDTO createLivraison(LivraisonRequestDTO livraisonRequestDTO){
        Livraison createLivraison=livraisonMapper.toEntity(livraisonRequestDTO);
        if(createLivraison.getStatusLivraison()== null){
            createLivraison.setStatusLivraison(StatusLivraison.ENATTENTE);
        }
        Livraison saveLivraison =livraisonRepo.save(createLivraison);
        return  livraisonMapper.toDto(saveLivraison);
    }

    @Transactional
    public LivraisonRequestDTO assignerChauffeurEtVehicule(Long livraisonId, Long chauffeurId, Long vehiculeId) {
        Livraison livraison = livraisonRepo.findById(livraisonId).orElseThrow(() -> new RuntimeException("Livraison n'est pas trouvée"));
        livraison.setStatusLivraison(StatusLivraison.ENCOURS);
        return livraisonMapper.toDto(livraisonRepo.save(livraison));
    }
}
