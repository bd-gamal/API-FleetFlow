package com.fleetflow.service;

import com.fleetflow.dto.Livraisondto;
import com.fleetflow.entity.Livraison;
import com.fleetflow.entity.StatusLivraison;
import com.fleetflow.mapper.LivraisonMapper;
import com.fleetflow.repository.LivraisonRepo;
import org.springframework.stereotype.Service;

@Service
public class LivraisonService {
    private final LivraisonMapper livraisonMapper;
    private  final LivraisonRepo livraisonRepo;

    public LivraisonService(LivraisonMapper livraisonMapper, LivraisonRepo livraisonRepo){
        this.livraisonRepo=livraisonRepo;
        this.livraisonMapper=livraisonMapper;
    }

    public Livraisondto createLivraison(Livraisondto livraisondto){
        Livraison createLivraison=livraisonMapper.toEntity(livraisondto);
        if(createLivraison.getStatusLivraison()== null){
            createLivraison.setStatusLivraison(StatusLivraison.ENATTENTE);
        }
        Livraison saveLivraison =livraisonRepo.save(createLivraison);
        return  livraisonMapper.toDto(saveLivraison);
    }


}
