package com.fleetflow.service;

import com.fleetflow.dto.Livraisondto;
import com.fleetflow.entity.Livraison;
import com.fleetflow.entity.StatusLivraison;
import com.fleetflow.mapper.LivraisonMapper;
import com.fleetflow.repository.LivraisonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivraisonService {
    private final LivraisonMapper livraisonMapper;
    private  final LivraisonRepo livraisonRepo;


    public Livraisondto createLivraison(Livraisondto livraisondto){
        Livraison createLivraison=livraisonMapper.toEntity(livraisondto);
        if(createLivraison.getStatusLivraison()== null){
            createLivraison.setStatusLivraison(StatusLivraison.ENATTENTE);
        }
        Livraison saveLivraison =livraisonRepo.save(createLivraison);
        return  livraisonMapper.toDto(saveLivraison);
    }



  public List<Livraisondto> getAllLivraison(){
     List<Livraison> livraisons = livraisonRepo.findAll();
     //return livraisons.stream().map(livraisonMapper::toDto).toList();
     return livraisonMapper.toDto(livraisons);
  }
}
