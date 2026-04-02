package com.fleetflow.service;

import com.fleetflow.dto.LivraisonRequestDTO;
import com.fleetflow.dto.LivraisonResponseDTO;
import com.fleetflow.entity.Livraison;
import com.fleetflow.entity.StatusLivraison;
import com.fleetflow.mapper.LivraisonMapper;
import com.fleetflow.repository.LivraisonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LivraisonService {
    private final LivraisonMapper livraisonMapper;
    private  final LivraisonRepo livraisonRepo;


    public LivraisonRequestDTO createLivraison(LivraisonRequestDTO livraisondto){
        Livraison createLivraison=livraisonMapper.toEntity(livraisondto);
        if(createLivraison.getStatusLivraison()== null){
            createLivraison.setStatusLivraison(StatusLivraison.ENATTENTE);
        }
        Livraison saveLivraison =livraisonRepo.save(createLivraison);
        return  livraisonMapper.toDto(saveLivraison);
    }

    public LivraisonRequestDTO assignerChauffeurEtVehicule(Long livraisonId, Long chauffeurId, Long vehiculeId) {
        Livraison livraison = livraisonRepo.findById(livraisonId).orElseThrow(() -> new RuntimeException("Livraison n'est pas trouvée"));
        livraison.setStatusLivraison(StatusLivraison.ENCOURS);
        return livraisonMapper.toDto(livraisonRepo.save(livraison));
    }

  public List<LivraisonResponseDTO> getAllLivraison(){
     List<Livraison> livraisons = livraisonRepo.findAll();
     //return livraisons.stream().map(livraisonMapper::toDto).toList();
     return livraisonMapper.toDto(livraisons);
  }

  public List<LivraisonResponseDTO> getBewteenTwoDates(LocalDate start ,LocalDate end){
        List<Livraison> livraisons = livraisonRepo.findByDateLivraisonBetween(start,end);
        return livraisonMapper.toDto(livraisons);
  }

}
