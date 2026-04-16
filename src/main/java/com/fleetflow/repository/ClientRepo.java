package com.fleetflow.repository;

import com.fleetflow.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
    boolean existsByEmail(String email);
}
