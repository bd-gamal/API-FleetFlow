package com.fleetflow.repository;

import com.fleetflow.entity.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface LivraisonRepo extends JpaRepository<Livraison, Long> {
@Query("select d from Livraison d where d.dateLivraison between :start and :end")
List<Livraison> findByDateLivraisonBetween(@Param("start") LocalDate start,@Param("end") LocalDate end);}
