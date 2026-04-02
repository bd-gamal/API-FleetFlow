package com.fleetflow.repository;

import com.fleetflow.entity.StatutVehicule;
import com.fleetflow.entity.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculeRepo extends JpaRepository<Vehicule, Long> {

    List<Vehicule> findByStatut(StatutVehicule statut);
    List<Vehicule> findByCapaciteGreaterThan(int capacite);
}
