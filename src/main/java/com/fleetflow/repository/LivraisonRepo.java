package com.fleetflow.repository;

import com.fleetflow.entity.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivraisonRepo extends JpaRepository<Livraison, Long> {

}
