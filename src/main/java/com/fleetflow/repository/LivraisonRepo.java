package com.fleetflow.repository;

import com.fleetflow.entity.Livraison;
import com.fleetflow.entity.StatutLivraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivraisonRepo extends JpaRepository<Livraison, Long> {
    List<Livraison> findByStatut(StatutLivraison statut);

    List<Livraison> findByClientId(Long clientId);
}
