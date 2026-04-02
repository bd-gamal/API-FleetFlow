package com.fleetflow.repository;

import com.fleetflow.entity.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface LivraisonRepo extends JpaRepository<Livraison, Long> {

    @Query("select l from Livraison l where l.adresseDestination like %:ville%")
    List<Livraison> findLivraisonsByVilleDestination(@Param("ville") String ville);
}
