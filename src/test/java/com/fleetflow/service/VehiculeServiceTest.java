package com.fleetflow.service;

import com.fleetflow.dto.VehiculeResponseDTO;
import com.fleetflow.entity.StatutVehicule;
import com.fleetflow.entity.Vehicule;
import com.fleetflow.repository.VehiculeRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehiculeServiceTest {

    @Mock
    VehiculeRepo vehiculeRepo;

    @InjectMocks
    VehiculeService vehiculeService;

    @Test
    void listeVehiculesDisponibles(){

        //1.arrange
        Vehicule v1 = new Vehicule();
        v1.setStatut(StatutVehicule.DISPONIBLE);

        List<Vehicule> mockList = List.of(v1);

        when(vehiculeRepo.findByStatut(StatutVehicule.DISPONIBLE)).thenReturn(mockList);

        //2. act
        List<VehiculeResponseDTO> result = vehiculeService.listeVehiculesDisponibles();

        //3. assert
        assertEquals(1, result.size(), "la liste doit contenir un seul élément");


    }

    @Test
    void findCapaciteVehiculeGreaterThan(){
        int capaciteMin = 10;


        Vehicule v1 = new Vehicule();
        v1.setCapacite(15);

        Vehicule v2 = new Vehicule();
        v2.setCapacite(5);


        when(vehiculeRepo.findByCapaciteGreaterThan(capaciteMin)).thenReturn(List.of(v1));

        List<VehiculeResponseDTO> result = vehiculeService.findCapaciteVehiculeGreaterThan(capaciteMin);

        assertNotNull(result);
        assertEquals(1,result.size(), "la liste doit contenir un seul élément");
        assertTrue(result.getFirst().getCapacite()>capaciteMin, "capacité doit être > 10");
    }




}