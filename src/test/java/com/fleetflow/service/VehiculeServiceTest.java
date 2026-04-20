package com.fleetflow.service;

import com.fleetflow.dto.VehiculeResponseDTO;
import com.fleetflow.entity.StatutVehicule;
import com.fleetflow.entity.Vehicule;
import com.fleetflow.mapper.VehiculeMapper;
import com.fleetflow.repository.VehiculeRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehiculeServiceTest {

    @Mock
    VehiculeRepo vehiculeRepo;

    @Mock
    VehiculeMapper mapper;

    @InjectMocks
    VehiculeService vehiculeService;

    @Test
    void listeVehiculesDisponibles(){

        //1.arrange
        Vehicule v1 = new Vehicule();
        v1.setStatut(StatutVehicule.DISPONIBLE);

        List<Vehicule> mockList = List.of(v1);

        when(vehiculeRepo.findByStatut(any()))
                .thenReturn(List.of(v1));

        when(mapper.toResponseDtoList(anyList()))
                .thenReturn(List.of(new VehiculeResponseDTO()));
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

        VehiculeResponseDTO dto = new VehiculeResponseDTO();
        dto.setCapacite(15);

        when(vehiculeRepo.findByCapaciteGreaterThan(10))
                .thenReturn(List.of(v1));

        when(mapper.toResponseDtoList(List.of(v1)))
                .thenReturn(List.of(dto));

        List<VehiculeResponseDTO> result =
                vehiculeService.findCapaciteVehiculeGreaterThan(capaciteMin);

        assertNotNull(result);
        assertEquals(1, result.size());

        assertTrue(result.get(0).getCapacite() > capaciteMin);
    }




}