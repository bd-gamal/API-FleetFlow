package com.fleetflow.repository;

import com.fleetflow.entity.Livraison;
import com.fleetflow.entity.StatutLivraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LivraisonRepo extends JpaRepository<Livraison, Long> {
    List<Livraison> findByStatut(StatutLivraison statut);

    List<Livraison> findByClientId(Long clientId);

    @Query("select d from Livraison d where d.dateLivraison between :start and :end")
    List<Livraison> findByDateLivraisonBetween(@Param("start") LocalDate start,@Param("end") LocalDate end);

    @Query("SELECT l FROM Livraison l WHERE l.adresseDestination LIKE %:ville%")
    List<Livraison> findLivraisonsParVilleDestination(@Param("ville") String ville);
}
